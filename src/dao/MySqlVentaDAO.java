package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.Detalle_VentaDTO;
import beans.VentaDTO;
import interfaces.VentaDAO;
import utils.MySqlDbConexion;

public class MySqlVentaDAO implements VentaDAO{

	@Override
	public List<VentaDTO> listar_Venta() {
		// TODO Auto-generated method stub
		List<VentaDTO> data = new ArrayList<VentaDTO>();
		VentaDTO obj =null;
		Connection cn =null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql = "select *from Venta";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) 
			{
				obj= new VentaDTO();
				obj.setCodigo_venta(rs.getInt(1));
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
	public int Registrar_Venta(VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="insert into VENTA values (null,?,?,?)";
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
	public int Actualizar_Venta(VentaDTO obj) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="update  VENTA set FECHA_REGISTRO=?,CODIGO_EMPLEADO=?,CODIGO_CONTACTO=? where CODIGO_VENTA=?";
			pst=con.prepareStatement(sql);
			
			pst.setDate(1,obj.getFecha());
			pst.setInt(2,obj.getCodigo_empleado());
			pst.setInt(3,obj.getCodigo_cliente());
			pst.setInt(4,obj.getCodigo_venta());
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
	public int Eliminar_Venta(int codigo) {
		// TODO Auto-generated method stub
		int rs=-1;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=new MySqlDbConexion().getConexion();
			String sql="delete from VENTA where CODIGO_VENTA=?";
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
	public VentaDTO buscarVenta(int cod) {
		// TODO Auto-generated method stub
		VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select *from VENTA where CODIGO_VENTA=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new VentaDTO();
				obj.setCodigo_venta(rs.getInt(1));
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
	public int inserta(VentaDTO boletaBean, List<Detalle_VentaDTO> lstDetalle) {
		// TODO Auto-generated method stub
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm1 = null, pstm2= null,pstm3= null;
		
		try {
			conn = new MySqlDbConexion().getConexion();
			//Se anula el auto envío
			conn.setAutoCommit(false);
			
			//se crea el sql de la cabecera
			String sql1 ="insert into VENTA values(null,curdate(),?,?)";
			pstm1 = conn.prepareStatement(sql1);
			
			pstm1.setInt(1, boletaBean.getCodigo_empleado());
			pstm1.setInt(2, boletaBean.getCodigo_cliente());
			pstm1.executeUpdate();
			
			//se obtiene el idBoleta insertado
			String sql2 ="select max(CODIGO_VENTA) from VENTA";
			pstm2 =  conn.prepareStatement(sql2);
			ResultSet rs = pstm2.executeQuery();
			rs.next();
			int idBoleta = rs.getInt(1);
			
			//se inserta el detalle de boleta
			String sql3 ="insert into DETALLE_VENTA values(null,?,?,?,?,?)";
			pstm3 =  conn.prepareStatement(sql3);
			for (Detalle_VentaDTO aux : lstDetalle)
			{
				pstm3.setInt(1, idBoleta);
				pstm3.setInt(2, aux.getCodigo_producto());
				
				pstm3.setDouble(3, aux.getPrecio_venta());
				pstm3.setInt(4, aux.getCantidad());
				pstm3.setInt(5, aux.getDescuento());
				pstm3.executeUpdate();
			}
			
			//se ejecuta todos los SQL en la base de datos
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				//se vuelva a un inicio 
				//No permite un SQL por separado
			} catch (SQLException e1) {}
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				pstm1.close();
				pstm2.close();
				pstm3.close();
				
			} catch (SQLException e) {
			}
		}
		return contador;

	
	}


	


	@Override
	public VentaDTO buscarCodigoVenta(){
		// TODO Auto-generated method stub
		VentaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn= new MySqlDbConexion().getConexion();
			String sql="select max(CODIGO_VENTA) from VENTA";
			pstm=cn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj= new VentaDTO();
				obj.setCodigo_venta(rs.getInt(1));
				
							
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
