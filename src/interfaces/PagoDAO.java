package interfaces;

import java.util.List;

import beans.PagoDTO;;

public interface PagoDAO {
	public List<PagoDTO> Listar_Pago();
	public int Registrar_Pago(PagoDTO obj);
	public int Actualizar_Pago(PagoDTO obj);
	public int Eliminar_Pago(int codigo_pago);
	public PagoDTO buscarPago(int codigo_pago);
	
	
	
}
