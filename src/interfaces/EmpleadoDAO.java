package interfaces;

import java.util.ArrayList;
import java.util.List;

import beans.EmpleadoDTO;

public interface EmpleadoDAO {
	public List<EmpleadoDTO> Listar_Empleado();
	public int Registrar_Empleado(EmpleadoDTO obj);
	public int Actualizar_Empleado(EmpleadoDTO obj);
	public int Eliminar_Empleado(int codigo);
	public EmpleadoDTO buscarEmpleado(int cod);
	
	public ArrayList<EmpleadoDTO> Listarxnombreempleado();
	
	public EmpleadoDTO iniciarSesion(String login);

}
