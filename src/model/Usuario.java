package model;

public class Usuario {
	private String email, nome, senha, perfil;

	public Usuario() {

	}

	public Usuario(String email) {
		this.email = email;
	}

	public Usuario(String nome, String senha, String perfil) {
		this.nome = nome;
		this.senha = senha;
		this.perfil = senha;
	}

	public Usuario(String email, String nome, String senha, String perfil) {
		super();
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return email;
	}
	
	

}
