<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Locations</h2>

<table>
  <tr>
    <th>Id</th>
    <th>Code</th>
    <th>Name</th>
    <th>Type</th>
  </tr>
 <c:forEach items="${loc}" var="location">
  <tr>
   <td>${location.id}</td>
   <td>${location.code}</td>
   <td>${location.name}</td>
   <td>${location.type}</td>
   <td><a href="del?id=${location.id}">Delete</a></td>
   <td><a href="edit?id=${location.id}">Edit</a></td>
  </tr>
 </c:forEach> 
</table>
<a href="show">Create New Location</a>
</body>
</html>