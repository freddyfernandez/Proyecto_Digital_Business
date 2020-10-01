package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PagoDTO;
import interfaces.PagoDAO;
import utils.MySqlDbConexion;

public class MySqlPagoDAO implements PagoDAO {

	@Override
	public List<PagoDTO> Listar_Pago() {
		// TODO Auto-generated method stub
		List<PagoDTO> data = new ArrayList<PagoDTO>();
		PagoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select *from forma_pago";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new PagoDTO();
				obj.setCodigo_pago(rs.getInt(1));
				obj.setForma_pago(rs.getString(2));

				data.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public int Registrar_Pago(PagoDTO obj) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "insert into forma_pago values (null,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, obj.getForma_pago());

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
	public int Actualizar_Pago(PagoDTO obj) {
		// TODO Auto-generated method stub
		int rs = -1;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "update forma_pago " + "set forma_pago=? " + " where CODIGO_FORMA_PAGO=?";
			pst = con.prepareStatement(sql);

			pst.setString(1, obj.getForma_pago());
			pst.setInt(2, obj.getCodigo_pago());
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
	public int Eliminar_Pago(int codigo_pago) {
		int rs = -1;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = new MySqlDbConexion().getConexion();
			String sql = "delete from forma_pago where CODIGO_FORMA_PAGO=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codigo_pago);

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
	public PagoDTO buscarPago(int codigo_pago) {
		PagoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = new MySqlDbConexion().getConexion();
			String sql = "select *from forma_pago where CODIGO_FORMA_PAGO=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo_pago);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new PagoDTO();
				obj.setCodigo_pago(rs.getInt(1));
				obj.setForma_pago(rs.getString(2));

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


}
