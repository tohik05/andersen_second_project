<html>
<head>
  <meta charset="UTF-8">
  <title>Redirect in 5...</title>
</head>
<body>

<h2>User with ID '${user.id}' successfully updated</h2>
<p>You will be redirect in 5 seconds...</p>

<%response.setHeader("Refresh", "5; URL=/users");%>

</body>
</html>
