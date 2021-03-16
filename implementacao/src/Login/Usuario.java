package Login;

public class Usuario {
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public boolean logar(String login, String senha) {
		return login.equals(this.login) && senha.equals(this.senha);
	}
}
