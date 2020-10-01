package interfaces;

import java.util.List;

import beans.Factura_VentaDTO;


public interface Factura_VentaDAO {
	public List<Factura_VentaDTO> listar_Factura_Venta();
	public int registrar_Factura_Venta(Factura_VentaDTO obj);
	public int actualizar_Factura_Venta(Factura_VentaDTO obj);
	public int eliminar_Factura_Venta(int codigo);
	public Factura_VentaDTO buscarFactura_Venta(int cod);
	
	public List<Factura_VentaDTO> listar_Estado();
	
	public List<Factura_VentaDTO> listar_FacturaxEstado(int estado);
	
	public List<Factura_VentaDTO> listar_FacturaXFecha(String fechainicial,String fechafinal);
	
	

}
