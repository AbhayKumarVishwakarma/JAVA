<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>More</title>
</head>
<body>
    <h1> Welcome to more page... </h1>
    <h2> About the java - ${java} </h2>
    <h3> Use of JS - ${js} </h3>                                               // JSP expression language

    <c:forEach var="item" items="${Mlist}"> <h3> ${item} </h3> </c:forEach>    // JSTl


</body>
</html>
