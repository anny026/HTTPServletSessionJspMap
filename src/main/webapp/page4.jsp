<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1 style="text-align: center;">Dear <%= session.getAttribute("name")%>, your order:</h1>

<h2 style="text-align: center;">You have already chosen:<h2>
<c:forEach items="${requestScope.cart}" var="cart" >
  <p style="text-align: center;"><c:out value="${cart}"/></p>
  </c:forEach>

<p style="text-align: center;">Total: <%= session.getAttribute("shopCart") %> $</p>

</body>
</html>
