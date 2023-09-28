<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<ul>
	<c:forEach items="${productos}" var="p">
		<li>${p.id}: ${p.nombre} -> ${p.precio} € 
			<c:if test="${p.fechaCaducidad != null}">
				(${p.fechaCaducidad})
			</c:if>
		</li>
	</c:forEach>
</ul>

</body>
</html>