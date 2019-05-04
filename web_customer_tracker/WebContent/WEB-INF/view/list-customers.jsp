<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="jstlform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relationship Manager</h2>
</div>
</div>

<div id="container">
<div id="content">

<input type="button" value="Add Customer" onclick="window.location.href='showform';return false;" class="add-button">

<!-- adding search box -->
<jstlform:form action="search" method="GET">
Search Customer :<input type="text" name="theSearchName"/>
<input type="submit" value="search" class="add-button"/>
</jstlform:form>

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>

<!-- loop over and print the customers -->
<jstl:forEach items="${customers}" var="temp">

<!--creating update link  -->
<jstl:url var="updatelink" value="/customer/showformforupdate">
<jstl:param name="customerid" value="${temp.id}">
</jstl:param>
</jstl:url>

<!-- creating delete link -->
<jstl:url var="deletelink" value="/customer/delete">
<jstl:param name="customerid" value="${temp.id}">
</jstl:param>
</jstl:url>

<tr>
<td>${temp.firstname}</td>
<td>${temp.lastname}</td>
<td>${temp.email}</td>

<!-- display update link -->
<td>
<a href="${updatelink}">Update </a>|
<a href="${deletelink}" onclick="if(!(confirm('Are you sure to delete the customer?'))) return false">Delete</a>
</td>
</tr>
</jstl:forEach>
</table>
</div>
</div>
</body>
</html>