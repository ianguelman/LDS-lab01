package SistemaFinanceiro;

import Login.Usuario;

public class Secretaria extends Usuario implements SistemaCobranca {
	private static final long serialVersionUID = 1L;
	public Secretaria(String login, String senha) {
		super(login, senha);
	}
	
	public void notificarSistemaCobranca() {
		System.out.println("Notificação cobrança!");
	}
	public void cobrarAluno() {
		System.out.println("Notificar aluno!");
	}
}
