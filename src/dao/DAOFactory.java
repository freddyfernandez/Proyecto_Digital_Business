package dao;

import interfaces.MarcaDAO;

import interfaces.PagoDAO;
import interfaces.ProductoDAO;
import interfaces.VentaDAO;
import interfaces.EmpleadoDAO;
import interfaces.Factura_CompraDAO;
import interfaces.Factura_VentaDAO;
import interfaces.AlmacenDAO;
import interfaces.BancoDAO;
import interfaces.CompraDAO;
import interfaces.ContactoDAO;
import interfaces.Detalle_CompraDAO;
import interfaces.Detalle_VentaDAO;

import interfaces.Contacto_AdicionalDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;

	public abstract MarcaDAO getMarca();

	public abstract EmpleadoDAO getEmpleado();

	public abstract ContactoDAO getContacto();

	public abstract ProductoDAO getProducto();

	public abstract BancoDAO getBanco();

	public abstract PagoDAO getPago();
	
	public abstract VentaDAO getVenta();
	
	public abstract Detalle_VentaDAO getDetalleVenta();
	
	public abstract Factura_VentaDAO getFactura_Venta();
	

	public abstract CompraDAO getCompra();

	public abstract Detalle_CompraDAO getDetalleCompra();
	
	public abstract Factura_CompraDAO getFacturaCompra();	
	
	public abstract Contacto_AdicionalDAO getContactoAdicional();
	
	public abstract AlmacenDAO getAlmacen(); 

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case XML:
		case ORACLE:

		}
		return null;
	}

}
