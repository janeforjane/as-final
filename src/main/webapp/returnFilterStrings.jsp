<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sum Form</title>
</head>
<body>
<ul>
    <c:forEach items="${stringArrayFilterList}" var="str">
        <li>${str}</li>
    </c:forEach>
</ul>
</body>
</html>