<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form method="POST" action="/login.jsp">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password"><br><br>
    <input type="submit" value="Submit">
</form>


<% if (request.getParameter("username") == null || request.getParameter("password") == null) {

} else if (request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")){
    response.sendRedirect("/profile.jsp");
} else {
    response.getWriter().println("<h6>Incorrect input</h6>");
}%>