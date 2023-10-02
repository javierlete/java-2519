'use strict';

const URL = 'http://localhost:8080/ejemplo/api/productos';

let ul;

window.addEventListener('DOMContentLoaded', async function() {
	ul = document.querySelector('ul');
	
	await cargarProductos();

	const form = document.querySelector('form');
	const button = document.querySelector('form button');
	button.addEventListener('click', async function() {
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

	ul.innerHTML = '';

	productos.forEach(p => {
		const li = document.createElement('li');
		li.innerHTML = `${p.id}, ${p.nombre}, ${p.precio}, ${p.fechaCaducidad}`;
		ul.appendChild(li);
	});
}
