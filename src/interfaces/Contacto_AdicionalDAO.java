package interfaces;

import java.util.List;

import beans.Contacto_AdicionalDTO;

public interface Contacto_AdicionalDAO {
	public List<Contacto_AdicionalDTO> Listar_Contacto_Adicional(int codigo_contacto);
	public int Registrar_Contacto_Adicional(Contacto_AdicionalDTO obj);
	public int Actualizar_Contacto_Adicional(Contacto_AdicionalDTO obj);
	public int Eliminar_Contacto_Adicional(int codigo_contacto);
	public Contacto_AdicionalDTO buscarContacto_Adicional(int codigo_adicional);
	public Contacto_AdicionalDTO buscarContacto(int codigo_contacto);
	
	public int buscarcodigoContacto(int codigoadicional);
	
}
