package dao;

import interfaces.AlmacenDAO;
import interfaces.BancoDAO;
import interfaces.CompraDAO;
import interfaces.ContactoDAO;
import interfaces.Contacto_AdicionalDAO;
import interfaces.Detalle_CompraDAO;
import interfaces.Detalle_VentaDAO;
import interfaces.ProductoDAO;
import interfaces.VentaDAO;
import interfaces.EmpleadoDAO;
import interfaces.Factura_CompraDAO;
import interfaces.Factura_VentaDAO;
import interfaces.MarcaDAO;
import interfaces.PagoDAO;


public class MySqlDAOFactory extends DAOFactory {



	@Override
	public MarcaDAO getMarca() {
		// TODO Auto-generated method stub
		return new MySqlMarcaDAO();
	}

	@Override
	public EmpleadoDAO getEmpleado() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

	@Override
	public ContactoDAO getContacto() {
		// TODO Auto-generated method stub
		return new MySqlContactoDAO();
	}

	@Override
	public ProductoDAO getProducto() {
		// TODO Auto-generated method stub
		return new MySqlProductoDAO();
	}

	@Override
	public BancoDAO getBanco() {
		// TODO Auto-generated method stub
		return new MySqlBancoDAO();
	}

	@Override
	public PagoDAO getPago() {
		// TODO Auto-generated method stub
		return  new MySqlPagoDAO();
	}

	@Override
	public VentaDAO getVenta() {
		// TODO Auto-generated method stub
		return new MySqlVentaDAO();
	}

	@Override
	public Detalle_VentaDAO getDetalleVenta() {
		// TODO Auto-generated method stub
		return new MySqlDetalleVentaDAO();
	}

	@Override
	public Factura_VentaDAO getFactura_Venta() {
		// TODO Auto-generated method stub
		return new MySqlFacturaVentaDAO();
	}
	
	@Override
	public CompraDAO getCompra() {
		// TODO Auto-generated method stub
		return new MySqlCompraDAO();
	}

	@Override
	public Detalle_CompraDAO getDetalleCompra() {
		// TODO Auto-generated method stub
		return new MySqlDetalleCompraDAO();
	}

	@Override
	public Factura_CompraDAO getFacturaCompra() {
		// TODO Auto-generated method stub
		return new MySqlFacturaCompraDAO();
	}

	@Override
	public Contacto_AdicionalDAO getContactoAdicional() {
		// TODO Auto-generated method stub
		return  new MySqlContactoAdicionalDAO();
	}

	@Override
	public AlmacenDAO getAlmacen() {
		// TODO Auto-generated method stub
		return new MySqlAlmacenDAO();
	}
	



}
