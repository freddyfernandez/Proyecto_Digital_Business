package utils;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;



public class MySqlDbConexion {
	
	
	
	private final String URL="jdbc:mysql://localhost:3306/DIGITAL_BUSINESS?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private final String USER="root";
	private final String PASS="";
	
	public MySqlDbConexion() {}
	
	static 
	 {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
		} 
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
			
			
		}
	 }
	
	public Connection getConexion() {
		Connection cn = null;
		try {
			cn=DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {	
			
			e.printStackTrace();
			
			/*Agregacion opcional de panel de aviso de escepciones u errores*/
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, "Error en la Conexion"+ e.getMessage());
			/*---------------------------------------------------------------------------*/
		}
		return cn;
	}

}
