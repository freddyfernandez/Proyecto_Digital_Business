package beans;

public class Detalle_VentaDTO {
	
	/*la clase incluye datos externos a la tabla referenciada de la base de datos*/
	
	/*datos de la tabla Venta*/
	private int codigo_detalle;
	private int codigo_venta;
	private int codigo_producto;
	private double precio_venta;
	private int cantidad;
	private double monto_total;
	
	/*datos auxiliares*/
	private int descuento;
	private String nombre_producto;
	
	
	public int getCodigo_detalle() {
		return codigo_detalle;
	}
	public void setCodigo_detalle(int codigo_detalle) {
		this.codigo_detalle = codigo_detalle;
	}
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
	
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String string) {
		this.nombre_producto = string;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	
	/*Metodos*/
	
	
	public double importeParcial() {
		return getCantidad()*getPrecio_venta();
	}
	
	public double descuento() {
		return importeParcial()*getDescuento()/100;
	}
	
	public double importeTotal() {
		return importeParcial()-descuento();
	}
	
	
	
	
	
	
	

}
