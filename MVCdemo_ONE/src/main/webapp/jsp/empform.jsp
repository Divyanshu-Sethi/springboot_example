<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
<div align="center">
<h2>Employee Registration</h2>
<form:form action="/empwebcontrol/empp" method="post" modelAttribute="employee">
<form:label path="empid">Emp Id:</form:label>
<form:input path="empid"/><br/>
<form:label path="empName">Emp name:</form:label>
<form:input path="empName"/><br/>
<form:label path="empSalary">Emp Salary:</form:label>
<form:input path="empSalary"/><br/>
<form:label path="joindate">Joining Date (yyyy-mm-dd):</form:label>
<form:input path="joindate"/><br/>

<form:label path="empSalary">Emp Salary:</form:label>

<form:button>Register Emp</form:button>
</form:form>
</div>
</body>
</html>