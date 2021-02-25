package com.km.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
public class SkController {


    @PostMapping("/doSk")
    @ResponseBody
    public String sk(String pids){
        //1、获取请求参数：  商品id ， 用户id(随机生成)
        String data="";
        String pid = pids;
        String uid = (int)(10000*Math.random())+"";
        //2、加载LUA脚本 并传入获取的参数，交给redis执行   LUA脚本交给redis后会当做一个整体来执行，不会被打断(redis单线程)
        //2.1 使用jedis加载lua脚本字符串
         Jedis jedis = new Jedis("192.168.2.128", 6379);
        //Jedis jedis = JedisPoolUtil.getJedisPoolInstance().getResource();
       // String sha1 = jedis.scriptLoad(secKillScript);
        //2.2 使用jedis执行lua脚本
        //参数1：加密过的LUA脚本字符串 ，参数2：脚本执行时需要的参数的数量   参数3：脚本执行时需要参数的实参列表
        //Object result = jedis.evalsha(sha1, 2, uid, pid);//返回值脚本执行时return的内容
        long code = 1;
        if(code == 1){
            data="200";
        }else if(code == 0){
            data="10003";
        }else if(code == 2 ){
            data="10001";
        }
        //jedis.close();//从连接池获取的jedis对象关闭时会自动还给连接池
        return data;
    }

    @PostMapping("/docks")
    @ResponseBody
    public String kk(String pids){
        String data="";
        //1、获取请求参数：  商品id ， 用户id(随机生成)
        String pid = pids;
        String uid = (int)(10000*Math.random())+"";
        System.out.println("uid = " + uid+" , pid = "+ pid);
        //拼接  库存key和 秒杀商品用户列表的key
        String qtKey = "sk:"+ pid + ":qt";
        String usrsKey = "sk:" + pid +":usr";
        //2、判断用户是否重复秒杀[用户会存在redis中  set]
        Jedis jedis = new Jedis("192.168.2.128", 6379);
        Boolean sismember = jedis.sismember(usrsKey, uid);
        if(sismember){
            //用户重复秒杀
            System.err.println("userid为："+uid +" 重复秒杀了....");
            data="10001";
            return data;//结束当前方法
        }
        //3、判断库存是否足够
        String qtStr = jedis.get(qtKey);
        if(qtStr==null || qtStr.length()==0){
            //库存值没有获取到，秒杀还未开始
            System.err.println("userid为："+uid +" 秒杀尚未开始....");
            data="10002";
            return data;//结束当前方法
        }
        int qt = Integer.parseInt(qtStr);
        if(qt<=0){
            //库存不足
            System.err.println("userid为："+uid +" 库存不足....  qt: "+qt);
            data="10003";
            return data;//结束当前方法
        }
        //4、秒杀
        //将用户添加到秒杀成功的set中
        jedis.sadd(usrsKey , uid);
        //减库存
        jedis.decr(qtKey);
        //响应
        System.out.println(uid+  ": 秒杀成功..");
        data="200";
        return data;
    }

}
