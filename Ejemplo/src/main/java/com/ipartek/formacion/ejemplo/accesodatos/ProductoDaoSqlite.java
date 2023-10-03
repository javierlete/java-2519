package com.ipartek.formacion.ejemplo.accesodatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplo.entidades.Producto;

public class ProductoDaoSqlite implements ProductoDao {

	private static final String URL = "jdbc:sqlite:C:\\Users\\Java\\git\\java-2519\\Ejemplo\\sql\\ejemplo.db";
	private static final String USER = null;
	private static final String PASS = null;
	
	private static final String SQL_SELECT = "SELECT id, nombre, precio, fecha_caducidad FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	private static final String SQL_SELECT_PRECIOS = SQL_SELECT + " WHERE precio BETWEEN ? AND ?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, fecha_caducidad) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
	
	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Producto> selectTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();
			Producto producto;

			while (rs.next()) {
				String fechaTexto = rs.getString("fecha_caducidad");
				LocalDate fechaCaducidad = fechaTexto == null || fechaTexto.trim().length() == 0 ? null : LocalDate.parse(fechaTexto);			
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).fechaCaducidad(fechaCaducidad)
						.build();
				
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los productos", e);
		}
	}

	@Override
	public Producto selectPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;

			if (rs.next()) {
				String fechaTexto = rs.getString("fecha_caducidad");
				LocalDate fechaCaducidad = fechaTexto == null || fechaTexto.trim().length() == 0 ? null : LocalDate.parse(fechaTexto);			
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).fechaCaducidad(fechaCaducidad)
						.build();
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el producto id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> selectPorNombre(String nombre) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);
				) {
			pst.setString(1, "%" + nombre + "%");
			
			ResultSet rs = pst.executeQuery();
			
			var productos = new ArrayList<Producto>();
			Producto producto;

			while (rs.next()) {
				String fechaTexto = rs.getString("fecha_caducidad");
				LocalDate fechaCaducidad = fechaTexto == null || fechaTexto.trim().length() == 0 ? null : LocalDate.parse(fechaTexto);			
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).fechaCaducidad(fechaCaducidad)
						.build();
				
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los productos", e);
		}
	}

	@Override
	public Iterable<Producto> selectPorRangoPrecio(BigDecimal precioMinimo, BigDecimal precioMaximo) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_PRECIOS);
				) {
			pst.setBigDecimal(1, precioMinimo);
			pst.setBigDecimal(2, precioMaximo);
			
			ResultSet rs = pst.executeQuery();
			
			var productos = new ArrayList<Producto>();
			Producto producto;

			while (rs.next()) {
				String fechaTexto = rs.getString("fecha_caducidad");
				LocalDate fechaCaducidad = fechaTexto == null || fechaTexto.trim().length() == 0 ? null : LocalDate.parse(fechaTexto);			
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).fechaCaducidad(fechaCaducidad)
						.build();
				
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los productos", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			
			LocalDate fechaCaducidad = producto.getFechaCaducidad();
			String fechaCaducidadString = fechaCaducidad == null ? null : fechaCaducidad.toString(); 
			
			pst.setString(3, fechaCaducidadString);
			
			pst.executeUpdate();
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al insertar el producto", e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			
			LocalDate fechaCaducidad = producto.getFechaCaducidad();
			String fechaCaducidadString = fechaCaducidad == null ? null : fechaCaducidad.toString(); 
			
			pst.setString(3, fechaCaducidadString);
			
			pst.setLong(4, producto.getId());
			
			pst.executeUpdate();
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al modificar el producto", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

			pst.setLong(1, id);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al borrar el producto", e);
		}
	}

}
