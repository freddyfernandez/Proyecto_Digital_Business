package interfaces;




import java.util.List;

import beans.Detalle_VentaDTO;


public interface Detalle_VentaDAO {
	public List<Detalle_VentaDTO> listar_Detalle_Venta(int codigo);
	public int Registrar_Detalle_Venta(Detalle_VentaDTO obj);
	public int Actualizar_Detalle_Venta(Detalle_VentaDTO obj);
	public int Eliminar_Detalle_Venta(int codigo);
	public Detalle_VentaDTO buscarDetalle_Venta(int cod);
	public Detalle_VentaDTO buscarVenta(int codigo_venta);
	public int buscar_Venta(int codigo);
	
	public Detalle_VentaDTO Monto(int codigo);
	
	
	
	

}
