package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Detalle_CompraDTO;

import interfaces.Detalle_CompraDAO;
import utils.MySqlDbConexion;

public class MySqlDetalleCompraDAO implements Detalle_CompraDAO {

	@Override
	public List<Detalle_CompraDTO> listar_Detalle_Compra(int codigo) {
		// TODO Auto-generated method stub
		List<Detalle_CompraDTO> data = new ArrayList<Detalle_CompraDTO>();
		Detalle_CompraDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from Detalle_Compra where codigo_Compra=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Detalle_CompraDTO();
				obj.setCodigo_detalle_compra(rs.getInt(1));
				obj.setCodigo_compra(rs.getInt(2));
				obj.setCodigo_producto(rs.getInt(3));
				obj.setPrecio_compra(rs.getDouble(4));
				obj.setCantidad(rs.getInt(5));
				obj.setDescuento(rs.getInt(6));
				
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
		
	}

	@Override
	public int Registrar_Detalle_Compra(Detalle_CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into DETALLE_Compra values (null,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_compra());
			pst.setInt(2,obj.getCodigo_producto());
			pst.setDouble(3,obj.getPrecio_compra());
			pst.setInt(4,obj.getCantidad());
			pst.setInt(5,obj.getDescuento());
			
			
		    
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
	public int Actualizar_Detalle_Compra(Detalle_CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  DETALLE_Compra set CODIGO_Compra=?,CODIGO_PRODUCTO=?,PRECIO_Compra=?,CANTIDAD=?,DESCUENTO=?"
					+ "  where CODIGO_DETALLE_Compra=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_compra());
			pst.setInt(2,obj.getCodigo_producto());
			pst.setDouble(3,obj.getPrecio_compra());
			pst.setInt(4,obj.getCantidad());
			pst.setInt(5,obj.getDescuento());
			pst.setInt(6,obj.getCodigo_detalle_compra());
			
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
	public int Eliminar_Detalle_Compra(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from DETALLE_Compra where CODIGO_DETALLE_Compra=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,codigo);
					    
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
	public Detalle_CompraDTO buscarDetalle_Compra(int cod) {
		// TODO Auto-generated method stub
		Detalle_CompraDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from DETALLE_Compra where CODIGO_DETALLE_Compra=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Detalle_CompraDTO();
				obj.setCodigo_detalle_compra(rs.getInt(1));
				obj.setCodigo_compra(rs.getInt(2));
				obj.setCodigo_producto(rs.getInt(3));
				obj.setPrecio_compra(rs.getDouble(4));
				obj.setCantidad(rs.getInt(5));
				obj.setDescuento(rs.getInt(6));
							
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
	
	}}
