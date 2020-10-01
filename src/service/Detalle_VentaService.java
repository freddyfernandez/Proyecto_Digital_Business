package service;

import java.util.List;

import beans.Detalle_VentaDTO;
import dao.DAOFactory;
import interfaces.Detalle_VentaDAO;


public class Detalle_VentaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	Detalle_VentaDAO objPro = fabrica.getDetalleVenta();
	
	public List<Detalle_VentaDTO> listar_Detalle_Venta(int codigo){
		return objPro.listar_Detalle_Venta(codigo);
	}
	
	public int Registrar_Detalle_Venta(Detalle_VentaDTO obj) {
		return objPro.Registrar_Detalle_Venta(obj);
	}
	public int Actualizar_Detalle_Venta(Detalle_VentaDTO obj) {
		return objPro.Actualizar_Detalle_Venta(obj);
	}
	public int Eliminar_Detalle_Venta(int codigo) {
		return objPro.Eliminar_Detalle_Venta(codigo);
	}
	public Detalle_VentaDTO buscarDetalle_Venta(int cod) {
		return objPro.buscarDetalle_Venta(cod);
	}
	public int buscar_Venta(int codigo) {
		return objPro.buscar_Venta(codigo);
	}
	
	public Detalle_VentaDTO Monto(int codigo) {
		return objPro.Monto(codigo);
	}
	public Detalle_VentaDTO buscarVenta(int codigo_venta) {
		return objPro.buscarVenta(codigo_venta);
	}

}
