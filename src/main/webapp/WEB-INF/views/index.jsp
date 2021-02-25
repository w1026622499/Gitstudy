<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello!</h2>
<form action="http://localhost:8080/file" method="post" enctype="multipart/form-data">
      名称<input type="text" name="username">
      文件<input type="file" name="file">
    <input type="submit" value="提交">
</form>
${username}
</body>
</html>
