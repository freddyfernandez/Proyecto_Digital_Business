package service;

import java.util.List;


import beans.BancoDTO;
import beans.MarcaDTO;
import dao.DAOFactory;
import interfaces.BancoDAO;;


public class BancoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	BancoDAO objPro=fabrica.getBanco();
	
	public List<BancoDTO> listaBanco(){
		return objPro.Listar_Banco();
	}
	
	public int registraBanco(BancoDTO obj) {
		return objPro.Registrar_Banco(obj);
	}

	public int Actualizar_Banco(BancoDTO obj) {
		return objPro.Actualizar_Banco(obj);
	}

	public int Eliminar_Banco(int codigo_banco) {
		return objPro.Eliminar_Banco(codigo_banco);
	}

	public BancoDTO buscarBanco(int codigo_banco) {
		return objPro.buscarBanco(codigo_banco);
	}

	
	
	
	

}
