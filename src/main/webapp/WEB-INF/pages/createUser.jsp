<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Create user</title>
</head>
<body>
<jsp:include page="header.jsp" />
<hr>
<div>
    <h1>Create user</h1>
</div>
<div>
    <p>Enter values</p>
    <form method="post">
        <table>
            <tr>
                <td>
                <label for="name-input" > Name: </label>
                </td>
                <td>
                <input id="name-input" name="name" type="text" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="lastname-input">Lastname: </label>
                </td>
                <td>
                    <input id="lastname-input" name="lastname" type="text" required/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="age-input">Age: </label>
                </td>
                <td>
                    <input id="age-input" name="age" type="number" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right">
                    <input type="reset" value="Clear">
                    <input type="submit" value="Create">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>