<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr>
<h2>Read existing User</h2>
<table>
    <tr>
        <td>ID:</td>
        <td><b>${user.id}</b></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><b>${user.name}</b></td>
    </tr>
    <tr>
        <td>Lastname:</td>
        <td><b>${user.lastname}</b></td>
    </tr>
    <tr>
        <td>Age:</td>
        <td><b>${user.age}</b></td>
    </tr>
</table>
</body>
</html>