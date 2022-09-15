<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
</head>
<body>
    <h1>Student information management</h1>
<h3>List Of Students</h3><a href="/enter-student-info">Enter student info</a>
    <table border="1">
<c:forEach items="${students}" var="student">
    <tr >
        <td>${student.id}</td><td><a href="/edit/${student.id}">edit</a> </td>
        <td><a href="/student/${student.id}">${student.name}</a> </td>
        <td>${student.city}</td>
        <td>

            <form:form method="DELETE" action="/delete/${student.id}" modelAttribute="student">
                <input type="submit" value="DELETE"/>
            </form:form>
        </td>
    </tr>
</c:forEach>
    </table>
</body>
</html>
