<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es_ES" />
<!DOCTYPE html>
<html>
<head>
<title>Ejemplo</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script
	src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<script>
	$(function() {
		new DataTable('table', {
			pageLength : 4,
			lengthMenu : [ 4, 10, 25, 50, 75, 100 ],
			language : {
				url : '//cdn.datatables.net/plug-ins/1.13.6/i18n/es-ES.json',
			}
		});
	});
</script>

</head>
<body class="container pt-5">

	<form action="agregar" method="post" novalidate>
		<input type="hidden" id="id" name="id" value="${producto.id}">

		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input
					class="form-control ${errores.nombre != null ? 'is-invalid' : ''}"
					id="nombre" name="nombre" placeholder="Nombre"
					value="${producto.nombre}">
				<div class="invalid-feedback">${errores.nombre}</div>
			</div>
		</div>

		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input
					class="form-control ${errores.precio != null ? 'is-invalid' : ''}"
					id="precio" name="precio" type="number" step=".01" min="0"
					placeholder="Precio" value="${producto.precio}">
				<div class="invalid-feedback">${errores.precio}</div>
			</div>
		</div>

		<div class="row mb-3">
			<label for="fecha-caducidad" class="col-sm-2 col-form-label">Fecha
				de caducidad</label>
			<div class="col-sm">
				<input
					class="form-control ${errores.fechaCaducidad != null ? 'is-invalid' : ''}"
					id="fecha-caducidad" name="fecha-caducidad" type="date"
					value="${producto.fechaCaducidad}">
				<div class="invalid-feedback">${errores.fechaCaducidad}</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="offset-sm-2 col-sm">
				<button class="btn btn-primary">Guardar producto</button>
			</div>
		</div>

	</form>

	<div class="border rounded d-flex col">
		<form action="buscarnombre" class="p-3 border rounded">
			<fieldset>
				<legend>Búsqueda por contenido del nombre</legend>
				<div class="d-flex">
					<input class="form-control" name="nombre"
						placeholder="Buscar por contenido del nombre">
					<button class="btn btn-primary">Buscar&nbsp;por&nbsp;nombre</button>
				</div>
			</fieldset>
		</form>

		<form action="buscarprecios" class="p-3 border rounded col">
			<fieldset>
				<legend>Búsqueda por rango de precios</legend>
				<div class="d-flex">
					<input class="form-control" name="minimo" type="number" step=".01"
						placeholder="Mínimo"> <input class="form-control"
						name="maximo" type="number" step=".01" placeholder="Máximo">
					<button class="btn btn-primary">Buscar&nbsp;por&nbsp;rango&nbsp;de&nbsp;precios</button>
				</div>
			</fieldset>
		</form>
	</div>
	<table class="table table-hovered table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th class="text-end">Precio</th>
				<th>Fecha de caducidad</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<th class="text-end">${p.id}</th>
					<td>${p.nombre}</td>
					<td class="text-end"><fmt:formatNumber type="currency"
							value="${p.precio}" /></td>
					<td class="text-end">${p.fechaCaducidad}</td>
					<td><a class="btn btn-primary" href="listado?id=${p.id}">Editar</a>
						<a class="btn btn-danger" href="borrar?id=${p.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-primary" href="listado">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>