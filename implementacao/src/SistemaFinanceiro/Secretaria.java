package SistemaFinanceiro;

import java.util.Scanner;

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
	
	public void criarAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do aluno: ");
		String nome = sc.next();
		System.out.print("Digite a matricula do aluno: ");
		Long matricula = sc.nextLong();
		new Aluno(nome, matricula);
	}
	
	public void criarProfessor() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do professor: ");
		String nome = sc.next();
		new Professor(nome);
	}
}
