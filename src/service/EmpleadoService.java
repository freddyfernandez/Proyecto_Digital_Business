package service;

import java.util.ArrayList;
import java.util.List;

import beans.ContactoDTO;
import beans.EmpleadoDTO;

import dao.DAOFactory;
import interfaces.EmpleadoDAO;



public class EmpleadoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    EmpleadoDAO objPro=fabrica.getEmpleado();

	
	public List<EmpleadoDTO> listaEmpleado(){
		return objPro.Listar_Empleado();
	}
	
	public int registraEmpleado(EmpleadoDTO obj) {
		return objPro.Registrar_Empleado(obj);
	}

	public int Actualizar_Empleado(EmpleadoDTO obj) {
		return objPro.Actualizar_Empleado(obj);
	}

	public int Eliminar_Empleado(int codigo) {
		return objPro.Eliminar_Empleado(codigo);
	}

	public EmpleadoDTO buscarEmpleado(int cod) {
		return objPro.buscarEmpleado(cod);
	}
	
	public ArrayList<EmpleadoDTO> Listarxnombreempleado(){
		return objPro.Listarxnombreempleado();
	}
	
	public EmpleadoDTO iniciarSesion(String login) {
		return objPro.iniciarSesion(login);
	}
	

	

}
