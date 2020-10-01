package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactoDTO;

import service.ContactoService;

/**
 * Servlet implementation class ServletContacto
 */
@WebServlet("/ServletContacto")
public class ServletContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactoService servicontacto = new ContactoService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContacto() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String xtipo = req.getParameter("tipo");

		if (xtipo.equals("listarContacto"))
			listar(req, resp);
		else if (xtipo.equals("buscarContacto"))
			buscarContacto(req, resp);
		else if (xtipo.equals("registrarContacto"))
			registrarContacto(req, resp);
		else if (xtipo.equals("actualizarContacto"))
			actualizarContacto(req, resp);
		else if (xtipo.equals("eliminarContacto"))
			eliminarContacto(req, resp);
		
		else if(xtipo.equals("busca")){
			busca(req, resp);
		}else if(xtipo.equals("seleccione")){
			seleccione(req, resp);
		}
		
	    else if(xtipo.equals("cargarcontacto")){
		   cargarcontacto(req, resp);
	    }



	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("data", servicontacto.listaContacto());
		req.getRequestDispatcher("Contacto_List.jsp").forward(req, resp);
	}

	private void buscarContacto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo_contacto = req.getParameter("codigo_contacto");
		int codigo = Integer.parseInt(codigo_contacto);
		ContactoDTO x = servicontacto.buscarContacto(codigo);
		req.setAttribute("registro", x);
		req.getRequestDispatcher("Contacto_Update.jsp").forward(req, resp);

	}

	private void registrarContacto(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("contacto",servicontacto.Listar_Xtipo_Contacto());
		int codigo_tipo = Integer.parseInt(req.getParameter("cbn_contacto"));
		
		String codigo_ruc = req.getParameter("txt_codigo_ruc");
		int dni = Integer.parseInt(req.getParameter("txt_dni"));
		String razon_social = req.getParameter("txt_razon_social");
		String direccion = req.getParameter("txt_direccion");
		String telefono = req.getParameter("txt_telefono");

		ContactoDTO obj = new ContactoDTO();
		obj.setCodigo_tipo(codigo_tipo);
		obj.setCodigo_ruc(codigo_ruc);
		obj.setDni(dni);
		obj.setRazon_social(razon_social);
		obj.setDireccion(direccion);
		obj.setTelefono(telefono);

		servicontacto.registrarContacto(obj);

		req.setAttribute("data",servicontacto.listaContacto());
    	req.getRequestDispatcher("Contacto_Add.jsp").forward(req,resp);

	}

	private void actualizarContacto(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ContactoDTO obj = new ContactoDTO();
		int codigo_contacto = Integer.parseInt(req.getParameter("txt_codigoContacto"));

		int codigo_tipo = Integer.parseInt(req.getParameter("txt_codigo_tipo"));
		String codigo_ruc = req.getParameter("txt_codigo_ruc");
		int dni = Integer.parseInt(req.getParameter("txt_dni"));
		String razon_social = req.getParameter("txt_razon_social");
		String direccion = req.getParameter("txt_direccion");
		String telefono = req.getParameter("txt_telefono");

		obj.setCodigo_contacto(codigo_contacto);
		obj.setCodigo_tipo(codigo_tipo);
		obj.setCodigo_ruc(codigo_ruc);
		obj.setDni(dni);
		obj.setRazon_social(razon_social);
		obj.setDireccion(direccion);
		obj.setTelefono(telefono);

		servicontacto.Actualizar_Contacto(obj);
		
		req.setAttribute("data",servicontacto.listaContacto());
    	req.getRequestDispatcher("Contacto_Add.jsp").forward(req,resp);;
		
	
		
		

	}

	private void eliminarContacto(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int codigo_contacto = Integer.parseInt(req.getParameter("codigo_contacto"));

		servicontacto.Eliminar_Contacto(codigo_contacto);
		listar(req, resp);

	}
	
	protected void busca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro");
		
		if(filtro == null) filtro ="";
		
		List<ContactoDTO> data = servicontacto.consultaCliente(filtro);
		
		request.setAttribute("clientes", data);
		request.getRequestDispatcher("boleta.jsp").forward(request, response);

	}
	protected void seleccione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String dni = request.getParameter("dni");
		String nom = request.getParameter("nom");
		String tel = request.getParameter("tel");
		
		String cliente = id +":" + dni+ " " + nom+ " " + tel;
		
		HttpSession session = request.getSession();
		session.setAttribute("datoCliente", cliente);
		
		request.getRequestDispatcher("boleta.jsp").forward(request, response);	
	}
	
	private void cargarcontacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("contacto",servicontacto.Listar_Xtipo_Contacto());
		request.getRequestDispatcher("Contacto_Add.jsp").forward(request,response);
	}



}
