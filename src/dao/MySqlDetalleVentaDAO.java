package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Detalle_VentaDTO;

import interfaces.Detalle_VentaDAO;
import utils.MySqlDbConexion;

public class MySqlDetalleVentaDAO implements Detalle_VentaDAO{

	@Override
	public List<Detalle_VentaDTO> listar_Detalle_Venta(int cod) {
		// TODO Auto-generated method stub
		
		List<Detalle_VentaDTO> data = new ArrayList<Detalle_VentaDTO>();
		Detalle_VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select dv.codigo_detalle_venta,dv.codigo_venta,p.nombre_producto,dv.precio_venta,dv.cantidad,dv.descuento from Detalle_Venta dv\r\n" + 
					"inner join producto p\r\n" + 
					"on dv.codigo_producto=p.codigo_producto\r\n" + 
					"where codigo_venta=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Detalle_VentaDTO();
				obj.setCodigo_detalle(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setNombre_producto(rs.getString(3));
				obj.setPrecio_venta(rs.getDouble(4));
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
	public int Registrar_Detalle_Venta(Detalle_VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into DETALLE_VENTA values (null,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_venta());
			pst.setInt(2,obj.getCodigo_producto());
			pst.setDouble(3,obj.getPrecio_venta());
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
	public int Actualizar_Detalle_Venta(Detalle_VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  DETALLE_VENTA set CODIGO_VENTA=?,CODIGO_PRODUCTO=?,PRECIO_VENTA=?,CANTIDAD=?,DESCUENTO=?"
					+ "  where CODIGO_DETALLE_VENTA=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_venta());
			pst.setInt(2,obj.getCodigo_producto());
			pst.setDouble(3,obj.getPrecio_venta());
			pst.setInt(4,obj.getCantidad());
			pst.setInt(5,obj.getDescuento());
			pst.setInt(6,obj.getCodigo_detalle());
			
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
	public int Eliminar_Detalle_Venta(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from DETALLE_VENTA where CODIGO_DETALLE_VENTA=?";
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
	public Detalle_VentaDTO buscarDetalle_Venta(int cod) {
		// TODO Auto-generated method stub
		Detalle_VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from DETALLE_VENTA where CODIGO_DETALLE_VENTA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Detalle_VentaDTO();
				obj.setCodigo_detalle(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setCodigo_producto(rs.getInt(3));
				obj.setPrecio_venta(rs.getDouble(4));
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
	
	}

	@Override
	public int buscar_Venta(int codigo) {
		// TODO Auto-generated method stub
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int dato=0;
		
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select CODIGO_VENTA from DETALLE_VENTA where CODIGO_DETALLE_VENTA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs=pstm.executeQuery();
			if(rs.next()) {				
				dato=rs.getInt(1);			
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

		return dato;
	
	}

	@Override
	public Detalle_VentaDTO Monto(int codigo) {
		// TODO Auto-generated method stub
		Detalle_VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select sum(precio_venta*cantidad) from detalle_Venta where codigo_venta=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Detalle_VentaDTO();
				obj.setMonto_total(rs.getDouble(1));
			
							
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
	public Detalle_VentaDTO buscarVenta(int codigo_venta) {
		// TODO Auto-generated method stub
		Detalle_VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from DETALLE_VENTA where CODIGO_VENTA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_venta);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Detalle_VentaDTO();
				obj.setCodigo_detalle(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setCodigo_producto(rs.getInt(3));
				obj.setPrecio_venta(rs.getDouble(4));
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
	
	}

	
}
	