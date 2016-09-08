<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<head>
    <title>Hello :: Spring Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
    <body>
        <h1>This is tmp</h1>
        <p th:text="'Hello, ' + ${name} + '!'" />
    </body>
</html>
