package beans;

public class ContactoDTO {
	private int codigo_contacto;
	private int codigo_tipo;
	private String codigo_ruc;
	private int dni;
	private String razon_social;
	private String direccion;
	private String telefono;
	
	/*tabla tipo contacto*/
	private String tipo_contacto;
	
	
	public int getCodigo_contacto() {
		return codigo_contacto;
	}
	public void setCodigo_contacto(int codigo_contacto) {
		this.codigo_contacto = codigo_contacto;
	}
	
	public int getCodigo_tipo() {
		return codigo_tipo;
	}
	public void setCodigo_tipo(int codigo_tipo) {
		this.codigo_tipo = codigo_tipo;
	}
	
	public String getCodigo_ruc() {
		return codigo_ruc;
	}
	public void setCodigo_ruc(String codigo_ruc) {
		this.codigo_ruc = codigo_ruc;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipo_contacto() {
		return tipo_contacto;
	}
	public void setTipo_contacto(String tipo_contacto) {
		this.tipo_contacto = tipo_contacto;
	}
	
	
	
	
}
