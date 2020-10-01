package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BancoDTO;

import service.BancoService;

/**
 * Servlet implementation class ServletContacto
 */
@WebServlet("/ServletBanco")
public class ServletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BancoService servibanco = new BancoService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletBanco() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String xtipo = req.getParameter("tipo");

		if (xtipo.equals("listarBanco"))
			listar(req, resp);
		else if (xtipo.equals("buscarBanco"))
			buscarBanco(req, resp);
		else if (xtipo.equals("registrarBanco"))
			registrarBanco(req, resp);
		else if (xtipo.equals("actualizarBanco"))
			actualizarBanco(req, resp);
		else if (xtipo.equals("eliminarBanco"))
			eliminarBanco(req, resp);

	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("data", servibanco.listaBanco());
		req.getRequestDispatcher("Banco_List.jsp").forward(req, resp);
	}

	private void buscarBanco(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo_banco = req.getParameter("codigo_banco");
		int codigo = Integer.parseInt(codigo_banco);
		BancoDTO x = servibanco.buscarBanco(codigo);
		req.setAttribute("registro", x);
		req.getRequestDispatcher("Banco_Update.jsp").forward(req, resp);

	}

	private void registrarBanco(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre_banco = req.getParameter("txt_nombre_banco");
		String siglas_banco = req.getParameter("txt_siglas_banco");

		BancoDTO obj = new BancoDTO();
		obj.setNombre_banco(nombre_banco);
		obj.setSiglas_banco(siglas_banco);		


		servibanco.registraBanco(obj);

		req.setAttribute("data", servibanco.listaBanco());
		req.getRequestDispatcher("Banco_List.jsp").forward(req, resp);

	}

	private void actualizarBanco(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		BancoDTO obj = new BancoDTO();
		int codigo_banco = Integer.parseInt(req.getParameter("txt_codigoBanco"));

		String nombre_banco = req.getParameter("txt_nombre_banco");
		String siglas_banco = req.getParameter("txt_siglas_banco");

		obj.setCodigo_banco(codigo_banco);
		obj.setNombre_banco(nombre_banco);
		obj.setSiglas_banco(siglas_banco);
		
		servibanco.Actualizar_Banco(obj);
		listar(req, resp);

	}

	private void eliminarBanco(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo_banco = Integer.parseInt(req.getParameter("codigo_banco"));
		servibanco.Eliminar_Banco(codigo_banco);
		listar(req, resp);
	}

}
