package interfaces;

import java.util.List;


import beans.CompraDTO;


public interface CompraDAO {
	public List<CompraDTO> listar_Compra();
	public int Registrar_Compra(CompraDTO obj);
	public int Actualizar_Compra(CompraDTO obj);
	public int Eliminar_Compra(int codigo);
	public CompraDTO buscarCompra(int cod);
	
	public CompraDTO buscarCodigoCompra();
	
	

}
