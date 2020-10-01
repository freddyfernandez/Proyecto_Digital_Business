package service;



import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import dao.DAOFactory;

import interfaces.ProductoDAO;

public class ProductoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProductoDAO objPro = fabrica.getProducto();
	
	public List<ProductoDTO> listaProducto(){
		return objPro.listar_producto();
	}
	
	public int registraProducto(ProductoDTO obj) {
		return objPro.Registrar_producto(obj);
	}

	public int Actualizar_Producto(ProductoDTO obj) {
		return objPro.Actualizar_producto(obj);
	}

	public int Eliminar_Producto(int codigo) {
		return objPro.Eliminar_producto(codigo);
	}

	public ProductoDTO buscarProducto(int cod) {
		return objPro.buscarProducto(cod);
	}
	
	public List<ProductoDTO> Listarxnombreproducto(){
		return objPro.Listarxnombreproducto();
	}
	public ArrayList<ProductoDTO> consultaXNombre(String filtro)
	{
		return objPro.consultaXNombre(filtro);
	}

	
	
}
