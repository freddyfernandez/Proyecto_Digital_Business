package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.AlmacenDTO;
import interfaces.AlmacenDAO;
import utils.MySqlDbConexion;

public class MySqlAlmacenDAO implements AlmacenDAO{

	@Override
	public List<AlmacenDTO> listarEntrada() {
		// TODO Auto-generated method stub
		List<AlmacenDTO> data = new ArrayList<AlmacenDTO>();
		AlmacenDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select me.codigo_entrada,p.nombre_producto,me.cantidad_entrada,me.fecha_entrada\r\n" + 
					"from material_entrada me inner join producto p on me.codigo_producto=p.codigo_producto";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new AlmacenDTO();
				obj.setCodigo_entrada(rs.getInt(1));
				obj.setNombre_producto(rs.getString(2));
				obj.setCantidad_entrada(rs.getInt(3));
				obj.setFecha_entrada(rs.getDate(4));

				data.add(obj);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public int insertarEntrada(AlmacenDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into MATERIAL_ENTRADA values (null,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_producto());
			pst.setInt(2,obj.getCantidad_entrada());
			pst.setDate(3,obj.getFecha_entrada());
			
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
	public List<AlmacenDTO> listarSalida() {
		// TODO Auto-generated method stub
		List<AlmacenDTO> data = new ArrayList<AlmacenDTO>();
		AlmacenDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select me.codigo_salida,p.nombre_producto,me.cantidad_salida,me.fecha_salida\r\n" + 
					"from material_salida me inner join producto p on me.codigo_producto=p.codigo_producto";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new AlmacenDTO();
				obj.setCodigo_salida(rs.getInt(1));
				obj.setNombre_producto(rs.getString(2));
				obj.setCantidad_salida(rs.getInt(3));
				obj.setFecha_salida(rs.getDate(4));

				data.add(obj);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public int   insertarSalida(AlmacenDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into MATERIAL_SALIDA values (null,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setInt(1,obj.getCodigo_producto());
			pst.setInt(2,obj.getCantidad_salida());
			pst.setDate(3,obj.getFecha_salida());
			
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



}
