package beans;

public class Contacto_AdicionalDTO {
	private int codigo_adicional;
	private int codigo_contacto;
	private int codigo_forma_pago;
	private int codigo_banco;
	private String nro_cuenta;
	private String correo;
	
	private String forma_pago;
	private String nombre_banco;
	private String razon_social;
	
	public int getCodigo_adicional() {
		return codigo_adicional;
	}
	public void setCodigo_adicional(int codigo_adicional) {
		this.codigo_adicional = codigo_adicional;
	}
	public int getCodigo_contacto() {
		return codigo_contacto;
	}
	public void setCodigo_contacto(int codigo_contacto) {
		this.codigo_contacto = codigo_contacto;
	}
	public int getCodigo_forma_pago() {
		return codigo_forma_pago;
	}
	public void setCodigo_forma_pago(int codigo_forma_pago) {
		this.codigo_forma_pago = codigo_forma_pago;
	}
	public int getCodigo_banco() {
		return codigo_banco;
	}
	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}
	public String getNro_cuenta() {
		return nro_cuenta;
	}
	public void setNro_cuenta(String nro_cuenta) {
		this.nro_cuenta = nro_cuenta;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	public String getNombre_banco() {
		return nombre_banco;
	}
	public void setNombre_banco(String nombre_banco) {
		this.nombre_banco = nombre_banco;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
	
	

}
