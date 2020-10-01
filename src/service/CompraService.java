package service;

import java.util.List;

import beans.CompraDTO;
import beans.VentaDTO;
import dao.DAOFactory;
import interfaces.CompraDAO;

public class CompraService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	CompraDAO objPro = fabrica.getCompra();

	public List<CompraDTO> listar_Compra() {
		return objPro.listar_Compra();
	}

	public int Registrar_Compra(CompraDTO obj) {
		return objPro.Registrar_Compra(obj);
	}

	public int Actualizar_Compra(CompraDTO obj) {
		return objPro.Actualizar_Compra(obj);
	}

	public int Eliminar_Compra(int codigo) {
		return objPro.Eliminar_Compra(codigo);
	}

	public CompraDTO buscarCompra(int cod) {
		return objPro.buscarCompra(cod);
	}

	public CompraDTO buscarCodigoCompra() {
		return objPro.buscarCodigoCompra();
				
	}
	
}
