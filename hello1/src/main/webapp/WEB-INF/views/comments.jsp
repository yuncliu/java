<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
    <head><title>Hello :: Spring Application</title></head>
    <body>
    <h1>${msg}</h1>
    <ul>
        <c:forEach var="item" items="${comments}" >
            <li><p>${item}</p></li>
        </c:forEach>
    </ul>
    </body>
</html>
