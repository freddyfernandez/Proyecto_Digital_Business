package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.ContactoDTO;

import interfaces.ContactoDAO;
import utils.MySqlDbConexion;

public class MySqlContactoDAO implements ContactoDAO {
	@Override
	public List<ContactoDTO> Listar_Contacto() {

		// TODO Auto-generated method stub
		List<ContactoDTO> data = new ArrayList<ContactoDTO>();
		ContactoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select *from Contacto";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new ContactoDTO();
				obj.setCodigo_contacto(rs.getInt(1));
				obj.setCodigo_tipo(rs.getInt(2));
				obj.setCodigo_ruc(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setRazon_social(rs.getString(5));
				obj.setDireccion(rs.getString(6));
				obj.setTelefono(rs.getString(7));

				data.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

	@Override
	public int Registrar_Contacto(ContactoDTO obj) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "insert into CONTACTO values (null,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, obj.getCodigo_tipo());
			pst.setString(2, obj.getCodigo_ruc());
			pst.setInt(3, obj.getDni());
			pst.setString(4, obj.getRazon_social());
			pst.setString(5, obj.getDireccion());
			pst.setString(6, obj.getTelefono());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la Sentencia INSERT" + e.getMessage());

		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int Actualizar_Contacto(ContactoDTO obj) {
		// TODO Auto-generated method stub
		int rs = -1;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "update CONTACTO "
					+ "set CODIGO_TIPO=?,CODIGO_RUC=?,DNI=?,RAZON_SOCIAL=?,DIRECCION=?,TELEFONO=? "
					+ " where CODIGO_CONTACTO=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, obj.getCodigo_tipo());
			pst.setString(2, obj.getCodigo_ruc());
			pst.setInt(3, obj.getDni());
			pst.setString(4, obj.getRazon_social());
			pst.setString(5, obj.getDireccion());
			pst.setString(6, obj.getTelefono());
			pst.setInt(7, obj.getCodigo_contacto());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la Sentencia" + e.getMessage());

		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public int Eliminar_Contacto(int codigo_contacto) {
		int rs = -1;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "delete from CONTACTO where codigo_contacto=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codigo_contacto);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la Sentencia" + e.getMessage());
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, " NO SE PUEDE ELIMINAR ESTE REGISTRO: "+e.getMessage());

		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

	@Override
	public ContactoDTO buscarContacto(int codigo_contacto) {
		ContactoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select *from CONTACTO where codigo_contacto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_contacto);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ContactoDTO();
				obj.setCodigo_contacto(rs.getInt(1));
				obj.setCodigo_tipo(rs.getInt(2));
				obj.setCodigo_ruc(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setRazon_social(rs.getString(5));
				obj.setDireccion(rs.getString(6));
				obj.setTelefono(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return obj;
	}

	@Override
	public ArrayList<ContactoDTO> consultaCliente(String filtro) {
		// TODO Auto-generated method stub
		ArrayList<ContactoDTO> data = new ArrayList<ContactoDTO>();
		ContactoDTO bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			String sql = null;
			conn = new MySqlDbConexion().getConexion();
			 sql ="select CODIGO_CONTACTO,DNI,RAZON_SOCIAL,TELEFONO from contacto where razon_social like ? ";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, (filtro+"%"));
					
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new ContactoDTO();
				bean.setCodigo_contacto(rs.getInt("CODIGO_CONTACTO"));
				bean.setDni(rs.getInt("DNI"));
				bean.setRazon_social(rs.getString("RAZON_SOCIAL"));
				bean.setTelefono(rs.getString("TELEFONO"));
				data.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return data;

		
		
	}

	@Override
	public List<ContactoDTO> Listar_Xtipo_Contacto() {
		// TODO Auto-generated method stub
		List<ContactoDTO> data = new ArrayList<ContactoDTO>();
		ContactoDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from TIPO_CONTACTO;";
			pstm=cn.prepareStatement(sql);
			
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new ContactoDTO();
				obj.setCodigo_tipo(rs.getInt(1));
				obj.setTipo_contacto(rs.getString(2));
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public List<ContactoDTO> Listar_Clientes() {
		// TODO Auto-generated method stub
		List<ContactoDTO> data = new ArrayList<ContactoDTO>();
		ContactoDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from CONTACTO where codigo_tipo=1";
			pstm=cn.prepareStatement(sql);
			
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new ContactoDTO();
				obj.setCodigo_contacto(rs.getInt(1));
				obj.setRazon_social(rs.getString(5));
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public List<ContactoDTO> Listar_Proveedores() {
		// TODO Auto-generated method stub
		List<ContactoDTO> data = new ArrayList<ContactoDTO>();
		ContactoDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from CONTACTO where codigo_tipo=2";
			pstm=cn.prepareStatement(sql);
			
			
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new ContactoDTO();
				obj.setCodigo_contacto(rs.getInt(1));
				obj.setRazon_social(rs.getString(5));
				
	
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;
	}

}
