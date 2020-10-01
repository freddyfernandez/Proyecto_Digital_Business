package service;

import java.util.List;

import beans.Detalle_VentaDTO;
import beans.VentaDTO;
import dao.DAOFactory;

import interfaces.VentaDAO;

public class VentaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	VentaDAO objPro = fabrica.getVenta();
	
	public List<VentaDTO> listar_Venta(){
		return objPro.listar_Venta();
	}
	public int Registrar_Venta(VentaDTO obj) {
		return objPro.Registrar_Venta(obj);
	}
	public int Actualizar_Venta(VentaDTO obj) {
		return objPro.Actualizar_Venta(obj);
		
	}
	public int Eliminar_Venta(int codigo) {
		return objPro.Eliminar_Venta(codigo);
	}
	public VentaDTO buscarVenta(int cod) {
		return objPro.buscarVenta(cod);
	}
	
	public int inserta(VentaDTO boletaBean, List<Detalle_VentaDTO> lstDetalle)
	{
		return objPro.inserta(boletaBean, lstDetalle);
	}
	

	
	public VentaDTO buscarCodigoVenta() {
		return objPro.buscarCodigoVenta();
	}
	

}
