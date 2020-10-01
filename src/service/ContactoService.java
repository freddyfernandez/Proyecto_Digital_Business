package service;
import java.util.ArrayList;

import java.util.List;

import beans.ContactoDTO;

import dao.DAOFactory;
import interfaces.ContactoDAO;


public class ContactoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ContactoDAO objPro=fabrica.getContacto();

	public List<ContactoDTO> listaContacto(){
		return objPro.Listar_Contacto();
	}
	
	public int registrarContacto (ContactoDTO obj) {
		return objPro.Registrar_Contacto(obj);
	}

	public int Actualizar_Contacto(ContactoDTO obj) {
		return objPro.Actualizar_Contacto(obj);
	}

	public int Eliminar_Contacto(int codigo_contacto) {
		return objPro.Eliminar_Contacto(codigo_contacto);
	}

	public ContactoDTO buscarContacto(int codigo_contacto) {
		return objPro.buscarContacto(codigo_contacto);
	}
	
	public ArrayList<ContactoDTO> consultaCliente(String filtro){
		return objPro.consultaCliente(filtro);
	}
	public List<ContactoDTO> Listar_Xtipo_Contacto(){
		return objPro.Listar_Xtipo_Contacto();
	}
	
    public List<ContactoDTO> Listar_Clientes(){
    	return objPro.Listar_Clientes();
    }
	
	public List<ContactoDTO> Listar_Proveedores(){
		return objPro.Listar_Proveedores();
	}


	
	
	
	
}
