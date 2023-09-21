<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit driver details</title>
</head>
<body>
<form:form action="update" modelAttribute="dvr">

 <form:hidden path="did"/>
FirstName : <form:input path="firstName"/><br><br>

LastName  : <form:input path="lastName"/><br><br>

LicenceNo : <form:input path="licenceNo"/> <br><br>

PhoneNo : <form:input path="phoneNumber"/> <br><br>
PreferredRoute : <form:input path="preferredRoute"/> <br><br>



<input type="submit" value="EditDriver">



</form:form>

<a href="viewAll">ViewAllDrivers </a>
</body>
</html>