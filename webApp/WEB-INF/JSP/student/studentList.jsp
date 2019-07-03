<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	
	<a href="/student/web?cmd=edit">添加</a>
	<table border="1" width= 50%>
		<tr bgcolor="orange" >
			<th>编号</th>
			<th>名字</th>
			<th>年龄</th>
			<th colspan="2" >操作</th>
		</tr>

		<c:forEach items="${list}" var="stu" >
			<tr align="center" >
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td>
					<a href="/student/web?cmd=edit&id=${stu.id}">编辑</a>
				</td>
				<td>
					<a href="/student/web?cmd=delete&id=${stu.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>