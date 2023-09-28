package com.ipartek.formacion.ejemplo.accesodatos;

public interface Dao<T> {
	public Iterable<T> selectTodos();
	public T selectPorId(Long id);
	
	public T insertar(T entidad);
	public T modificar(T entidad);
	public void borrar(Long id);
}
