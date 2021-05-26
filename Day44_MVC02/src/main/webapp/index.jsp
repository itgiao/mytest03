<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/5/23
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>使用post方式提交数据: @RequestBody</h2>
<form action="controller01/requestBody" method="post">
  用户名：<input type="text" name="username"/><br/>
  密  码：<input type="text" name="password"/><br/>
  <input type="submit"/>
</form>
<hr/>
<input type="button" value="点我提交json数据" onclick="sendJson()">
<script src="js/axios-0.18.0.js"></script>
<script>
    function sendJson(){
        var data = { "username":"zhangsan","password":18380 }
        axios.post("getJsonData" , data);
    }
</script>
<hr/>
<a href="user/delete/1">测试PathVaribale</a><br/>
<hr/>
<a href="requestHeader">测试RequestHeader</a><br/>
<hr/>
<a href="cookieValue">测试CookieValue</a><br/>
</body>
</html>
