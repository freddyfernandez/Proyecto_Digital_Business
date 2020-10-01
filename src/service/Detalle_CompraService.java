package service;

import java.util.List;

import beans.Detalle_CompraDTO;
import dao.DAOFactory;
import interfaces.Detalle_CompraDAO;

public class Detalle_CompraService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	Detalle_CompraDAO objPro = fabrica.getDetalleCompra();

	public List<Detalle_CompraDTO> listar_Detalle_Compra(int codigo) {
		return objPro.listar_Detalle_Compra(codigo);
	}

	public int Registrar_Detalle_Compra(Detalle_CompraDTO obj) {
		return objPro.Registrar_Detalle_Compra(obj);
	}

	public int Actualizar_Detalle_Compra(Detalle_CompraDTO obj) {
		return objPro.Actualizar_Detalle_Compra(obj);
	}

	public int Eliminar_Detalle_Compra(int codigo) {
		return objPro.Eliminar_Detalle_Compra(codigo);
	}

	public Detalle_CompraDTO buscarDetalle_Compra(int cod) {
		return objPro.buscarDetalle_Compra(cod);
	}
}
