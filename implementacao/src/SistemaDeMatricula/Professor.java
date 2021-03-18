package SistemaDeMatricula;

import Login.Usuario;

public class Professor extends Usuario {
	private static final long serialVersionUID = 1L;
	private String nome;

	public Professor(String nome, String login, String senha) {
		super(login, senha);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
