package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AlmacenDTO;
import beans.Factura_VentaDTO;
import service.AlmacenService;
import service.ProductoService;

/**
 * Servlet implementation class ServletAlmacen
 */
@WebServlet("/ServletAlmacen")
public class ServletAlmacen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService serviproducto=new ProductoService();
	AlmacenService servialmacen=new AlmacenService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlmacen() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String xtipo=request.getParameter("tipo");
	    	
	    	if (xtipo.equals("listarEntrada"))
	    		listarEntrada(request,response);
	    	else if (xtipo.equals("registrarEntrada"))
	    		registrarEntrada(request,response);
	    	else if (xtipo.equals("listarSalida"))
	    		listarSalida(request,response);
	    	else if (xtipo.equals("registrarSalida"))
	    		registrarSalida(request,response);
	    	else if (xtipo.equals("cargar"))
	    		cargar(request,response);
	    	
    }

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		if (codigo==1) {
			request.setAttribute("data",servialmacen.listarEntrada());
			request.getRequestDispatcher("Movimiento_Entrada.jsp").forward(request,response);
		}
		else if(codigo==2) {
			request.setAttribute("data",servialmacen.listarSalida());
			request.getRequestDispatcher("Movimiento_Salida.jsp").forward(request,response);
		}
	}
		

	private void registrarSalida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		int codigo_producto=Integer.parseInt(request.getParameter("cbn_producto"));
		int cantidad_salida = Integer.parseInt(request.getParameter("txt_cantidad"));
		String fecha_salida=request.getParameter("txt_fecha");
        
		AlmacenDTO obj = new AlmacenDTO();	
   	
		obj.setCodigo_producto(codigo_producto);
		obj.setCantidad_salida(cantidad_salida);
		obj.setFecha_salida(Date.valueOf(fecha_salida));
 	
		servialmacen.insertarSalida(obj);
		
		/*invoca al jsp crear detalle venta con combode productos precargados*/
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		request.setAttribute("data",servialmacen.listarSalida());
		request.getRequestDispatcher("Movimiento_Salida.jsp").forward(request,response);
	}

	private void listarSalida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		request.setAttribute("data",servialmacen.listarSalida());
		request.getRequestDispatcher("Movimiento_Salida.jsp").forward(request,response);
	}

	private void registrarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		int codigo_producto=Integer.parseInt(request.getParameter("cbn_producto"));
		int cantidad_entrada = Integer.parseInt(request.getParameter("txt_cantidad"));
		String fecha_entrada=request.getParameter("txt_fecha");
        
		AlmacenDTO obj = new AlmacenDTO();	
   	
		obj.setCodigo_producto(codigo_producto);
		obj.setCantidad_entrada(cantidad_entrada);
		obj.setFecha_entrada(Date.valueOf(fecha_entrada));
 	
		servialmacen.insertarEntrada(obj);
		
		/*invoca al jsp crear detalle venta con combode productos precargados*/
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		request.setAttribute("data",servialmacen.listarEntrada());
		request.getRequestDispatcher("Movimiento_Entrada.jsp").forward(request,response);
	}

	private void listarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("producto",serviproducto.Listarxnombreproducto());
		request.setAttribute("data",servialmacen.listarEntrada());
		request.getRequestDispatcher("Movimiento_Entrada.jsp").forward(request,response);
	}

}
