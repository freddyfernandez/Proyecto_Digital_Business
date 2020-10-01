package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EmpleadoDTO;

import service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpleadoService serviEmpleado= new EmpleadoService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String xtipo=req.getParameter("tipo");
    	if (xtipo.equals("listar"))
    		listar(req,resp);
    	else if (xtipo.equals("buscar"))
    		buscar(req,resp);
    	else if (xtipo.equals("registrar"))
    		registrar(req,resp);
    	else if (xtipo.equals("actualizar"))
    		actualizar(req,resp);
    	else if (xtipo.equals("eliminar"))
    		eliminar(req,resp);
    
    	else if (xtipo.equals("sesion"))
			iniciarSesion(req, resp);
		else if (xtipo.equals("cerrarSesion"))
			cerrarSesion(req, resp);
		
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "iniciarSesion");
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xlogin=request.getParameter("txt_login");
		String xpass=request.getParameter("txt_pass");
		
		EmpleadoDTO obj=serviEmpleado.iniciarSesion(xlogin);
		if(obj!=null) {
		  if(obj.getPassword().equals(xpass)) {
			  HttpSession sesion=request.getSession();
			  sesion.setAttribute("datos",obj);
			  request.getRequestDispatcher("index.jsp").forward(request, response);
		  }
		  else {
			  request.setAttribute("msg", "costraseña incorrecta");
			  request.getRequestDispatcher("Login.jsp").forward(request, response);
		  }
		}
		else {
			request.setAttribute("msg", "usuario no existe");
			  request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		
		
	}

	

	private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	String des=req.getParameter("txt_des");
    	String ape=req.getParameter("txt_ape");
    	String log=req.getParameter("txt_log");
    	String pas=req.getParameter("txt_pas");
    	String det=req.getParameter("txt_det");
    	
    	EmpleadoDTO obj=new EmpleadoDTO();
    	obj.setNombre(des);
    	obj.setApellido(ape);
    	obj.setLogin(log);
    	obj.setPassword(pas);
    	obj.setDetalle(det);
    	serviEmpleado.registraEmpleado(obj);
    	
    	

    	listar(req,resp);
    	
	}

	private void buscar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String cod=req.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		EmpleadoDTO x=serviEmpleado.buscarEmpleado(codigo);
		req.setAttribute("registro",x);
		req.getRequestDispatcher("Empleado_Update.jsp").forward(req,resp);
		
	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.setAttribute("data",serviEmpleado.listaEmpleado());
    	req.getRequestDispatcher("Empleado_List.jsp").forward(req,resp);
	}
	
	private void actualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		EmpleadoDTO obj=new EmpleadoDTO();
		int codigo=Integer.parseInt(req.getParameter("txt_cod"));
		String nombre=req.getParameter("txt_des");
		String apellido=req.getParameter("txt_ape");
		String login=req.getParameter("txt_log");
		String password=req.getParameter("txt_pas");
		String detalle=req.getParameter("txt_det");
		
		obj.setCodigo(codigo);
		obj.setNombre(nombre);
		obj.setApellido(apellido);
		obj.setLogin(login);
		obj.setPassword(password);
		obj.setDetalle(detalle);
		serviEmpleado.Actualizar_Empleado(obj);
		
		listar(req,resp);
	
		
		
	}
	
	private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cod=Integer.parseInt(req.getParameter("cod"));
		serviEmpleado.Eliminar_Empleado(cod);
		listar(req,resp);
    	
	}

	
	
	
    
    
    
    

}
