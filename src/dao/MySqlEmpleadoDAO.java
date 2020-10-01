package dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import beans.EmpleadoDTO;

import interfaces.EmpleadoDAO;
import utils.MySqlDbConexion;

public class MySqlEmpleadoDAO implements  EmpleadoDAO{

			@Override
			public List<EmpleadoDTO> Listar_Empleado() {
				// TODO Auto-generated method stub
				List<EmpleadoDTO> data = new ArrayList<EmpleadoDTO>();
				EmpleadoDTO obj =null;
				Connection cn =null;
				PreparedStatement pstm = null;
				ResultSet rs= null;
				try {
					cn= new MySqlDbConexion().getConexion();
					String sql = "select *from Empleado";
					
					pstm=cn.prepareStatement(sql);
					rs=pstm.executeQuery();
					while(rs.next())
					{
						obj= new EmpleadoDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNombre(rs.getString(2));
						obj.setApellido(rs.getString(3));
					    obj.setLogin(rs.getString(4));
					    obj.setPassword(rs.getString(5));
					    obj.setDetalle(rs.getString(6));
						data.add(obj);
						
						
						
					}
					
					
				}
				catch (Exception e){
					e.printStackTrace();
				}
				
				return data;  
			}

			@Override
			public int Registrar_Empleado(EmpleadoDTO obj) {
				// TODO Auto-generated method stub
				int rs=-1;
				Connection con=null;
				PreparedStatement pst=null;
				try {
					con=new MySqlDbConexion().getConexion();
					String sql="insert into Empleado values (null,?,?,?,?,?)";
					pst=con.prepareStatement(sql);
					
					pst.setString(1,obj.getNombre());
					pst.setString(2,obj.getApellido());
					pst.setString(3,obj.getLogin());
					pst.setString(4,obj.getPassword());
					pst.setString(5,obj.getDetalle());
					
					
				    
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
			
			public EmpleadoDTO buscarEmpleado(int cod) {
				// TODO Auto-generated method stub
				EmpleadoDTO obj=null;
				Connection cn=null;
				PreparedStatement pstm=null;
				ResultSet rs=null;
				try {
					cn= new MySqlDbConexion().getConexion();
					String sql="select *from Empleado where codigo_Empleado=?";
					pstm=cn.prepareStatement(sql);
					pstm.setInt(1, cod);
					rs=pstm.executeQuery();
					if(rs.next()) {
						obj= new EmpleadoDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNombre(rs.getString(2));
						obj.setApellido(rs.getString(3));
					    obj.setLogin(rs.getString(4));
					    obj.setPassword(rs.getString(5));
					    obj.setDetalle(rs.getString(6));
						
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
			public int Actualizar_Empleado(EmpleadoDTO obj) {
				// TODO Auto-generated method stub
				int rs=-1;
				Connection con=null;
				PreparedStatement pst=null;
				try {
					con=new MySqlDbConexion().getConexion();
					String sql="update  Empleado set NOMBRES_EMPLEADO=?,APELLIDOS_EMPLEADO=?,"
							+ "LOGIN_EMPLEADO=?,PASSWORD_EMPLEADO=?,DETALLE_EMPLEADO=? where CODIGO_EMPLEADO=?";
					pst=con.prepareStatement(sql);
					
					pst.setString(1,obj.getNombre());
					pst.setString(2,obj.getApellido());
					pst.setString(3,obj.getLogin());
					pst.setString(4,obj.getPassword());
					pst.setString(5,obj.getDetalle());
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
			public int Eliminar_Empleado(int codigo) {
				// TODO Auto-generated method stub
				int rs=-1;
				Connection con=null;
				PreparedStatement pst=null;
				try {
					con=new MySqlDbConexion().getConexion();
					String sql="delete from Empleado where codigo_Empleado=?";
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
			
			public ArrayList<EmpleadoDTO> Listarxnombreempleado() {
				// TODO Auto-generated method stub
				ArrayList<EmpleadoDTO> lista=new ArrayList<EmpleadoDTO>();
				EmpleadoDTO obj=null;
				Connection cn=null;
				PreparedStatement pstm=null;
				ResultSet rs=null;
				try {
					cn= new MySqlDbConexion().getConexion();
					String sql="select *from EMPLEADO";
					pstm=cn.prepareStatement(sql);
					
					rs=pstm.executeQuery();
					while(rs.next()) {
						obj= new EmpleadoDTO();
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
			public EmpleadoDTO iniciarSesion(String login) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				EmpleadoDTO obj = null;
				Connection cn = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;

				try {
					cn = new MySqlDbConexion().getConexion();
					String sql = "select *from EMPLEADO where LOGIN_EMPLEADO=?";
					pstm = cn.prepareStatement(sql);
					pstm.setString(1, login);
					rs = pstm.executeQuery();
					if (rs.next()) {
						obj = new EmpleadoDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNombre(rs.getString(2));
						obj.setApellido(rs.getString(3));
						obj.setLogin(rs.getString(4));
						obj.setPassword(rs.getString(5));
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
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				return obj;
			}

			
			
			

		

	}


