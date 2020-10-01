package service;

import java.util.List;

import beans.AlmacenDTO;
import dao.DAOFactory;
import interfaces.AlmacenDAO;

public class AlmacenService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	AlmacenDAO objPro=fabrica.getAlmacen();
	
	public List<AlmacenDTO> listarEntrada(){
		return objPro.listarEntrada();
	}
	public int insertarEntrada(AlmacenDTO obj)
	{
		return objPro.insertarEntrada(obj);
	}
	public List<AlmacenDTO> listarSalida(){
		return objPro.listarSalida();
	}
	public int insertarSalida(AlmacenDTO obj) {
		return objPro.insertarSalida(obj);
	}
}
