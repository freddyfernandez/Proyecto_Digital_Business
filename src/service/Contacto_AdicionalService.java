package service;

import dao.DAOFactory;
import interfaces.Contacto_AdicionalDAO;

import java.util.List;

import beans.Contacto_AdicionalDTO;

public class Contacto_AdicionalService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	Contacto_AdicionalDAO objPro=fabrica.getContactoAdicional();
	
	public List<Contacto_AdicionalDTO> Listar_Contacto_Adicional(int codigo_contacto){
		return objPro.Listar_Contacto_Adicional(codigo_contacto);
	}
	public int Registrar_Contacto_Adicional(Contacto_AdicionalDTO obj) {
		return objPro.Registrar_Contacto_Adicional(obj);
	}
	public int Actualizar_Contacto_Adicional(Contacto_AdicionalDTO obj) {
		return objPro.Actualizar_Contacto_Adicional(obj);
	}
	public int Eliminar_Contacto_Adicional(int codigo_contacto) {
		return objPro.Eliminar_Contacto_Adicional(codigo_contacto);
	}
	public Contacto_AdicionalDTO buscarContacto_Adicional(int codigo_contacto) {
		return objPro.buscarContacto_Adicional(codigo_contacto);
	}
	public Contacto_AdicionalDTO buscarContacto(int codigo_contacto) {
		return objPro.buscarContacto(codigo_contacto);
	}
	
	public int buscarcodigoContacto(int codigoadicional)
	{
		return objPro.buscarcodigoContacto(codigoadicional);
	}
}
