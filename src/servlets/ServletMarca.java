package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MarcaDTO;

import service.MarcaService;

/**
 * Servlet implementation class ServletMarca
 */
@WebServlet("/ServletMarca")
public class ServletMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MarcaService servimarca= new MarcaService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
	}

	

	private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	String des=req.getParameter("txt_des");
    	
    	MarcaDTO obj=new MarcaDTO();
    	obj.setNombre(des);
    	
    	servimarca.registraMarca(obj);
    	
    	

		req.setAttribute("data",servimarca.listaMarca());
    	req.getRequestDispatcher("Marca_List.jsp").forward(req,resp);
	}

	private void buscar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String cod=req.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		MarcaDTO x=servimarca.buscarMarca(codigo);
		req.setAttribute("registro",x);
		req.getRequestDispatcher("Marca_Update.jsp").forward(req,resp);
		
	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		req.setAttribute("data",servimarca.listaMarca());
    	req.getRequestDispatcher("Marca_List.jsp").forward(req,resp);
	}
	
	private void actualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		MarcaDTO obj=new MarcaDTO();
		int codigo=Integer.parseInt(req.getParameter("txt_cod"));
		String nombre=req.getParameter("txt_des");
		obj.setCodigo(codigo);
		obj.setNombre(nombre);
		
		servimarca.Actualizar_Marca(obj);
		
		listar(req,resp);
	
		
		
	}
	
	private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cod=Integer.parseInt(req.getParameter("cod"));
		servimarca.Eliminar_Marca(cod);
		listar(req,resp);
    	
	}

	
	
	
    
    
    
    

}
