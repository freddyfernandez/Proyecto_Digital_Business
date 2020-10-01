package dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.MarcaDTO;

import interfaces.MarcaDAO;
import utils.MySqlDbConexion;

public class MySqlMarcaDAO implements  MarcaDAO{

	@Override
	public List<MarcaDTO> Listar_Marca() {
		// TODO Auto-generated method stub
		List<MarcaDTO> data = new ArrayList<MarcaDTO>();
		MarcaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from MARCA";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) /*mientras haya registros se ejecuta*/
			{
				obj= new MarcaDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
			
				data.add(obj); /*set : agregar a una instancia de la clase*/
				
				
				
			}
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public int Registrar_Marca(MarcaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into MARCA values (null,?)";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre());
			
			
			
		    
		    rs=pst.executeUpdate();
		  
			
		}
		catch(Exception e) {
			System.out.println("Error en la Sentencia"+e.getMessage());
			
		}
		finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}
	
	public MarcaDTO buscarMarca(int cod) {
		// TODO Auto-generated method stub
		MarcaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from MARCA where codigo_marca=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new MarcaDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				
			}
		}
		catch (Exception e){
				e.printStackTrace();
		}
		finally {
			try {
					if(rs!=null)rs.close();
					if(pstm!=null)pstm.close();
					if(cn!=null)cn.close();			
			}
			catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		
		
		
		return obj;
	}

	@Override
	public int Actualizar_Marca(MarcaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  MARCA set nombre_marca=? where codigo_marca=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre());
			pst.setInt(2,obj.getCodigo());
			
		    rs=pst.executeUpdate();
		  
			
		}
		catch(Exception e) {
			System.out.println("Error en la Sentencia"+e.getMessage());
			
		}
		finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int Eliminar_Marca(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from Marca where codigo_marca=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,codigo);
			
		    
		    rs=pst.executeUpdate();
		  
			
		}
		catch(Exception e) {
			System.out.println("Error en la Sentencia"+e.getMessage());
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, " NO SE PUEDE ELIMINAR ESTE REGISTRO: "+e.getMessage());
			
		}
		finally {
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public ArrayList<MarcaDTO> Listarxnombremarca() {
		// TODO Auto-generated method stub
		ArrayList<MarcaDTO> lista=new ArrayList<MarcaDTO>();
		MarcaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from MARCA";
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj= new MarcaDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				
				lista.add(obj);
				
			}
			
			
			
		}
		catch (Exception e){
				e.printStackTrace();
		}
		finally {
			try {
					if(rs!=null)rs.close();
					if(pstm!=null)pstm.close();
					if(cn!=null)cn.close();			
			}
			catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		
		
		
		return lista;
		
	}
	
	
	

}
