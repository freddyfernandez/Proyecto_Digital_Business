package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Factura_VentaDTO;

import interfaces.Factura_VentaDAO;
import utils.MySqlDbConexion;

public class MySqlFacturaVentaDAO implements Factura_VentaDAO{

	@Override
	public List<Factura_VentaDTO> listar_Factura_Venta() {
		// TODO Auto-generated method stub
		List<Factura_VentaDTO> data = new ArrayList<Factura_VentaDTO>();
		Factura_VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "SELECT FV.CODIGO_FACTURA,FV.CODIGO_VENTA,E.NOMBRES_EMPLEADO,ES.DESCRIPCION,FV.FECHA_REGISTRO FROM FACTURA_VENTA FV\r\n" + 
					"INNER JOIN EMPLEADO E\r\n" + 
					"ON FV.CODIGO_EMPLEADO=E.CODIGO_EMPLEADO\r\n" + 
					"INNER JOIN ESTADO ES\r\n" + 
					"ON FV.ESTADO=ES.CODIGO_ESTADO";
			pstm=cn.prepareStatement(sql);
			
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_VentaDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setNombre_empleado(rs.getString(3));
				obj.setNombre_estado(rs.getString(4));
				obj.setFecha(rs.getDate(5));
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
		
		
	}

	@Override
	public int registrar_Factura_Venta(Factura_VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into FACTURA_VENTA values (null,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1, obj.getCodigo_venta());
			pst.setInt(2, obj.getCodigo_empleado());
			pst.setInt(3, obj.getEstado());
			pst.setDate(4,obj.getFecha());
			
			
		    
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
	public int actualizar_Factura_Venta(Factura_VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  FACTURA_VENTA set CODIGO_VENTA=?,CODIGO_EMPLEADO=?,ESTADO=?,FECHA_REGISTRO=? where CODIGO_FACTURA=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_venta());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3,obj.getEstado());
			pst.setDate(4,obj.getFecha());
			pst.setInt(5,obj.getCodigo_factura());
			
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
	public int eliminar_Factura_Venta(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from FACTURA_VENTA where CODIGO_FACTURA=?";
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
	public Factura_VentaDTO buscarFactura_Venta(int cod) {
		// TODO Auto-generated method stub
		Factura_VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from FACTURA_VENTA where CODIGO_FACTURA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new Factura_VentaDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setCodigo_empleado(rs.getInt(3));
				obj.setEstado(rs.getInt(4));
				obj.setFecha(rs.getDate(5));
							
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
	public List<Factura_VentaDTO> listar_Estado() {
		// TODO Auto-generated method stub
		List<Factura_VentaDTO> data = new ArrayList<Factura_VentaDTO>();
		Factura_VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from estado;";
			pstm=cn.prepareStatement(sql);
			
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_VentaDTO();
				obj.setEstado(rs.getInt(1));
				obj.setNombre_estado(rs.getString(2));
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public List<Factura_VentaDTO> listar_FacturaxEstado(int estado) {
		// TODO Auto-generated method stub
		List<Factura_VentaDTO> data = new ArrayList<Factura_VentaDTO>();
		Factura_VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select fv.codigo_factura,v.codigo_venta,c.razon_social,sum(precio_venta*cantidad),fv.fecha_registro,es.descripcion from factura_Venta fv inner join venta v\r\n" + 
					"on fv.codigo_venta=v.codigo_venta inner join detalle_venta dv\r\n" + 
					"on dv.codigo_venta=v.codigo_venta inner join estado es \r\n" + 
					"on fv.estado=es.codigo_estado\r\n" + 
					"inner join contacto c on v.codigo_contacto=c.codigo_contacto\r\n" + 
					"where estado=? \r\n" + 
					"group by v.codigo_venta;";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, estado);
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_VentaDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setNombre_contacto(rs.getString(3));
				obj.setMonto_total(rs.getDouble(4));
				obj.setFecha(rs.getDate(5));
				obj.setNombre_estado(rs.getString(6));
				
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public List<Factura_VentaDTO> listar_FacturaXFecha(String fechainicial, String fechafinal) {
		// TODO Auto-generated method stub
		List<Factura_VentaDTO> data = new ArrayList<Factura_VentaDTO>();
		Factura_VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "SELECT FV.CODIGO_FACTURA,FV.CODIGO_VENTA,C.RAZON_SOCIAL,FV.FECHA_REGISTRO,SUM(precio_venta*cantidad),E.NOMBRES_EMPLEADO,ES.DESCRIPCION\r\n" + 
					"FROM FACTURA_VENTA FV\r\n" + 
					"INNER JOIN VENTA V ON FV.CODIGO_VENTA=V.CODIGO_VENTA\r\n" + 
					"INNER JOIN detalle_venta dv ON dv.codigo_venta=v.codigo_venta\r\n" + 
					"INNER JOIN EMPLEADO E ON FV.CODIGO_EMPLEADO=E.CODIGO_EMPLEADO\r\n" + 
					"INNER JOIN CONTACTO C ON V.CODIGO_CONTACTO=C.CODIGO_CONTACTO\r\n" + 
					"INNER JOIN ESTADO ES ON FV.ESTADO=ES.CODIGO_ESTADO\r\n" + 
					"where FV.FECHA_REGISTRO between ? and ? \r\n" + 
					"group by v.codigo_venta;";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, fechainicial);
			pstm.setString(2, fechafinal);
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_VentaDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_venta(rs.getInt(2));
				obj.setNombre_contacto(rs.getString(3));
				obj.setFecha(rs.getDate(4));
				obj.setMonto_total(rs.getDouble(5));
				obj.setNombre_empleado(rs.getString(6));
				obj.setNombre_estado(rs.getString(7));
				
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

}
