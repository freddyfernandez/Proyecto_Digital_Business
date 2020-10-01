package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductoDTO;
import service.MarcaService;
import service.ProductoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductoService serviproducto= new ProductoService();
	MarcaService servimarca=new MarcaService();
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String xtipo=request.getParameter("tipo");
	    	
	    	if (xtipo.equals("listar"))
	    		listar(request,response);
	    	else if (xtipo.equals("buscar"))
	    		buscar(request,response);
	    	else if (xtipo.equals("registrar"))
	    		registrar(request,response);
	    	else if (xtipo.equals("actualizar"))
	    		actualizar(request,response);
	    	else if (xtipo.equals("eliminar"))
	    		eliminar(request,response);
	    	else if (xtipo.equals("combomarca"))
	    		combomarca(request,response);
	    	

			else if(xtipo.equals("busca")){
				busca(request, response);
			}else if(xtipo.equals("seleccione")){
				seleccione(request, response);
			}
	    	
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod=Integer.parseInt(request.getParameter("cod"));
		serviproducto.Eliminar_Producto(cod);
		listar(request,response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo=Integer.parseInt(request.getParameter("txt_cod"));
		String nom=request.getParameter("txt_nom");
        int marca = Integer.parseInt(request.getParameter("txt_marca"));
        double pre = Double.parseDouble(request.getParameter("txt_pre"));
        int stock = Integer.parseInt(request.getParameter("txt_stock"));
        String des=request.getParameter("txt_des");
        
        ProductoDTO obj=new ProductoDTO();        
		obj.setCodigo(codigo);
		obj.setNombre(nom);
		obj.setMarca(marca);
		obj.setPrecio(pre);
		obj.setStock(stock);
		obj.setCaracteristicas(des);
		
		serviproducto.Actualizar_Producto(obj);
		
		listar(request,response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String nom=request.getParameter("txt_nombre");
        request.setAttribute("marca",servimarca.Listarxnombremarca());
        
        int marca = Integer.parseInt(request.getParameter("cbn_marca"));
        double pre = Double.parseDouble(request.getParameter("txt_pre"));
        int stock = Integer.parseInt(request.getParameter("txt_stock"));
        String des=request.getParameter("txt_des");
    	
    	ProductoDTO obj=new ProductoDTO();
    	obj.setNombre(nom);
    	obj.setMarca(marca);
    	obj.setPrecio(pre);
    	obj.setStock(stock);
    	obj.setCaracteristicas(des);    	
    	
    	serviproducto.registraProducto(obj);   	
    	
    	request.setAttribute("data",serviproducto.listaProducto());
    	request.getRequestDispatcher("Producto_Add.jsp").forward(request,response);		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod=request.getParameter("cod");
		int codigo=Integer.parseInt(cod);
		ProductoDTO x=serviproducto.buscarProducto(codigo);
		request.setAttribute("registro",x);
		request.getRequestDispatcher("Producto_Update.jsp").forward(request,response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("data",serviproducto.listaProducto());
		request.getRequestDispatcher("Producto_List.jsp").forward(request,response);
	}
    private void combomarca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("marca",servimarca.Listarxnombremarca());
	
		request.getRequestDispatcher("Producto_Add.jsp").forward(request,response);
	}
    
    
    protected void busca(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String filtro = request.getParameter("filtro");
		
		
		
		if(filtro == null) filtro ="";
		
		List<ProductoDTO> data = serviproducto.consultaXNombre(filtro);
		
		request.setAttribute("productos", data);
		request.getRequestDispatcher("/boleta.jsp").forward(request, response);
    }
    protected void seleccione(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String pre = request.getParameter("pre");
		
		String cliente = id +":" + nom+ ":" + pre;
		
		HttpSession session = request.getSession();
		session.setAttribute("datoProducto", cliente);
		
		request.getRequestDispatcher("boleta.jsp").forward(request, response);	
    }

	

}
