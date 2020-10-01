package service;
import java.util.List;

import beans.PagoDTO;
import dao.DAOFactory;
import interfaces.PagoDAO;;


public class PagoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	PagoDAO objPro=fabrica.getPago();

	public List<PagoDTO> listaPago(){
		return objPro.Listar_Pago();
		
	}
	

	public PagoDTO buscarPago(int codigo_pago) {
		return objPro.buscarPago(codigo_pago);
	}
	
	public int registrarPago (PagoDTO obj) {
		return objPro.Registrar_Pago(obj);
	}

	public int Actualizar_Pago(PagoDTO obj) {
		return objPro.Actualizar_Pago(obj);
	}

	public int Eliminar_Pago(int codigo_pago) {
		return objPro.Eliminar_Pago(codigo_pago);
	}




	
	
	
	
}

	

