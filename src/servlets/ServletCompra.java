package servlets;

import java.io.IOException;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CompraDTO;
import beans.Detalle_CompraDTO;
import beans.Factura_CompraDTO;
import beans.Factura_VentaDTO;
import service.CompraService;
import service.ContactoService;
import service.Detalle_CompraService;
import service.EmpleadoService;
import service.FacturaCompraService;
import service.ProductoService;

/**
 * Servlet implementation class ServletCompra
 */
@WebServlet("/ServletCompra")
public class ServletCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CompraService ServiCompra = new CompraService();
	Detalle_CompraService ServiDetalle = new Detalle_CompraService();
	FacturaCompraService ServiFactura = new FacturaCompraService();
	ContactoService servicontacto=new ContactoService();
	ProductoService producto = new ProductoService();
	EmpleadoService serviempleado = new EmpleadoService();
	
	
	public ServletCompra() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String xtipo = request.getParameter("tipo");

		if (xtipo.equals("listarCompra"))
			listar(request, response);
		else if (xtipo.equals("buscarCompra"))
			buscar(request, response);
		else if (xtipo.equals("registrarCompra"))
			registrar(request, response);
		else if (xtipo.equals("actualizarCompra"))
			actualizar(request, response);
		else if (xtipo.equals("eliminarCompra"))
			eliminar(request, response);

		else if (xtipo.equals("listarDetalleCompra"))
			listarDetalle(request, response);
		else if (xtipo.equals("buscarDetalleCompra"))
			buscarDetalle(request, response);
		else if (xtipo.equals("registrarDetalleCompra"))
			registrarDetalle(request, response);
		else if (xtipo.equals("actualizarDetalleCompra"))
			actualizarDetalle(request, response);
		else if (xtipo.equals("eliminarDetalleCompra"))
			eliminarDetalle(request, response);

		else if (xtipo.equals("listarFacturaCompra"))
			listarFactura(request, response);
		else if (xtipo.equals("buscarFacturaCompra"))
			buscarFactura(request, response);
		else if (xtipo.equals("registrarFacturaCompra"))
			registrarFactura(request, response);
		else if (xtipo.equals("actualizarFacturaCompra"))
			actualizarFactura(request, response);
		else if (xtipo.equals("eliminarFacturaCompra"))
			eliminarFactura(request, response);
		
		else if(xtipo.equals("cargaRegistroFactura"))
			cargaRegistroFactura(request,response);
		else if(xtipo.equals("cargaproveedor"))
			cargaXproveedor(request,response);
		else if(xtipo.equals("facturasXproveedor"))
			facturasXproveedor(request,response);

		else if (xtipo.equals("comboproducto"))
			comboproducto(request, response);
		else if (xtipo.equals("comboempleado"))
			comboempleado(request, response);
		else if (xtipo.equals("comboestado"))
			comboestado(request, response);

	}



	private void cargaXproveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("proveedor",servicontacto.Listar_Proveedores());
		request.getRequestDispatcher("Compras_XProveedor.jsp").forward(request,response);
	}
	private void facturasXproveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("proveedor",servicontacto.Listar_Proveedores());
		int codigo_contacto=Integer.parseInt(request.getParameter("cbn_proveedor"));
		request.setAttribute("data",ServiFactura.FacturasXProveedor(codigo_contacto));
		request.getRequestDispatcher("Compras_XProveedor.jsp").forward(request,response);
	}
	
	
	
	

	private void eliminarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("cod"));
		ServiFactura.Eliminar_Factura_Compra(codigo);
		listar(request, response);
	}

	private void actualizarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("txt_codigoFactura"));
		int codigo_compra = Integer.parseInt(request.getParameter("txt_codigoCompra"));
		int empleado = Integer.parseInt(request.getParameter("txt_codigoEmpleado"));
		String fecha = request.getParameter("txt_fecha");
		int estado = Integer.parseInt(request.getParameter("cbn_estado"));


		Factura_CompraDTO obj = new Factura_CompraDTO();
		obj.setCodigo_factura(codigo);
		obj.setCodigo_compra(codigo_compra);
		obj.setCodigo_empleado(empleado);
		obj.setEstado(estado);
		obj.setFecha(Date.valueOf(fecha));
		
		ServiFactura.Actualizar_Factura_Compra(obj);

		listarFactura(request, response);
		

	}

	private void registrarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("buscarcompra",ServiCompra.buscarCodigoCompra());
		int codigo_compra = Integer.parseInt(request.getParameter("txt_codigoCompra"));
		request.setAttribute("empleado", serviempleado.Listarxnombreempleado());
		int empleado = Integer.parseInt(request.getParameter("cbn_empleado"));
		request.setAttribute("estado", ServiFactura.Listarxestado());
		int estado = Integer.parseInt(request.getParameter("cbn_estado"));
		String fecha = request.getParameter("txt_fecha");
		
		
		
		
		Factura_CompraDTO obj = new Factura_CompraDTO();
		
		obj.setCodigo_compra(codigo_compra);
		obj.setCodigo_empleado(empleado);
		obj.setEstado(estado);
		obj.setFecha(Date.valueOf(fecha));
		

		ServiFactura.Registrar_Factura_Compra(obj);
		
		request.setAttribute("data",ServiFactura.listar_Factura_Compra());
		request.getRequestDispatcher("Factura_Compra_List.jsp").forward(request,response);

	}

	private void buscarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("cod");
		int codigo = Integer.parseInt(cod);
		Factura_CompraDTO x = ServiFactura.buscarFactura_Compra(codigo);
		request.setAttribute("registro", x);
		request.setAttribute("estado",ServiFactura.Listarxestado());
		request.getRequestDispatcher("Factura_Compra_Update.jsp").forward(request, response);

	}

	private void listarFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", ServiFactura.listar_Factura_Compra());
		request.getRequestDispatcher("Factura_Compra_List.jsp").forward(request, response);

	}
	
	private void cargaRegistroFactura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("buscarcompra",ServiCompra.buscarCodigoCompra());
		request.setAttribute("empleado",serviempleado.Listarxnombreempleado());
		request.setAttribute("estado",ServiFactura.Listarxestado());
		request.getRequestDispatcher("Factura_Compra_Add.jsp").forward(request,response);
	}
	
	/*--------------------------------------------------------------------------------------*/

	
	
	
	
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cod = Integer.parseInt(request.getParameter("cod"));
		ServiCompra.Eliminar_Compra(cod);
		listar(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("txt_codigoCompra"));
		String fecha = request.getParameter("txt_fecha");
		int empleado = Integer.parseInt(request.getParameter("txt_codigoEmpleado"));
		int cliente = Integer.parseInt(request.getParameter("txt_codigoCliente"));

		CompraDTO obj = new CompraDTO();
		obj.setCodigo_compra(codigo);
		obj.setFecha(Date.valueOf(fecha));
		obj.setCodigo_empleado(empleado);
		obj.setCodigo_cliente(cliente);

		ServiCompra.Actualizar_Compra(obj);

		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fecha = request.getParameter("txt_fecha");

		request.setAttribute("empleado", serviempleado.Listarxnombreempleado());
		int codigo = Integer.parseInt(request.getParameter("cbn_empleado"));
		int cliente = Integer.parseInt(request.getParameter("txt_codigoCliente"));

		CompraDTO obj = new CompraDTO();

		obj.setFecha(Date.valueOf(fecha));
		obj.setCodigo_empleado(codigo);
		obj.setCodigo_cliente(cliente);

		ServiCompra.Registrar_Compra(obj);

		/* invoca al jsp crear detalle Compra con combode productos precargados */
		request.setAttribute("producto", producto.Listarxnombreproducto());
		request.getRequestDispatcher("Detalle_Compra_Add.jsp").forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cod = request.getParameter("cod");
		int codigo = Integer.parseInt(cod);
		CompraDTO x = ServiCompra.buscarCompra(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("Compra_Update.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data", ServiCompra.listar_Compra());
		request.getRequestDispatcher("Compra_List.jsp").forward(request, response);
	}

	private void listarDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod = request.getParameter("cod");
		int codigo = Integer.parseInt(cod);
		List<Detalle_CompraDTO> x = ServiDetalle.listar_Detalle_Compra(codigo);

		/* precarga el combo productos */
		request.setAttribute("producto", producto.Listarxnombreproducto());

		request.setAttribute("data", x);

		request.getRequestDispatcher("Detalle_Compra_List.jsp").forward(request, response);
	}

	private void eliminarDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cod = Integer.parseInt(request.getParameter("cod"));
		ServiDetalle.Eliminar_Detalle_Compra(cod);

		List<Detalle_CompraDTO> x = ServiDetalle.listar_Detalle_Compra(cod);

		/* precarga el combo productos */
		request.setAttribute("producto", producto.Listarxnombreproducto());

		request.setAttribute("data", x);
		request.getRequestDispatcher("Detalle_Compra_List.jsp").forward(request, response);

	}

	private void actualizarDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo_detalle = Integer.parseInt(request.getParameter("txt_codigoDetalle"));
		int codigo_Compra = Integer.parseInt(request.getParameter("txt_codigoCompra"));

		int codigo = Integer.parseInt(request.getParameter("txt_codigoProducto"));
		double precio_Compra = Double.parseDouble(request.getParameter("txt_precio_Compra"));
		int cantidad = Integer.parseInt(request.getParameter("txt_cantidad"));
		int descuento = Integer.parseInt(request.getParameter("txt_descuento"));

		Detalle_CompraDTO obj = new Detalle_CompraDTO();
		obj.setCodigo_detalle_compra(codigo_detalle);
		obj.setCodigo_compra(codigo_Compra);
		obj.setCodigo_producto(codigo);
		obj.setPrecio_compra(precio_Compra);
		obj.setCantidad(cantidad);
		obj.setDescuento(descuento);

		ServiDetalle.Actualizar_Detalle_Compra(obj);

		List<Detalle_CompraDTO> x = ServiDetalle.listar_Detalle_Compra(codigo_Compra);

		/* precarga el combo productos */
		request.setAttribute("producto", producto.Listarxnombreproducto());

		request.setAttribute("data", x);
		request.getRequestDispatcher("Detalle_Compra_List.jsp").forward(request, response);

	}

	private void registrarDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo_Compra = Integer.parseInt(request.getParameter("txt_codigoCompra"));
		request.setAttribute("producto", producto.Listarxnombreproducto());
		int codigo = Integer.parseInt(request.getParameter("cbn_producto"));
		double precio_Compra = Double.parseDouble(request.getParameter("txt_precio_Compra"));
		int cantidad = Integer.parseInt(request.getParameter("txt_cantidad"));
		int descuento = Integer.parseInt(request.getParameter("txt_descuento"));

		Detalle_CompraDTO obj = new Detalle_CompraDTO();

		obj.setCodigo_compra(codigo_Compra);
		obj.setCodigo_producto(codigo);
		obj.setPrecio_compra(precio_Compra);
		obj.setCantidad(cantidad);
		obj.setDescuento(descuento);

		ServiDetalle.Registrar_Detalle_Compra(obj);

		List<Detalle_CompraDTO> x = ServiDetalle.listar_Detalle_Compra(codigo_Compra);
		request.setAttribute("data", x);
		request.getRequestDispatcher("Detalle_Compra_List.jsp").forward(request, response);

	}

	private void buscarDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cod = request.getParameter("cod");
		int codigo = Integer.parseInt(cod);
		Detalle_CompraDTO x = ServiDetalle.buscarDetalle_Compra(codigo);
		request.setAttribute("registro", x);
		request.getRequestDispatcher("Detalle_Compra_Update.jsp").forward(request, response);
	}

	private void comboproducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("producto", producto.Listarxnombreproducto());
		request.getRequestDispatcher("Detalle_Compra_Add.jsp").forward(request, response);
	}

	private void comboempleado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("empleado", serviempleado.Listarxnombreempleado());
		request.getRequestDispatcher("Compra_Add.jsp").forward(request, response);
	}
	
	private void comboestado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("estado", ServiFactura.Listarxestado());
		request.getRequestDispatcher("Factura_Compra_Add.jsp").forward(request, response);		
	}

}
