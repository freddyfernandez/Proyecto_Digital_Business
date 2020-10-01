package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySqlDbConexion;

public class MySqlProductoDAO implements ProductoDAO {
	@Override
	public List<ProductoDTO> listar_producto() {
		
		List<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from PRODUCTO";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setMarca(rs.getInt(3));
				obj.setPrecio(rs.getDouble(4));
				obj.setStock(rs.getInt(5));
				obj.setCaracteristicas(rs.getString(6));
					
				data.add(obj); 
			
			}	
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return data;  
	}

	@Override
	public int Registrar_producto(ProductoDTO obj) {

		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into PRODUCTO values (null,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre());
			pst.setInt(2,obj.getMarca());
			pst.setDouble(3,obj.getPrecio());
			pst.setInt(4,obj.getStock());
			pst.setString(5,obj.getCaracteristicas());
		    
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
	public int Actualizar_producto(ProductoDTO obj) {

		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  PRODUCTO set NOMBRE_PRODUCTO=?,ID_MARCA=?,PRECIO_UNITARIO=?,STOCK=?,CARACTERISTICAS=? where CODIGO_PRODUCTO=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1,obj.getNombre());
			pst.setInt(2,obj.getMarca());
			pst.setDouble(3,obj.getPrecio());
			pst.setInt(4,obj.getStock());
			pst.setString(5,obj.getCaracteristicas());
			pst.setInt(6,obj.getCodigo());
			
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
	public int Eliminar_producto(int codigo) {

		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from PRODUCTO where CODIGO_PRODUCTO=?";
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
	public ProductoDTO buscarProducto(int cod) {

		ProductoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from PRODUCTO where CODIGO_PRODUCTO=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setMarca(rs.getInt(3));
				obj.setPrecio(rs.getDouble(4));
				obj.setStock(rs.getInt(5));
				obj.setCaracteristicas(rs.getString(6));				
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
	
	

	/*Metodo quen trabaja con el litado del combobox*/
	public ArrayList<ProductoDTO> Listarxnombreproducto() {
		// TODO Auto-generated method stub
		ArrayList<ProductoDTO> lista=new ArrayList<ProductoDTO>();
		ProductoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from PRODUCTO";
			pstm=cn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj= new ProductoDTO();
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

	@Override
	public ArrayList<ProductoDTO> consultaXNombre(String filtro) {
		// TODO Auto-generated method stub
		ArrayList<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDbConexion().getConexion();
			String sql ="select * from producto  where NOMBRE_PRODUCTO like ? ";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, (filtro+"%"));
		
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new ProductoDTO();
				bean.setCodigo(rs.getInt("codigo_producto"));
				bean.setNombre(rs.getString("nombre_producto"));
				bean.setPrecio(rs.getDouble("precio_unitario"));
				bean.setStock(rs.getInt("stock"));
				
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
	
	

	

}
