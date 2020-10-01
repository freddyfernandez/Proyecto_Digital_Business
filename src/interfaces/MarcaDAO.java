package interfaces;
import java.util.ArrayList;

import java.util.List;

import beans.MarcaDTO;



public interface MarcaDAO {
	public List<MarcaDTO> Listar_Marca();
	public int Registrar_Marca(MarcaDTO obj);
	public int Actualizar_Marca(MarcaDTO obj);
	public int Eliminar_Marca(int codigo);
	public MarcaDTO buscarMarca(int cod);
	
	public ArrayList<MarcaDTO> Listarxnombremarca();

}

