<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
</head>
<body>
    <h1> Welcome to about page of spring mvc </h1>
    <p> Spring mvc is a framework of spring. It is build on the top of servlet </p>
        <%
            String name = (String) request.getAttribute("name");
            String mobile = (String) request.getAttribute("mobile");
        %>

        <h1> Welcome to help page... </h1>
        <h2> My name is <%= name %> </h2>
        <h3> My roll no is <%= mobile %> </h3>
</body>
</html>