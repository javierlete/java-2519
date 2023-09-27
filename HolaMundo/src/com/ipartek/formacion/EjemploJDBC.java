package com.ipartek.formacion;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class EjemploJDBC {

	private static String URL;
	private static String FORMATO;

	private static final String SQL_SELECT = "SELECT id, nombre, precio, descripcion FROM productos";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, descripcion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	static {
		try {
			Properties props = new Properties();
			props.load(new FileReader("configuracion.properties"));

			URL = props.getProperty("ejemplojdbc.url");
			FORMATO = props.getProperty("ejemplojdbc.formato");
		} catch (IOException e) {
			System.err.println("No se ha podido cargar la configuración");
			System.exit(1);
		}
	}

	public static void main(String[] args) throws SQLException {
//		final String URL = "jdbc:mysql://servidor:3306/basededatos";
//		final String usuario = "usuario";
//		final String password = "contraseña";

//		Connection con = DriverManager.getConnection(URL, usuario, password);
		System.out.println("Iniciando Conexión");

		Connection con = DriverManager.getConnection(URL);

		System.out.println("Conexión establecida");

		Statement st = con.createStatement();

		System.out.println("Creada sentencia");

		ResultSet rs = st.executeQuery(SQL_SELECT);

		System.out.println("Ejecutada sentencia");

		while (rs.next()) {
			System.out.println(String.format(FORMATO, rs.getLong("id"), rs.getString("nombre"),
					rs.getBigDecimal("precio"), rs.getString("descripcion")));
		}

		String nombre = "Producto Nuevo";
		BigDecimal precio = new BigDecimal("1234.56");
		String descripcion = "Bla bla bla bla";

		PreparedStatement pst = con.prepareStatement(SQL_INSERT);
		
		pst.setString(1, nombre);
		pst.setBigDecimal(2, precio);
		pst.setString(3, descripcion);
		
		int numeroRegistrosAlterados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosAlterados);
		
		pst = con.prepareStatement(SQL_UPDATE);
		
		Long id = 2L;
		
		pst.setString(1, nombre);
		pst.setBigDecimal(2, precio);
		pst.setString(3, descripcion);
		pst.setLong(4, id);
		
		System.out.println(pst.executeUpdate());
		
		pst = con.prepareStatement(SQL_DELETE);
		
		id = 6L;
		
		pst.setLong(1, id);
		
		System.out.println(pst.executeUpdate());
	}
}
