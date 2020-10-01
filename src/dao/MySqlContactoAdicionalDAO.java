package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Contacto_AdicionalDTO;

import interfaces.Contacto_AdicionalDAO;
import utils.MySqlDbConexion;

public class MySqlContactoAdicionalDAO implements Contacto_AdicionalDAO{

	@Override
	public List<Contacto_AdicionalDTO> Listar_Contacto_Adicional(int codigo_contacto) {
		// TODO Auto-generated method stub
		List<Contacto_AdicionalDTO> data = new ArrayList<Contacto_AdicionalDTO>();
		Contacto_AdicionalDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select ca.codigo_adicional,ca.codigo_contacto,c.razon_social,f.forma_pago,b.nombre_banco,ca.nro_cuenta,ca.correo from contacto_adicional ca\r\n" + 
					"inner join contacto c on ca.codigo_contacto=c.codigo_contacto\r\n" + 
					"inner join forma_pago f on ca.codigo_forma_pago=f.codigo_forma_pago\r\n" + 
					"inner join banco b on ca.codigo_banco=b.codigo_banco\r\n" + 
					"where ca.codigo_contacto=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_contacto);
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new Contacto_AdicionalDTO();
				obj.setCodigo_adicional(rs.getInt(1));
				obj.setCodigo_contacto(rs.getInt(2));
				obj.setRazon_social(rs.getString(3));
				obj.setForma_pago(rs.getString(4));
				obj.setNombre_banco(rs.getString(5));
				obj.setNro_cuenta(rs.getString(6));
				obj.setCorreo(rs.getString(7));
				
				
				
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public int Registrar_Contacto_Adicional(Contacto_AdicionalDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into contacto_adicional values (null,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_contacto());
			pst.setInt(2,obj.getCodigo_forma_pago());
			pst.setDouble(3,obj.getCodigo_banco());
			pst.setString(4,obj.getNro_cuenta());
			pst.setString(5,obj.getCorreo());
			
			
		    
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
	public int Actualizar_Contacto_Adicional(Contacto_AdicionalDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  codigo_adicional set CODIGO_CONTACTO=?,CODIGO_FORMA_PAGO=?,CODIGO_BANCO=?,NRO_CUENTA=?,CORREO=?"
					+ "  where CODIGO_ADICIONAL=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_contacto());
			pst.setInt(2,obj.getCodigo_forma_pago());
			pst.setDouble(3,obj.getCodigo_banco());
			pst.setString(4,obj.getNro_cuenta());
			pst.setString(5,obj.getCorreo());
			pst.setInt(6,obj.getCodigo_adicional());
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
	public int Eliminar_Contacto_Adicional(int codigo_adicional) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from CONTACTO_ADICIONAL where CODIGO_ADICIONAL=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,codigo_adicional);
					    
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
	public Contacto_AdicionalDTO buscarContacto_Adicional(int codigo_adicional) {
		// TODO Auto-generated method stub
		Contacto_AdicionalDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select ca.codigo_adicional,ca.codigo_contacto,c.razon_social,f.codigo_forma_pago,f.forma_pago,b.codigo_banco,b.nombre_banco,ca.nro_cuenta,ca.correo from contacto_adicional ca\r\n" + 
					"inner join contacto c on ca.codigo_contacto=c.codigo_contacto\r\n" + 
					"inner join forma_pago f on ca.codigo_forma_pago=f.codigo_forma_pago\r\n" + 
					"inner join banco b on ca.codigo_banco=b.codigo_banco\r\n" + 
					"where ca.codigo_adicional=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_adicional);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Contacto_AdicionalDTO();
				obj.setCodigo_adicional(rs.getInt(1));
				obj.setCodigo_contacto(rs.getInt(2));
				obj.setRazon_social(rs.getString(3));
				obj.setCodigo_forma_pago(rs.getInt(4));
				obj.setForma_pago(rs.getString(5));
				obj.setCodigo_banco(rs.getInt(6));
				obj.setNombre_banco(rs.getString(7));
				obj.setNro_cuenta(rs.getString(8));
				obj.setCorreo(rs.getString(9));
							
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
	public Contacto_AdicionalDTO buscarContacto(int codigo_contacto) {
		// TODO Auto-generated method stub
		Contacto_AdicionalDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select ca.codigo_adicional,ca.codigo_contacto,c.razon_social,f.codigo_forma_pago,f.forma_pago,b.codigo_banco,b.nombre_banco,ca.nro_cuenta,ca.correo from contacto_adicional ca\r\n" + 
					"inner join contacto c on ca.codigo_contacto=c.codigo_contacto\r\n" + 
					"inner join forma_pago f on ca.codigo_forma_pago=f.codigo_forma_pago\r\n" + 
					"inner join banco b on ca.codigo_banco=b.codigo_banco\r\n" + 
					"where ca.codigo_contacto=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo_contacto);
			rs=pstm.executeQuery();
			if(rs.next()) {
		
				obj= new Contacto_AdicionalDTO();
				obj.setCodigo_adicional(rs.getInt(1));
				obj.setCodigo_contacto(rs.getInt(2));
				obj.setRazon_social(rs.getString(3));
				obj.setCodigo_forma_pago(rs.getInt(4));
				obj.setForma_pago(rs.getString(5));
				obj.setCodigo_banco(rs.getInt(6));
				obj.setNombre_banco(rs.getString(7));
				obj.setNro_cuenta(rs.getString(8));
				obj.setCorreo(rs.getString(9));
							
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
	public int buscarcodigoContacto(int codigoadicional) {
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int dato=0;
		
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select CODIGO_CONTACTO from CONTACTO_ADICIONAL where CODIGO_ADICIONAL=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigoadicional);
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
	

}
