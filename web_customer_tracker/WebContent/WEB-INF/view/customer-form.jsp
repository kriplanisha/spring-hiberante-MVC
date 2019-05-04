<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="jstl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relationship Manager</h2>
</div>
</div>
<div id="container">
<h3>Save Customer</h3>
<jstl:form action="savecustomer" modelAttribute="customer" method="post">

<!-- associate this data with id -->
<jstl:hidden path="id"/>

<table>
<tbody>
<tr>
<td><label>First Name:</label></td>
<td><jstl:input path="firstname"/></td>
</tr>
<tr>
<td><label>Last Name:</label></td>
<td><jstl:input path="lastname"/></td>
</tr>
<tr>
<td><label>Email:</label></td>
<td><jstl:input path="email"/></td>
</tr>
<tr>
<td><label></label></td>
<td><input type="submit" value="Save" class="save"/></td>
</tr>
</tbody>
</table>
</jstl:form>
<div style="clear;both;">
<p>
<a href="${pageContext.request.contextPath}/customer/list">Back to List of customers</a>
</div>


</div>
</body>
</html>