package br.com.gama.modelo;

public class RamalDTO {
	private long id;
	private int numero;
	private short central;
	private UsuarioDTO usuarioDTO;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public short getCentral() {
		return central;
	}
	public void setCentral(short central) {
		this.central = central;
	}
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	@Override
	public String toString() {
		return "RamalDTO [id=" + id + ", numero=" + numero + ", central=" + central + ", usuarioDTO=" + usuarioDTO
				+ "]";
	}
	
	
}
