package beans;

import java.sql.Date;

public class AlmacenDTO {
	
	private int codigo_entrada;
	
	private int codigo_producto;
	private int cantidad_entrada;
	private Date fecha_entrada;
	private int codigo_salida;
	private int cantidad_salida;
	private Date fecha_salida;
	
	private String nombre_producto;

	public int getCodigo_entrada() {
		return codigo_entrada;
	}

	public void setCodigo_entrada(int codigo_entrada) {
		this.codigo_entrada = codigo_entrada;
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getCantidad_entrada() {
		return cantidad_entrada;
	}

	public void setCantidad_entrada(int cantidad_entrada) {
		this.cantidad_entrada = cantidad_entrada;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public int getCodigo_salida() {
		return codigo_salida;
	}

	public void setCodigo_salida(int codigo_salida) {
		this.codigo_salida = codigo_salida;
	}

	public int getCantidad_salida() {
		return cantidad_salida;
	}

	public void setCantidad_salida(int cantidad_salida) {
		this.cantidad_salida = cantidad_salida;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	
	

}
