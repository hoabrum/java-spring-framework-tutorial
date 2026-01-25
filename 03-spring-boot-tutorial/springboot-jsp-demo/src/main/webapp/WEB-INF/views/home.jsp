
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="${pageContext.request.contextPath}/resources/css/main.css"
      rel="stylesheet" type="text/css">

<html>
<title>Home Page</title>
<head>

</head>
<body>
<h1>Welcome to Spring Boot and JSP</h1>
<h2><c:out value="${message}"></c:out></h2>
</body>
</html>