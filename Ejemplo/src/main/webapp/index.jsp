<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="agregar" method="post">
		<div>
			<input name="nombre" placeholder="Nombre" value="${producto.nombre}">
			<div class="error">${errores.nombre}</div>
		</div>

		<div>
			<input name="precio" type="number" step=".01" min="0"
				placeholder="Precio" value="${producto.precio}">
			<div class="error">${errores.precio}</div>
		</div>

		<div>
			<input name="fecha-caducidad" type="date"
				value="${producto.fechaCaducidad}">
			<div class="error">${errores.fechaCaducidad}</div>
		</div>

		<button>Guardar producto</button>
	</form>

	<ul>
		<c:forEach items="${productos}" var="p">
			<li>${p.id}:${p.nombre}-> ${p.precio} € <c:if
					test="${p.fechaCaducidad != null}">
				(${p.fechaCaducidad})
			</c:if>
			</li>
		</c:forEach>
	</ul>

</body>
</html>