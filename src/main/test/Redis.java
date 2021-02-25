import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

/**
 * @author Wh
 * @title redis案例
 * @description
 * @createTime 2021年02月22日 15:05:00
 * @modifier：Wh
 * @modification_time：2021-02-22 15:05
 */
public class Redis {

    /**
     * 如果连接失败：
     *  1、检查redis是否启动
     *  2、防火墙是否关闭
     *  3、redis的bind模式和protected-mode是否关闭
     * @param args
     */
    public static void main(String[] args) {
        //操作redis
        //1、建立和redis的连接获取连接对象
        //参数1：redis启动所在的服务器ip地址，参数2：redis的端口号
        Jedis jedis =  new Jedis("192.168.2.128",6379);
        //2、通过连接对象发送redis的命令让redis执行
        String ping = jedis.ping();
        System.out.println(ping);
        //3、关闭redis连接
        jedis.close();
    }
     /**
      * @Author: Wh
      * @Date: 2021/2/22 16:32
      * @Description: 分数排行榜
      * @Modifier: Wh
      * @Modify_Date: 2021/2/22 16:32
      * @Param: []
      * @Return: void
      */
    @Test
   public void redis1(){
        Jedis jedis =  new Jedis("192.168.2.63",6379);
        HashMap<String,Double> map = new HashMap<String, Double>();
        map.put("k1",100.0);
        map.put("k2",90.0);
        map.put("k3",80.0);
        map.put("k4",70.0);
        map.put("k5",60.0);
        map.put("k6",50.0);
        jedis.zadd("scores",map);
        //2、查询zset中的数据：查询分数前三名的学生信息
        //Tuple就代表set中的值和他的分数
        Set<Tuple> sets =  jedis.zrevrangeWithScores("scores",0,2);
        for (Tuple tuple:sets){
            System.out.println("学生="+tuple.getElement()+"分数="+tuple.getScore());
        }
        //3、删除zset：键操作
        //jedis.del("scores");
        jedis.close();
    }

}
