package service;

import java.util.ArrayList;
import java.util.List;


import beans.MarcaDTO;

import dao.DAOFactory;
import interfaces.MarcaDAO;


public class MarcaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	MarcaDAO objPro=fabrica.getMarca();
	
	public List<MarcaDTO> listaMarca(){
		return objPro.Listar_Marca();
	}
	
	public int registraMarca(MarcaDTO obj) {
		return objPro.Registrar_Marca(obj);
	}

	public int Actualizar_Marca(MarcaDTO obj) {
		return objPro.Actualizar_Marca(obj);
	}

	public int Eliminar_Marca(int codigo) {
		return objPro.Eliminar_Marca(codigo);
	}

	public MarcaDTO buscarMarca(int cod) {
		return objPro.buscarMarca(cod);
	}
	
	public ArrayList<MarcaDTO> Listarxnombremarca()
	{
		return objPro.Listarxnombremarca();
	}
	
	
	

}
