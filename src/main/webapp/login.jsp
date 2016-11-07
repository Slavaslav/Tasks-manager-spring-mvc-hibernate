<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title>Login</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input type="text" placeholder="Name"/>
            <input type="password" placeholder="Password"/>
            <input type="text" placeholder="E-mail address"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form:form method="post" commandName="task" action="login-result" class="login-form">
            <form:input path="taskName" placeholder="Task name"/>
            <form:password path="isDone" placeholder="Password"/>
            <input type="submit" value="Login">
        </form:form>
    </div>
</div>
</body>
</html>