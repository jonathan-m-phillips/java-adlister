<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp"/>
<div>
    <h1>Ads:</h1>
    <ul>
        <c:forEach var="ad" items="${allAds}">
            <li class="list-group-item list-group-item-action">
                ${ad.title}
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
