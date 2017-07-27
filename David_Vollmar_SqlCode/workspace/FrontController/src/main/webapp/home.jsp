<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- Directive scriplet to include JSTL core library --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Java</title>
</head>
<body>
<!-- Expression Language (Doesn't need JSTL library to work) -->
Welcome to the Java: ${ loggedCustomer.firstName }


<input id="username" name="username" />
<button id="checkButton">Check</button>
<h3 id="message"></h3>

<script src='resources/js/checkUsername.js'></script>
</body>
</html>