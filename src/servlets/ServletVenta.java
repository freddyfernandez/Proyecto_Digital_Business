package servlets;

import java.io.IOException;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.VentaDTO;
import beans.Detalle_VentaDTO;
import beans.Factura_VentaDTO;
import beans.ProductoDTO;
import service.VentaService;
import service.ContactoService;
import service.Detalle_VentaService;
import service.EmpleadoService;
import service.Factura_VentaService;
import service.ProductoService;



/**
 * Servlet implementation class ServletVenta
 */
@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VentaService ServiVenta=new VentaService();
	Detalle_VentaService ServiDetalle=new Detalle_VentaService();
	ProductoService producto = new ProductoService();
	EmpleadoService serviempleado = new EmpleadoService();
	Factura_VentaService servifactura=new Factura_VentaService();
	ContactoService servicontacto=new ContactoService();
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String xtipo=request.getParameter("tipo");
	    	
	    	if (xtipo.equals("listarVenta"))
	    		listar(request,response);
	    	else if (xtipo.equals("buscarVenta"))
	    		buscar(request,response);
	    	else if (xtipo.equals("registrarVenta"))
	    		registrar(request,response);
	    	else if (xtipo.equals("actualizarVenta"))
	    		actualizar(request,response);
	    	else if (xtipo.equals("eliminarVenta"))
	    		eliminar(request,response);
	    	
	    	else if (xtipo.equals("listarDetalleVenta"))
	    		listarDetalle(request,response);
	    	else if (xtipo.equals("buscarDetalleVenta"))
	    		buscarDetalle(request,response);
	    	else if (xtipo.equals("cargarDetalleVenta"))
	    		cargarDetalle(request,response);
	    	else if (xtipo.equals("registrarDetalleVenta"))
	    		registrarDetalle(request,response);
	    	else if (xtipo.equals("actualizarDetalleVenta"))
	    		actualizarDetalle(request,response);
	    	else if (xtipo.equals("eliminarDetalleVenta"))
	    		eliminarDetalle(request,response);
	    	
	    	
	    	
	    	else if (xtipo.equals("comboproducto"))
	    		comboproducto(request,response);
	    	else if (xtipo.equals("comboempleado"))
	    		comboempleado(request,response);
	    	
	    	else if (xtipo.equals("listarFactura"))
	    		listarFactura(request,response);
	    	else if (xtipo.equals("registrarFactura"))
	    		registrarFactura(request,response);
	    	else if (xtipo.equals("cargaregistrofactura"))
	    		cargaRegistroFactura(request,response);
	    	else if (xtipo.equals("actualizarFactura"))
	    		actualizarFactura(request,response);
	    
	    	else if (xtipo.equals("buscarFactura"))
	    		buscarFactura(request,response);
	    	else if (xtipo.equals("listarXestado"))
	    		listarXestado(request,response);
	    	else if (xtipo.equals("listarXfecha"))
	    		listarXfecha(request,response);
	    	else if (xtipo.equals("eliminarFactura"))
	    		eliminarFactura(request,response);
	    	
	    	
	    	else if(xtipo.equals("ingresa")){
				ingresa(request, response);
			}else if(xtipo.equals("elimina")){
				elimina(request, response);
			}else if(xtipo.equals("registra")){
				registra(request, response);
			}

	    	
	    	
	}

	

	private void listarXfecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String f1=request.getParameter("txt_fechainicial");
		String f2=request.getParameter("txt_fechafinal");
		List<Factura_VentaDTO> x=servifactura.listar_FacturaXFecha(f1, f2);
		request.setAttribute("data",x);
		request.getRequestDispatcher("Ventas_XFecha.jsp").forward(request, response);
	}

	private void listarXestado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		List<Factura_VentaDTO> x= servifactura.listar_FacturaxEstado(codigo);
		request.setAttribute("data",x);
		if (codigo==1)
			request.getRequestDispatcher("Cobros_Pendientes.jsp").forward(request,response);
		   
		else if(codigo==2)
			request.getRequestDispatcher("Cobrados.jsp").forward(request,response);
	}

	private void eliminarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo = Integer.parseInt(request.getParameter("cod"));
		servifactura.eliminar_Factura_Venta(codigo);
		listarFactura(request, response);
	}

	private void buscarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		Factura_VentaDTO x=servifactura.buscarFactura_Venta(codigo);
		
		request.setAttribute("registro",x);
		request.setAttribute("estado",servifactura.listar_Estado());
		request.getRequestDispatcher("Factura_Venta_Update.jsp").forward(request,response);
	}

	private void actualizarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo_Factura = Integer.parseInt(request.getParameter("txt_codigoFactura"));
		int codigo_venta=Integer.parseInt(request.getParameter("txt_codigoVenta"));
		int empleado=Integer.parseInt(request.getParameter("txt_codigoEmpleado"));
		int estado=Integer.parseInt(request.getParameter("cbn_estado"));
	
		String fecha=request.getParameter("txt_fecha");
       
   	
        Factura_VentaDTO obj=new Factura_VentaDTO();
        
		obj.setCodigo_venta(codigo_venta);
		obj.setCodigo_empleado(empleado);
		obj.setEstado(estado);
		obj.setFecha(Date.valueOf(fecha));
		obj.setCodigo_factura(codigo_Factura);
		
		servifactura.actualizar_Factura_Venta(obj);
		listarFactura(request,response);
		
		
	}

	private void registrarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		int codigo_venta=Integer.parseInt(request.getParameter("txt_codigoVenta"));
		request.setAttribute("empleado",serviempleado.Listarxnombreempleado());
		int empleado=Integer.parseInt(request.getParameter("cbn_empleado"));
		request.setAttribute("estado",servifactura.listar_Estado());
		int estado=Integer.parseInt(request.getParameter("cbn_estado"));
		String fecha=request.getParameter("txt_fecha");
       
   	
        Factura_VentaDTO obj=new Factura_VentaDTO();
        
		obj.setCodigo_venta(codigo_venta);
		obj.setCodigo_empleado(empleado);
		obj.setEstado(estado);
		obj.setFecha(Date.valueOf(fecha));
		    	
   	
		servifactura.registrar_Factura_Venta(obj);
		request.setAttribute("data",servifactura.listar_Factura_Venta());
		request.getRequestDispatcher("Factura_Venta_List.jsp").forward(request,response);
		
		
	}

	

	private void listarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("data",servifactura.listar_Factura_Venta());
		request.getRequestDispatcher("Factura_Venta_List.jsp").forward(request,response);
	}
	private void cargaRegistroFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		request.setAttribute("empleado",serviempleado.Listarxnombreempleado());
		request.setAttribute("estado",servifactura.listar_Estado());
		request.getRequestDispatcher("Factura_Venta_Add.jsp").forward(request,response);
	}
	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod=Integer.parseInt(request.getParameter("cod"));
		ServiVenta.Eliminar_Venta(cod);
		listar(request,response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo=Integer.parseInt(request.getParameter("txt_codigoVenta"));
		String fecha=request.getParameter("txt_fecha");
        int empleado = Integer.parseInt(request.getParameter("txt_codigoEmpleado"));
        int cliente = Integer.parseInt(request.getParameter("txt_codigoCliente"));
        
       
        VentaDTO obj=new VentaDTO();        
		obj.setCodigo_venta(codigo);
		obj.setFecha(Date.valueOf(fecha));
		obj.setCodigo_empleado(empleado);
		obj.setCodigo_cliente(cliente);
		
		
		ServiVenta.Actualizar_Venta(obj);
		
		listar(request,response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fecha=request.getParameter("txt_fecha");
		
      
        request.setAttribute("empleado",serviempleado.Listarxnombreempleado());
		int codigo=Integer.parseInt(request.getParameter("cbn_empleado"));
		
		request.setAttribute("cliente",servicontacto.Listar_Clientes());
        int cliente = Integer.parseInt(request.getParameter("cbn_cliente"));
   	
        VentaDTO obj=new VentaDTO();        
		
		obj.setFecha(Date.valueOf(fecha));
		obj.setCodigo_empleado(codigo);
		obj.setCodigo_cliente(cliente);    	
   	
		ServiVenta.Registrar_Venta(obj); 
		
		/*invoca al jsp crear detalle venta con combode productos precargados*/
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		request.setAttribute("producto",producto.Listarxnombreproducto());
		request.getRequestDispatcher("Detalle_Venta_Add.jsp").forward(request,response);
		
   	
   			
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		VentaDTO x=ServiVenta.buscarVenta(codigo);
		
		request.setAttribute("registro",x);
		request.getRequestDispatcher("Venta_Update.jsp").forward(request,response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("data",ServiVenta.listar_Venta());
		request.getRequestDispatcher("Venta_List.jsp").forward(request,response);
	}
    
	private void listarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		List<Detalle_VentaDTO> x= ServiDetalle.listar_Detalle_Venta(codigo);
		
		/*precarga el combo productos*/
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		request.setAttribute("producto",producto.Listarxnombreproducto());
		
		request.setAttribute("data",x);
		request.getRequestDispatcher("Detalle_Venta_List.jsp").forward(request,response);
	}
	private void eliminarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		     int cod=Integer.parseInt(request.getParameter("cod"));
		     int x= ServiDetalle.buscar_Venta(cod);
		     ServiDetalle.Eliminar_Detalle_Venta(cod);
		
			/*precarga el combo productos,codigo venta y lista deacuerdo al codigo venta*/
		    request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
			request.setAttribute("producto",producto.Listarxnombreproducto());
			VentaDTO y=ServiVenta.buscarVenta(x);
			request.setAttribute("registro",y);
			List<Detalle_VentaDTO> z= ServiDetalle.listar_Detalle_Venta(x);
			request.setAttribute("data",z);
			request.getRequestDispatcher("Detalle_Venta_List.jsp").forward(request,response);
		
		
	}
	private void actualizarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		int codigo_detalle=Integer.parseInt(request.getParameter("txt_codigoDetalle"));
		int codigo_venta=Integer.parseInt(request.getParameter("txt_codigoVenta"));
		int codigo=Integer.parseInt(request.getParameter("txt_codigoProducto"));
		double precio_venta=Double.parseDouble(request.getParameter("txt_precio_Venta"));
        int cantidad = Integer.parseInt(request.getParameter("txt_cantidad"));
        int descuento = Integer.parseInt(request.getParameter("txt_descuento"));
        
       
        Detalle_VentaDTO obj=new Detalle_VentaDTO(); 
        obj.setCodigo_detalle(codigo_detalle);
		obj.setCodigo_venta(codigo_venta);
		obj.setCodigo_producto(codigo);
		obj.setPrecio_venta(precio_venta);
		obj.setCantidad(cantidad);
		obj.setDescuento(descuento);
		
		ServiDetalle.Actualizar_Detalle_Venta(obj);
		
		/*precarga el los labels*/
		request.setAttribute("producto",producto.Listarxnombreproducto());
		VentaDTO cv=ServiVenta.buscarVenta(codigo_venta);
		request.setAttribute("registro",cv);
		List<Detalle_VentaDTO> x= ServiDetalle.listar_Detalle_Venta(codigo_venta);
		request.setAttribute("data",x);
		request.getRequestDispatcher("Detalle_Venta_List.jsp").forward(request,response);
		
	}
	private void registrarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		int codigo_venta=Integer.parseInt(request.getParameter("txt_codigoVenta"));
		request.setAttribute("producto",producto.Listarxnombreproducto());
		int codigo=Integer.parseInt(request.getParameter("cbn_producto"));
		double precio_venta=Double.parseDouble(request.getParameter("txt_precio_Venta"));
        int cantidad = Integer.parseInt(request.getParameter("txt_cantidad"));
        int descuento = Integer.parseInt(request.getParameter("txt_descuento"));
   	
        Detalle_VentaDTO obj=new Detalle_VentaDTO();
        
		obj.setCodigo_venta(codigo_venta);
		obj.setCodigo_producto(codigo);
		obj.setPrecio_venta(precio_venta);
		obj.setCantidad(cantidad);
		obj.setDescuento(descuento);    	
   	
		ServiDetalle.Registrar_Detalle_Venta(obj);   
		VentaDTO cv=ServiVenta.buscarVenta(codigo_venta);
		request.setAttribute("registro",cv);
		List<Detalle_VentaDTO> x= ServiDetalle.listar_Detalle_Venta(codigo_venta);
		request.setAttribute("data",x);
		request.getRequestDispatcher("Detalle_Venta_List.jsp").forward(request,response);
		
		
	}

	
	private void buscarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		Detalle_VentaDTO x=ServiDetalle.buscarDetalle_Venta(codigo);
		request.setAttribute("registro",x);
		request.getRequestDispatcher("Detalle_Venta_Update.jsp").forward(request,response);
	}
	private void cargarDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		VentaDTO x=ServiVenta.buscarVenta(codigo);
		request.setAttribute("registro",x);
		request.setAttribute("producto",producto.Listarxnombreproducto());	
		request.setAttribute("data",ServiDetalle.listar_Detalle_Venta(codigo));
		request.getRequestDispatcher("Detalle_Venta_List.jsp").forward(request,response);
	}
	
	
	
	private void comboproducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("buscarventa",ServiVenta.buscarCodigoVenta());
		request.setAttribute("producto",producto.Listarxnombreproducto());
		request.getRequestDispatcher("Detalle_Venta_Add.jsp").forward(request,response);
	}
	private void comboempleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("empleado",serviempleado.Listarxnombreempleado());
		request.setAttribute("cliente",servicontacto.Listar_Clientes());
		request.getRequestDispatcher("Venta_Add.jsp").forward(request,response);
	}
	
	
	/*metodos transacciones*/
	@SuppressWarnings("unchecked")
	protected void ingresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String producto = request.getParameter("producto");
		String cantidad = request.getParameter("cantidad");
		
		String idProducto = producto.split(":")[0];
		String nombre = producto.split(":")[1];
		String precio = producto.split(":")[2];
		
		int idProd = Integer.parseInt(idProducto);
		int cant = Integer.parseInt(cantidad);
		double pre = Double.parseDouble(precio);
				
		ArrayList<ProductoDTO> boleta  ;
		
		//Se verifica si existe en sesion
		HttpSession session = request.getSession();
		if(session.getAttribute("boleta") == null){
			boleta = new ArrayList<ProductoDTO>();
		}else{
			boleta = (ArrayList<ProductoDTO>)session.getAttribute("boleta");
		}
		
		//Se crear el objeto
		ProductoDTO p = new ProductoDTO();
		p.setCodigo(idProd);
		p.setNombre(nombre);
		p.setStock(cant);
		p.setPrecio(pre);
		
		boolean noExiste = true;
		//se verifica los repetidos
		for (int i = 0; i < boleta.size(); i++) {
			if(boleta.get(i).getCodigo() == idProd){
				boleta.set(i, p);
				noExiste = false;
				break;
			}
		}
		
		//Si no existe se agrega
		if(noExiste){
			boleta.add(p);
		}
		
		//la lista se agrega a sesion
		session.setAttribute("boleta", boleta);
		
		request.getRequestDispatcher("boleta.jsp").forward(request, response);	

	}
	
	@SuppressWarnings("unchecked")
	protected void elimina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		ArrayList<ProductoDTO> boleta = 
				(ArrayList<ProductoDTO>)session.getAttribute("boleta");

		//Se elimina
		for (ProductoDTO p : boleta) {
			if(p.getCodigo() == Integer.parseInt(id)){
				boleta.remove(p);
				break;
			}
		}
		//la lista se agrega a sesion
		session.setAttribute("boleta", boleta);
		
		request.getRequestDispatcher("boleta.jsp").forward(request, response);	
	}
	
	@SuppressWarnings("unchecked")
	protected void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Boleta que esta en sesion
		ArrayList<ProductoDTO> boleta = (ArrayList<ProductoDTO>)session.getAttribute("boleta");
		
		//Cliente que esta en sesion
		String cliente=	(String)session.getAttribute("datoCliente");
		int idCliente = Integer.parseInt(cliente.split(":")[0]);
		
		//Creamos la Boleta
		VentaDTO b = new VentaDTO();
		
		
		
		b.setCodigo_empleado(11);
		b.setCodigo_cliente(idCliente);
			
		//Creamos el detalle
		ArrayList<Detalle_VentaDTO> detalles = new ArrayList<Detalle_VentaDTO>();
		for (ProductoDTO x : boleta) {
			Detalle_VentaDTO det = new Detalle_VentaDTO();
			det.setCantidad(x.getStock());
			det.setCodigo_producto(x.getCodigo());
			det.setPrecio_venta(x.getPrecio());
			det.importeTotal();
			detalles.add(det);
		}
		
		//Se inserta la boleta
		
		
		ServiVenta.inserta(b, detalles);
		
		//limpiamos la sesion
		session.removeAttribute("boleta");
		session.removeAttribute("datoCliente");
		session.removeAttribute("datoProducto");
		
		//reenvio
		
		cargaRegistroFactura(request, response);	
	}





}
