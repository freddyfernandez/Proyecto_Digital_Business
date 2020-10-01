package interfaces;

import java.util.List;

import beans.AlmacenDTO;

public interface AlmacenDAO {
	public List<AlmacenDTO> listarEntrada();
	public int insertarEntrada(AlmacenDTO obj);
	public List<AlmacenDTO> listarSalida();
	public int insertarSalida(AlmacenDTO obj);
}
