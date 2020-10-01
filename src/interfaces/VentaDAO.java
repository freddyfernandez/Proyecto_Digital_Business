package interfaces;

import java.util.List;

import beans.Detalle_VentaDTO;
import beans.VentaDTO;

public interface VentaDAO {
	public List<VentaDTO> listar_Venta();
	public int Registrar_Venta(VentaDTO obj);
	public int Actualizar_Venta(VentaDTO obj);
	public int Eliminar_Venta(int codigo);
	public VentaDTO buscarVenta(int cod);
	
	/*metodo transaccion*/
	public int inserta(VentaDTO boletaBean, List<Detalle_VentaDTO> lstDetalle);
	
	
	public VentaDTO buscarCodigoVenta();


}
