<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><c:out value="${person.firstName}"></c:out></title>
    </head>
    <body>
        <h1>
        	<c:out value="${person.firstName}"></c:out>
        	<span> </span>
        	<c:out value="${person.lastName}"></c:out>
       	</h1>
        <p>License Number: <fmt:formatNumber pattern="000000" value="${person.license.id}" /></p>
        <p>State: <c:out value="${person.license.state}"></c:out></p>
        <p>Expiration: <fmt:formatDate pattern="MM/dd/yyyy" value="${person.license.expirationDate}" /></p>
    </body>
</html>