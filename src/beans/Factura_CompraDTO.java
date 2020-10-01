package beans;

import java.sql.Date;

public class Factura_CompraDTO {
	private int codigo_factura;
	private int codigo_compra;
	private int codigo_empleado;
	private int estado;
	private Date fecha;
	
	/*atributos externos tabla empleado*/
	private String nombre_empleado;
	
	
	/*atributos externos tabla estado*/
	
	private String nombre_estado;
	
    /*atributos externos tabla contacto*/
	
	private String nombre_contacto;
	
	/*dato calculado*/
	private double monto_total;
	
	public int getCodigo_factura() {
		return codigo_factura;
	}
	public void setCodigo_factura(int codigo_factura) {
		this.codigo_factura = codigo_factura;
	}
	public int getCodigo_compra() {
		return codigo_compra;
	}
	public void setCodigo_compra(int codigo_compra) {
		this.codigo_compra = codigo_compra;
	}
	public int getCodigo_empleado() {
		return codigo_empleado;
	}
	public void setCodigo_empleado(int codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombre_empleado() {
		return nombre_empleado;
	}
	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}
	public String getNombre_estado() {
		return nombre_estado;
	}
	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	public String getNombre_contacto() {
		return nombre_contacto;
	}
	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}
	public double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	
	
	
	
	
	
	
	
	
}
