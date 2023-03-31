package br.com.gama.modelo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
	private String nome;
	private Setor setor;
	private short matricula;
	private String email;
	
	List<RamalDTO> ramais=new ArrayList<RamalDTO>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public short getMatricula() {
		return matricula;
	}

	public void setMatricula(short matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RamalDTO> getRamais() {
		return ramais;
	}

	public void setRamais(List<RamalDTO> ramais) {
		this.ramais = ramais;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", setor=" + setor + ", matricula=" + matricula + ", email=" + email
				+ ", ramais=" + ramais + "]";
	}
	
	

}
