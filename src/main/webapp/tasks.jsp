<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title>Tasks Manager</title>
</head>
<body>

<h2>Tasks Manager</h2>
<table class="bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Task name</th>
        <th>Is done?</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td><c:out value="${task.id}"/></td>
            <td><c:out value="${task.taskName}"/></td>
            <td>
                <c:out value="${task.isDone == 1 ? 'true' : 'false'}"/>
            </td>
            <td><a href="#">Edit</a></td>
            <td><a href="#">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<br>
<form:form method="post" modelAttribute="task" action="/">
    <form:input path="taskName" placeholder="Task name"/>
    <%--<form:checkbox path="isDone"/>--%>

    <button>Add new task</button>
</form:form>
<br>
</body>
</html>