<html>
<head>
    <meta charset="UTF-8">
    <title>Redirect in 5...</title>
</head>
<body>

<h2>User with ID '${userId}' successfully deleted</h2>
<p>You will be redirect in 5 seconds...</p>

<%response.setHeader("Refresh", "5; URL=/andersen/users");%>

</body>
</html>
