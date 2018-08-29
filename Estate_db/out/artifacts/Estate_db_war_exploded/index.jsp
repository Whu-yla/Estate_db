<%--
  Created by IntelliJ IDEA.
  User: Hugo
  Date: 2018/8/29
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>参数提交页面</title>
</head>
<body >
<form action="getHouseBySchool_Servlet"  method="post"  style="padding-top:-700px;">
  需要查询的SchoolID：<input type="text" name="SchoolID"value=""><br><br>
  <input type="submit"value="确定"name="confirm"><input type="reset"value="重置"><br>
</form>

</body>
</html>
