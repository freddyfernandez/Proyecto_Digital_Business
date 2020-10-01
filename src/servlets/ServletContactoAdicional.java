package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ContactoDTO;
import beans.Contacto_AdicionalDTO;

import service.ContactoService;
import service.Contacto_AdicionalService;
import service.PagoService;

/**
 * Servlet implementation class ServletContactoAdicional
 */
@WebServlet("/ServletContactoAdicional")
public class ServletContactoAdicional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Contacto_AdicionalService serviadicional= new Contacto_AdicionalService();
	ContactoService servicontacto=new ContactoService();
	PagoService servipago=new PagoService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContactoAdicional() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String xtipo=request.getParameter("tipo");
	    	
	    	if (xtipo.equals("lista_adicional"))
	    		lista(request,response);
	    	else if (xtipo.equals("cargar_registro"))
	    		cargar_registro(request,response);
	    	else if (xtipo.equals("registra_adicional"))
	    		registrar(request,response);
	    	else if (xtipo.equals("actualiza_adicional"))
	    		actualizar(request,response);
	    	else if (xtipo.equals("eliminar_adicional"))
	    		eliminar(request,response);
	    	else if (xtipo.equals("carga_actualiza"))
	    		carga_actualiza(request,response);
    }

	private void carga_actualiza(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cod=Integer.parseInt(request.getParameter("cod"));
		int codigo_contacto=serviadicional.buscarcodigoContacto(cod);
		serviadicional.Eliminar_Contacto_Adicional(cod);
		ContactoDTO x=servicontacto.buscarContacto(codigo_contacto);
		request.setAttribute("registro",x);
		request.setAttribute("pago",servipago.listaPago());
		request.setAttribute("data",serviadicional.Listar_Contacto_Adicional(codigo_contacto));
		request.getRequestDispatcher("Contacto_Adicional.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo_contacto = Integer.parseInt(request.getParameter("txt_codigoContacto"));
		request.setAttribute("pago",servipago.listaPago());
		int codigo_forma_pago = Integer.parseInt(request.getParameter("cbn_pago"));
		int codigo_banco =  Integer.parseInt(request.getParameter("txt_codigoBanco"));
		String nro_cuenta = request.getParameter("txt_numeroCuenta");
		String correo = request.getParameter("txt_correo");

		Contacto_AdicionalDTO obj = new Contacto_AdicionalDTO();
		obj.setCodigo_contacto(codigo_contacto);
		obj.setCodigo_forma_pago(codigo_forma_pago);
		obj.setCodigo_banco(codigo_banco);
		obj.setNro_cuenta(nro_cuenta);
		obj.setCorreo(correo);
		
		serviadicional.Registrar_Contacto_Adicional(obj);

		/*invoca al jsp crear detalle venta con combode productos precargados*/
		ContactoDTO x=servicontacto.buscarContacto(codigo_contacto);
		request.setAttribute("registro",x);
		request.setAttribute("pago",servipago.listaPago());
		request.setAttribute("data",serviadicional.Listar_Contacto_Adicional(codigo_contacto));
		request.getRequestDispatcher("Contacto_Adicional.jsp").forward(request, response);
		
	}

	private void cargar_registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		ContactoDTO x=servicontacto.buscarContacto(codigo);
		request.setAttribute("registro",x);
		request.setAttribute("pago",servipago.listaPago());
		request.setAttribute("data",serviadicional.Listar_Contacto_Adicional(codigo));
		request.getRequestDispatcher("Contacto_Adicional.jsp").forward(request,response);
		
		
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
