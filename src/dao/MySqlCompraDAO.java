package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.CompraDTO;

import interfaces.CompraDAO;
import utils.MySqlDbConexion;

public class MySqlCompraDAO implements CompraDAO {

	@Override
	public List<CompraDTO> listar_Compra() {
		// TODO Auto-generated method stub
		List<CompraDTO> data = new ArrayList<CompraDTO>();
		CompraDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from Compra";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new CompraDTO();
				obj.setCodigo_compra(rs.getInt(1));
				obj.setFecha(rs.getDate(2));
				obj.setCodigo_empleado(rs.getInt(3));
				obj.setCodigo_cliente(rs.getInt(4));
				
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public int Registrar_Compra(CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into Compra values (null,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setDate(1,obj.getFecha());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3,obj.getCodigo_cliente());
			
		    
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
	public int Actualizar_Compra(CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  Compra set FECHA_REGISTRO=?,CODIGO_EMPLEADO=?,CODIGO_CONTACTO=? where CODIGO_COMPRA=?";
			pst=con.prepareStatement(sql);
			
			pst.setDate(1,obj.getFecha());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3,obj.getCodigo_cliente());
			pst.setInt(4,obj.getCodigo_compra());
			
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
	public int Eliminar_Compra(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from COMPRA where CODIGO_COMPRA=?";
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
	public CompraDTO buscarCompra(int cod) {
		// TODO Auto-generated method stub
		CompraDTO obj =null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from COMPRA where CODIGO_COMPRA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new CompraDTO();
				obj.setCodigo_compra(rs.getInt(1));
				obj.setFecha(rs.getDate(2));
				obj.setCodigo_empleado(rs.getInt(3));
				obj.setCodigo_cliente(rs.getInt(4));
							
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
	public CompraDTO buscarCodigoCompra() {
		// TODO Auto-generated method stub
		CompraDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select max(CODIGO_COMPRA) from COMPRA";
			pstm=cn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new CompraDTO();
				obj.setCodigo_compra(rs.getInt(1));
				
							
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

	

}
