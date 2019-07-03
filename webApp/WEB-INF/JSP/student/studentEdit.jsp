<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/student/web?cmd=save" method="POST" >
		<input type="text" hidden="hidden" name="id" value="${student.id}" >
		账号：<input type="text" name="name" value="${student.name}" >
		<br />
		年龄：<input type="text" name="age" value="${student.age}" >
		<br />
		<input type="submit" value=${student == null ? "保存新增用户" : "保存编辑用户"} >
	</form>
</body>
</html>