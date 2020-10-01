package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BancoDTO;

import interfaces.BancoDAO;
import utils.MySqlDbConexion;

public class MySqlBancoDAO implements BancoDAO {

	@Override
	public List<BancoDTO> Listar_Banco() {
		// TODO Auto-generated method stub
		List<BancoDTO> data = new ArrayList<BancoDTO>();
		BancoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select *from BANCO";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new BancoDTO();
				obj.setCodigo_banco(rs.getInt(1));
				obj.setNombre_banco(rs.getString(2));
				obj.setSiglas_banco(rs.getString(3));

				data.add(obj);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public int Registrar_Banco(BancoDTO obj) {
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into BANCO values (null,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre_banco());
			pst.setString(2,obj.getSiglas_banco());

			
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
	public int Actualizar_Banco(BancoDTO obj) {
	
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  BANCO set nombre_banco=?,siglas_banco=?"
					+ " where codigo_banco=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre_banco());
			pst.setString(2,obj.getSiglas_banco());
	
			pst.setInt(3,obj.getCodigo_banco());
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
	public int Eliminar_Banco(int codigo_banco) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from Banco where codigo_banco=?";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,codigo_banco);
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
	public BancoDTO buscarBanco(int codigo_banco) {

		// TODO Auto-generated method stub
		BancoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from BANCO where codigo_banco=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,codigo_banco);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new BancoDTO();
				obj.setCodigo_banco(rs.getInt(1));
				obj.setNombre_banco(rs.getString(2));
				obj.setSiglas_banco(rs.getString(3));
								
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
