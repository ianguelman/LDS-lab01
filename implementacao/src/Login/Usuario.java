package Login;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public boolean logar(String login, String senha) {
		return login.equals(this.login) && senha.equals(this.senha);
	}

	@Override
	public String toString() {
		return "login=" + login + ", senha=" + senha;
	}
}
