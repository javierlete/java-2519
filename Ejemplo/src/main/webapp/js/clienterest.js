'use strict';

const URL = 'http://localhost:8080/ejemplo/api/productos';

let tbody;
let dataTable;

window.addEventListener('DOMContentLoaded', async function() {
	tbody = document.querySelector('tbody');
	const inputFechaCaducidad = document.querySelector('#fecha-caducidad');
	
	const minimo = new Date();
	minimo.setDate(minimo.getDate() + 1);
	
	inputFechaCaducidad.min = minimo.toISOString().split('T')[0]; 

	await cargarProductos();

	const form = document.querySelector('form');
	
	form.addEventListener('submit', async function(e) {
		e.preventDefault();
		
		if(!form.checkValidity()) {
			form.classList.add('was-validated');
			return;
		}
		
		const producto = { nombre: form.nombre.value, precio: form.precio.value, fechaCaducidad: form['fecha-caducidad'].value };

		const respuesta = await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(producto),
		});

		const datos = await respuesta.json();

		console.log(datos);

		cargarProductos();
	});

});

async function cargarProductos() {
	const respuesta = await fetch(URL);
	const productos = await respuesta.json();

	dataTable && dataTable.destroy();
	
	tbody.innerHTML = '';

	productos.forEach(p => {
		const tr = document.createElement('tr');
		tr.innerHTML = `
			<th>${p.id}</th>
			<td>${p.nombre}</td>
			<td>${p.precio}€</td>
			<td>${p.fechaCaducidad}</td>
			<td><a class="btn btn-primary" href="#">Editar</a> <a
				class="btn btn-danger" href="#">Borrar</a></td>
		`;
		tbody.appendChild(tr);
	});

	dataTable = $('table').DataTable({
		pageLength: 4,
		lengthMenu: [4, 10, 25, 50, 75, 100],
		language: {
			url: '//cdn.datatables.net/plug-ins/1.13.6/i18n/es-ES.json',
		}
	});
}
