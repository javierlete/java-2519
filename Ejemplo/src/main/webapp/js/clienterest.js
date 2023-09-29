window.addEventListener('DOMContentLoaded', async function() {
	const ul = document.querySelector('ul');
	
	const respuesta = await fetch('http://localhost:8080/ejemplo/api/productos');
	const productos = await respuesta.json();
	
	productos.forEach(p => {
		const li = document.createElement('li');
		li.innerHTML = `${p.id}, ${p.nombre}, ${p.precio}, ${p.fechaCaducidad}`;
		ul.appendChild(li);	
	});
});