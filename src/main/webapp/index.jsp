<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <jsp:include page="login.jsp" />
</body>
</html>
