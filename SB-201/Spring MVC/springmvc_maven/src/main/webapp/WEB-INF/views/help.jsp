<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help</title>
</head>
<body>

    <%
        String name = (String) request.getAttribute("name");
        Integer roll = (Integer) request.getAttribute("rollNo");
    %>

    <h1> Welcome to help page... </h1>
    <h2> My name is <%= name %> </h2>
    <h3> My roll no is <%= roll %> </h3>

</body>
</html>