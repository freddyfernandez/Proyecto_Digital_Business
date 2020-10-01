package beans;

public class BancoDTO {
	private int codigo_banco;
	private String nombre_banco;
	private String siglas_banco;
	public int getCodigo_banco() {
		return codigo_banco;
	}
	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}
	public String getNombre_banco() {
		return nombre_banco;
	}
	public void setNombre_banco(String nombre_banco) {
		this.nombre_banco = nombre_banco;
	}
	public String getSiglas_banco() {
		return siglas_banco;
	}
	public void setSiglas_banco(String siglas_banco) {
		this.siglas_banco = siglas_banco;
	}
	
}
