<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<div>
    <h1>Users</h1>
</div>
<div>
    <table border="1">
        <thead>
        <tr>
            <td><b>ID</b></td>
            <td><b>Name</b></td>
            <td><b>Lastname</b></td>
            <td><b>Age</b></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="./users?id=${user.id}"><c:out value="${user.name}"/></a></td>
                <td><c:out value="${user.lastname}"/></td>
                <td>${user.age}</td>
                <td><a href="./users/update?id=${user.id}">
                    <button>Update</button></a></td>
                <td><a href="./users/delete?id=${user.id}">
                    <button>Delete</button></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>
    <form action="./users/create">
        <button>Add user</button>
    </form>
</div>
</body>
</html>