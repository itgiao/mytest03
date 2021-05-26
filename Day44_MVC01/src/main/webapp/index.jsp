<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/5/22
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>提交简单的参数：</h2>
<form action="simple">
    用户名：<input type="text" name="username"/><br/>
    密 码：<input type="text" name="password"/><br/>
    <input type="submit">
</form>
<hr/>
<h2>提交简单的参数：01</h2>
<form action="obj">
    用户名：<input type="text" name="username"/><br/>
    密 码：<input type="text" name="password"/><br/>
    <input type="submit">
</form>
<hr/>
<h2>提交数组的参数：</h2>
<form action="array">
    爱好：
    <input type="checkbox" name="hobby" value="唱"> 唱
    <input type="checkbox" name="hobby" value="跳"> 跳
    <input type="checkbox" name="hobby" value="rap"> rap
    <input type="checkbox" name="hobby" value="敲代码"> 敲代码 <br/>
    <input type="submit"/>
</form>
<hr/>
<h2>提交对象参数（包含对象）：</h2>
<form action="obj01">
    账户名: <input type="text" name="name"/><br/>
    金  额: <input type="text" name="money"/><br/>

    省  份: <input type="text" name="address.province"/><br/>
    城  市: <input type="text" name="address.city"/><br/>
    <input type="submit"/>
</form>
<br>
<h2>提交对象参数（包含List）：</h2>
<form action="obj02">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    年  龄: <input type="text" name="age"/><br/>

    第一个账户的名称：<input type="text" name="accountList[0].name"/><br/>
    第一个账户的金额：<input type="text" name="accountList[0].money"/><br/>

    第二个账户的名称：<input type="text" name="accountList[3].name"/><br/>
    第二个账户的金额：<input type="text" name="accountList[3].money"/><br/>

    <input type="submit"/>

</form>
<hr/>
<h2>提交对象参数（包含Map）：</h2>
<form action="object03">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    年  龄: <input type="text" name="age"/><br/>

    第一个账户的名称：<input type="text" name="accountMap['aa'].name"/><br/>
    第一个账户的金额：<input type="text" name="accountMap['aa'].money"/><br/>

    第二个账户的名称：<input type="text" name="accountMap['cc'].name"/><br/>
    第二个账户的金额：<input type="text" name="accountMap['cc'].money"/><br/>
    <input type="submit"/>
</form>
<hr/>
<h2>提交数据包含日期类型</h2>
<form action="register" method="get">
    用户名：<input type="text" name="username"><br>
    密 码：<input type="text" name="password"><br>
    生 日：<input type="date" name="birthday"><br>
    <input type="submit">
</form>
<hr>
<h2>提交数据,后台使用原始的ServletAPI来获取：</h2>
<form action="register02" method="get">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>

    <input type="submit"/>
</form>
</body>
</html>
