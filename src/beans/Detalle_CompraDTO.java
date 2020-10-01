package beans;

public class Detalle_CompraDTO {
	/*la clase incluye datos externos de la tabla producto*/
	
	/*datos de la tabla Compra*/
	private int codigo_detalle_compra;
	private int codigo_compra;
	private int codigo_producto;
	private double precio_compra;
	private int cantidad;
	
	/*datos auxiliares*/
	private int descuento;
	private int nombre_producto;
	
	
	public int getCodigo_detalle_compra() {
		return codigo_detalle_compra;
	}
	public void setCodigo_detalle_compra(int codigo_detalle_compra) {
		this.codigo_detalle_compra = codigo_detalle_compra;
	}
	public int getCodigo_compra() {
		return codigo_compra;
	}
	public void setCodigo_compra(int codigo_compra) {
		this.codigo_compra = codigo_compra;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
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
	public int getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(int nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	
	
	/*Metodos*/
	public double importeParcial() {
		return getCantidad()*getPrecio_compra();
	}
	
	public double descuento() {
		return importeParcial()*getDescuento()/100;
	}
	
	public double importeTotal() {
		return importeParcial()-descuento();
	}
	public double total(double acum) {
		acum=acum+importeTotal();
		return acum;
	}
}
