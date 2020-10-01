package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Factura_CompraDTO;
import interfaces.Factura_CompraDAO;
import utils.MySqlDbConexion;


public class MySqlFacturaCompraDAO implements Factura_CompraDAO {

	@Override
	public List<Factura_CompraDTO> listar_Factura_Compra() {	
		// TODO Auto-generated method stub
		
		List<Factura_CompraDTO> data = new ArrayList<Factura_CompraDTO>();
		Factura_CompraDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select * from Factura_Compra";
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_CompraDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_compra(rs.getInt(2));
				obj.setCodigo_empleado(rs.getInt(3));
				obj.setEstado(rs.getInt(4));
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
	public int Registrar_Factura_Compra(Factura_CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into Factura_Compra values (null,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_compra());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3, obj.getEstado());
			pst.setDate(4, obj.getFecha());
			
			
		    
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
	public int Actualizar_Factura_Compra(Factura_CompraDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  FACTURA_COMPRA set CODIGO_COMPRA=?,CODIGO_EMPLEADO=?,ESTADO=?,FECHA_REGISTRO=? where CODIGO_FACTURA=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_compra());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3, obj.getEstado());
			pst.setDate(4, obj.getFecha());
			pst.setInt(5, obj.getCodigo_factura());
			

			
			
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
	public int Eliminar_Factura_Compra(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from FACTURA_COMPRA where CODIGO_FACTURA=?";
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
	public Factura_CompraDTO buscarFactura_Compra(int cod) {
		// TODO Auto-generated method stub
		Factura_CompraDTO obj =null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select * from FACTURA_COMPRA where codigo_factura=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new Factura_CompraDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_compra(rs.getInt(2));
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
	public ArrayList<Factura_CompraDTO> Listarxestado() {
		// TODO Auto-generated method stub
		ArrayList<Factura_CompraDTO> lista=new ArrayList<Factura_CompraDTO>();
		Factura_CompraDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from ESTADO";
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj= new Factura_CompraDTO();
				obj.setEstado(rs.getInt(1));
				obj.setNombre_estado(rs.getString(2));
				
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

	@Override
	public List<Factura_CompraDTO> FacturasXProveedor(int codigo_contacto) {
		// TODO Auto-generated method stub
		List<Factura_CompraDTO> data = new ArrayList<Factura_CompraDTO>();
		Factura_CompraDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select fc.codigo_factura,c.codigo_compra,co.razon_social,sum(precio_compra*cantidad),fc.fecha_registro,es.descripcion \r\n" + 
					"from factura_Compra fc \r\n" + 
					"inner join compra c on fc.codigo_compra=c.codigo_compra\r\n" + 
					"inner join detalle_compra dc on dc.codigo_compra=c.codigo_compra\r\n" + 
					"inner join estado es \r\n" + 
					"on fc.estado=es.codigo_estado\r\n" + 
					"inner join contacto co on c.codigo_contacto=co.codigo_contacto\r\n" + 
					"where c.codigo_contacto=? \r\n" + 
					"group by c.codigo_compra";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,codigo_contacto);
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Factura_CompraDTO();
				obj.setCodigo_factura(rs.getInt(1));
				obj.setCodigo_compra(rs.getInt(2));
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

}
