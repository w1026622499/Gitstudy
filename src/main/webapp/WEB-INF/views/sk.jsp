<%--
  Created by IntelliJ IDEA.
  User: xugang2
  Date: 2020/6/30
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>秒杀页面</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/docks">
        <input type="hidden" name="pids" value="1001"/>
        <input type="button" value="点击参与1元秒杀华为MATE30PRO 5G"/>
    </form>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $("form :button").click(function () {
            $.ajax({
                "type":"POST",
                "url": $("form").prop("action"),
                "data":$("form").serialize(),
                "success": function (data) {
                    if(data=="200"){
                        alert("秒杀成功");
                    }else if(data=="10001"){
                        alert("请勿重复秒杀");
                    }else if(data=="10002"){
                        alert("秒杀尚未开始");
                    }else if(data=="10003"){
                        alert("库存不足");
                    }
                }
            });
        });
    
    </script>
</body>
</html>
