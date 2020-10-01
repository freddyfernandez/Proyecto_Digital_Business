package service;

import java.util.ArrayList;
import java.util.List;

import beans.EmpleadoDTO;
import beans.Factura_CompraDTO;
import dao.DAOFactory;
import interfaces.Factura_CompraDAO;

public class FacturaCompraService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	Factura_CompraDAO objPro = fabrica.getFacturaCompra();

	public List<Factura_CompraDTO> listar_Factura_Compra() {
		return objPro.listar_Factura_Compra();
	}

	public int Registrar_Factura_Compra(Factura_CompraDTO obj) {
		return objPro.Registrar_Factura_Compra(obj);
	}

	public int Actualizar_Factura_Compra(Factura_CompraDTO obj) {
		return objPro.Actualizar_Factura_Compra(obj);
	}

	public int Eliminar_Factura_Compra(int codigo) {
		return objPro.Eliminar_Factura_Compra(codigo);
	}

	public Factura_CompraDTO buscarFactura_Compra(int cod) {
		return objPro.buscarFactura_Compra(cod);
	}

	public ArrayList<Factura_CompraDTO> Listarxestado(){
		return objPro.Listarxestado();
	}
	public List<Factura_CompraDTO> FacturasXProveedor(int codigo_contacto)
	{
		return objPro.FacturasXProveedor(codigo_contacto);
	}


}
