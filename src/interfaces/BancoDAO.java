package interfaces;

import java.util.List;

import beans.BancoDTO;

public interface BancoDAO {
	public List<BancoDTO> Listar_Banco();
	public int Registrar_Banco(BancoDTO obj);
	public int Actualizar_Banco(BancoDTO obj);
	public int Eliminar_Banco(int codigo_banco);
	public BancoDTO buscarBanco(int codigo_banco);
}
