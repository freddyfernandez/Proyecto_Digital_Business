package beans;

import java.sql.Date;

public class VentaDTO {
	private int codigo_venta;
	private Date fecha;
	private int codigo_empleado;
	private int codigo_cliente;
	
	
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCodigo_empleado() {
		return codigo_empleado;
	}
	public void setCodigo_empleado(int codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}
	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	
	
	

}
