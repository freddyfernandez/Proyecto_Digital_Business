package interfaces;

import java.util.ArrayList;
import java.util.List;

import beans.ContactoDTO;;

public interface ContactoDAO {
	public List<ContactoDTO> Listar_Contacto();
	public int Registrar_Contacto(ContactoDTO obj);
	public int Actualizar_Contacto(ContactoDTO obj);
	public int Eliminar_Contacto(int codigo_contacto);
	public ContactoDTO buscarContacto(int codigo_contacto);
	
	public ArrayList<ContactoDTO> consultaCliente(String filtro);
	
	public List<ContactoDTO> Listar_Xtipo_Contacto();
	
	public List<ContactoDTO> Listar_Clientes();
	
	public List<ContactoDTO> Listar_Proveedores();
	
	



}
