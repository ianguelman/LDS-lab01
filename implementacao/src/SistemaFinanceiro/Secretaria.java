package SistemaFinanceiro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import Academico.Curso;
import Academico.Disciplina;
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

	public void criarAluno(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		sc.nextLine();
		System.out.print("Digite o nome do aluno: ");
		String nome = sc.nextLine();
		System.out.print("Digite a matricula do aluno: ");
		Long matricula = sc.nextLong();
		sc.nextLine();
		System.out.print("Digite o login para o aluno: ");
		String login = sc.nextLine();
		System.out.print("Digite a senha para o aluno: ");
		String senha = sc.nextLine();
		Arquivos.writeUsuario((Usuario) new Aluno(nome, matricula, login, senha));
	}

	public void criarProfessor(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		sc.nextLine();
		System.out.print("Digite o nome do professor: ");
		String nome = sc.nextLine();
		System.out.print("Digite o login para o professor: ");
		String login = sc.nextLine();
		System.out.print("Digite a senha para o professor: ");
		String senha = sc.nextLine();
		Arquivos.writeUsuario(new Professor(nome, login, senha));
	}

	public void criarDisciplina(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		sc.nextLine();
		System.out.print("Digite o nome da Disciplina: ");
		String nome = sc.nextLine();
		System.out.print("A disciplina e obrigatoria (s/n): ");
		String obg = sc.nextLine();
		System.out.print("A disciplina sera ofertada (s/n): ");
		String of = sc.nextLine();
		Arquivos.writeDisciplina(new Disciplina(nome, obg.equals("s"), of.equals("s")));
	}

	public void criarCurso(Scanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		sc.nextLine();
		System.out.print("Digite o nome do Curso: ");
		String nome = sc.nextLine();
		System.out.print("Digite o numero de creditos: ");
		int cred = sc.nextInt();

		ArrayList<Disciplina> disciplinas;
		String dis;
		System.out.println("Disciplinas:");
		disciplinas = Arquivos.readDisciplinas();
		
		sc.nextLine();
		System.out.println(disciplinas);
		ArrayList<Disciplina> d = new ArrayList<Disciplina>();
		do {
			System.out.print("Digite o nome da disciplina a ser adicionada (para sair escreva \"sair\"): ");
			dis = sc.nextLine();
			
			for (Disciplina disciplina : disciplinas) {
				if (dis.equals(disciplina.getNome())) {
					d.add(disciplina);
				}
			}
		} while (!dis.equals("sair"));
		
		Arquivos.writeCurso(new Curso(nome, cred, d));
		System.out.println("Curso criado com sucesso");
	}

	@Override
	public String toString() {
		return "Secretaria [" + super.toString() + "]";
	}
}
