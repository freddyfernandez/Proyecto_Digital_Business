package beans;

import java.sql.Date;

public class CompraDTO {
	private int codigo_compra;
	private Date fecha;
	private int codigo_empleado;
	private int codigo_cliente;
	
	
	public int getCodigo_compra() {
		return codigo_compra;
	}
	public void setCodigo_compra(int codigo_compra) {
		this.codigo_compra = codigo_compra;
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
