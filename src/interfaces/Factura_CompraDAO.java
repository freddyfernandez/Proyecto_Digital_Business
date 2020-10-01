package interfaces;


import java.util.ArrayList;
import java.util.List;

import beans.Factura_CompraDTO;

public interface Factura_CompraDAO {
	public List<Factura_CompraDTO> listar_Factura_Compra();
	public int Registrar_Factura_Compra(Factura_CompraDTO obj);
	public int Actualizar_Factura_Compra(Factura_CompraDTO obj);
	public int Eliminar_Factura_Compra(int codigo);
	public Factura_CompraDTO buscarFactura_Compra(int cod);
	
	public ArrayList<Factura_CompraDTO> Listarxestado();
	public List<Factura_CompraDTO> FacturasXProveedor(int codigo_contacto);
	


}
