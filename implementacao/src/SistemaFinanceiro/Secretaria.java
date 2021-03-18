package SistemaFinanceiro;

import java.util.Scanner;

import Login.Usuario;

import EntradaSaida.Arquivos;

import SistemaDeMatricula.Aluno;
import SistemaDeMatricula.Professor;

public class Secretaria extends Usuario implements SistemaCobranca {
	private static final long serialVersionUID = 1L;

	public Secretaria(String login, String senha) {
		super(login, senha);
	}

	public void notificarSistemaCobranca() {
		System.out.println("Notifica��o cobran�a!");
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
		System.out.print("Digite o login para o aluno: ");
		String login = sc.next();
		System.out.print("Digite a senha para o aluno: ");
		String senha = sc.next();
		Arquivos.writeUsuario(new Aluno(nome, matricula, login, senha));
	}

	public void criarProfessor() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do professor: ");
		String nome = sc.next();
		System.out.print("Digite o login para o professor: ");
		String login = sc.next();
		System.out.print("Digite a senha para o professor: ");
		String senha = sc.next();
		Arquivos.writeUsuario(new Professor(nome, login, senha));
	}

	public void criarDisciplinas() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome da Disciplina: ");
		String nome = sc.nextLine();
		System.out.print("A disciplina é obrigatória (s/n): ");
		String obg = sc.next();
		Arquivos.writeDisciplina(new Disciplina(nome, obg.equals("s")));
	}
}
