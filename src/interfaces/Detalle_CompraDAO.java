package interfaces;

import java.util.List;

import beans.Detalle_CompraDTO;

public interface Detalle_CompraDAO {
	public List<Detalle_CompraDTO> listar_Detalle_Compra(int codigo);
	public int Registrar_Detalle_Compra(Detalle_CompraDTO obj);
	public int Actualizar_Detalle_Compra(Detalle_CompraDTO obj);
	public int Eliminar_Detalle_Compra(int codigo);
	public Detalle_CompraDTO buscarDetalle_Compra(int cod);
	

}
