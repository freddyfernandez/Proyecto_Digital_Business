package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PagoDTO;
import service.PagoService;

/**
 * Servlet implementation class ServletContacto
 */
@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PagoService servipago = new PagoService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPago() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String xtipo = req.getParameter("tipo");

		if (xtipo.equals("listarPago"))
			listar(req, resp);
		else if (xtipo.equals("buscarPago"))
			buscarPago(req, resp);
		else if (xtipo.equals("registrarPago"))
			registrarPago(req, resp);
		else if (xtipo.equals("actualizarPago"))
			actualizarPago(req, resp);
		else if (xtipo.equals("eliminarPago"))
			eliminarPago(req, resp);

	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("data", servipago.listaPago());
		req.getRequestDispatcher("Pago_List.jsp").forward(req, resp);
	}

	private void buscarPago(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo_pago = req.getParameter("codigo_pago");
		int codigo = Integer.parseInt(codigo_pago);
		PagoDTO x = servipago.buscarPago(codigo);
		req.setAttribute("registro", x);
		req.getRequestDispatcher("Pago_Update.jsp").forward(req, resp);

	}

	private void registrarPago(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forma_pago = req.getParameter("txt_forma_pago");

		PagoDTO obj = new PagoDTO();
		obj.setForma_pago(forma_pago);

		servipago.registrarPago(obj);

		listar(req, resp);

	}

	private void actualizarPago(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PagoDTO obj = new PagoDTO();
		int codigo_pago = Integer.parseInt(req.getParameter("txt_codigoPago"));

		String forma_pago = req.getParameter("txt_forma_pago");

		obj.setCodigo_pago(codigo_pago);
		obj.setForma_pago(forma_pago);

		servipago.Actualizar_Pago(obj);
		listar(req, resp);

	}

	private void eliminarPago(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo_pago = Integer.parseInt(req.getParameter("codigo_pago"));
		servipago.Eliminar_Pago(codigo_pago);
		listar(req, resp);
	}

}
