<%--
  Created by IntelliJ IDEA.
  User: sirius
  Date: 05.11.18
  Time: 6:23
  To change this template use File | Settings | File Templates.
--%>
<%@page import="TestDB"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%>
<%="Привет"%>
<h3>
    <%=request.getParameter("username")%>
</h3>
<h3>
    ${param["password"]}
</h3>
</body>
</html>
