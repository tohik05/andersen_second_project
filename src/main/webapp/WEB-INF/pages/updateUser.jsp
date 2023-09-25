<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Update user</title>
</head>
<body>
<jsp:include page="header.jsp" />
<hr>
<div>
    <h1>Update user</h1>
</div>
<div>
    <p>Enter values</p>
    <form action="" method="post">
        <input id="id-input" name="id" type="text" value="${user.id}" hidden/><br/>
        <table>
            <tr>
                <td>
                    <label for="name-input"> Name: </label>
                </td>
                <td>
                    <input id="name-input" name="name" type="text" value="${user.name}" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastname-input">Lastname: </label>
                </td>
                <td>
                    <input id="lastname-input" name="lastname" type="text" value="${user.lastname}" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="age-input">Age: </label>
                </td>
                <td>
                    <input id="age-input" name="age" type="number" value="${user.age}" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>