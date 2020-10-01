package interfaces;

import java.util.ArrayList;
import java.util.List;


import beans.ProductoDTO;

public interface ProductoDAO {
	
	public List<ProductoDTO> listar_producto();
	public int Registrar_producto(ProductoDTO obj);
	public int Actualizar_producto(ProductoDTO obj);
	public int Eliminar_producto(int codigo);
	public ProductoDTO buscarProducto(int cod);
	
	public ArrayList<ProductoDTO> Listarxnombreproducto();
	
	public ArrayList<ProductoDTO> consultaXNombre(String filtro);
	

}
