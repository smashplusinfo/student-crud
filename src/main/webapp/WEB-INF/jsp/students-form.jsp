<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 14/09/22
  Time: 1:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <spring:form name="student" modelAttribute="student">
       Name <spring:input path="name"/>
       City <spring:input path="city"/>
        <spring:button value="submit">Submit</spring:button>
   </spring:form>
</body>
</html>
