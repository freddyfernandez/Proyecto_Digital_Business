package service;

import java.util.List;

import beans.Factura_VentaDTO;
import dao.DAOFactory;
import interfaces.Factura_VentaDAO;

public class Factura_VentaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	Factura_VentaDAO objPro = fabrica.getFactura_Venta();
	
	public List<Factura_VentaDTO> listar_Factura_Venta(){
		return objPro.listar_Factura_Venta();
	}
	public int registrar_Factura_Venta(Factura_VentaDTO obj) {
		return objPro.registrar_Factura_Venta(obj);
	}
	public int actualizar_Factura_Venta(Factura_VentaDTO obj) {
		return objPro.actualizar_Factura_Venta(obj);
	}
	public int eliminar_Factura_Venta(int codigo) {
		return objPro.eliminar_Factura_Venta(codigo);
	}
	public Factura_VentaDTO buscarFactura_Venta(int cod) {
		return objPro.buscarFactura_Venta(cod);
	}
	public List<Factura_VentaDTO> listar_Estado(){
		return objPro.listar_Estado();
	}
	public List<Factura_VentaDTO> listar_FacturaxEstado(int estado){
		return objPro.listar_FacturaxEstado(estado);
	}
	public List<Factura_VentaDTO> listar_FacturaXFecha(String fechainicial,String fechafinal){
		return objPro.listar_FacturaXFecha(fechainicial, fechafinal);
	}
}
