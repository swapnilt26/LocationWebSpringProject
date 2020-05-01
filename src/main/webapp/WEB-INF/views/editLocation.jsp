<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="post">
<pre>
Id:  <input type="text" name="id" readonly="readonly" value="${loc.id}"/>
Code:  <input type="text" name="code" value="${loc.code}"/>
Name:  <input type="text" name="name" value="${loc.name}"/>
Type:  Urban<input type="radio" name="type" value="URBAN" ${loc.type=='URBAN'?'checked':''}/>
		Rural<input type="radio" name="type" value="RURAL" ${loc.type=='RURAL'?'checked':''}/>
<input type="submit" value="Save"/>
</pre>
</form>
</body>
</html>