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
            <td class="bordered-td"><c:out value="${task.taskName}"/></td>
            <td>
                <c:out value="${task.isDone}"/>
            </td>
            <td><a href="/edit-task${task.id}">Edit</a></td>
            <td><a href="/delete-task${task.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${empty task.taskName}">
    <div class="web-form">
        <h3>Add new task</h3>
        <form:form method="post" modelAttribute="task" action="/add-task">
            <form:input path="taskName" placeholder="Task name"/>
            <br>
            <form:checkbox path="isDone" label="Is Done?"/>
            <br>
            <button>Add new task</button>
        </form:form>
    </div>
</c:if>
<c:if test="${!empty task.taskName}">
    <div class="web-form">
        <h3>Edit task</h3>
        <form:form method="post" modelAttribute="task" action="/update-task">
            <form:input path="taskName" value="${task.taskName}"/>
            <br>
            <form:checkbox path="isDone" label="Is Done?" value="${task.isDone}"/>
            <br>
            <form:input type="hidden" path="id" value="${task.id}"/>
            <button>Edit task</button>
        </form:form>
    </div>
</c:if>
<div class="web-form">
    <form action="/show" method="post">
        <input type="radio" name="show" value="2" checked>Show all<br>
        <input type="radio" name="show" value="1">Show completed<br>
        <input type="radio" name="show" value="0">Show uncompleted<br>
        <button>Submit</button>
    </form>
</div>
</body>
</html>