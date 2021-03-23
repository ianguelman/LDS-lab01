package Ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import Academico.Disciplina;
import EntradaSaida.Arquivos;
import Login.Usuario;
import SistemaDeMatricula.Aluno;
import SistemaDeMatricula.Professor;
import SistemaFinanceiro.Secretaria;

public class App {
	private static Usuario currUser;
	private static Scanner entrada = new Scanner(System.in);

	public static void menuAluno() throws FileNotFoundException, ClassNotFoundException, IOException {
		int opc;
		do {
			System.out.println("Aluno");
			System.out.println("=====");
			System.out.println("1- Inscrever-se no semestre ");
			System.out.println("2- Cancelar matricula");
			System.out.println("3- Matricular");
			System.out.println("0- Sair");

			opc = opcao();

			switch (opc) {
			case 1:
				inscrever();
				break;
			case 2:
				cancelarMatricula();
				break;
			case 3:
				matricular();
				break;
			case 0:
				return;
			default:
				System.out.println("Digite uma op��o valida");
				break;
			}
		} while (opc != 0);

	}

	public static void inscrever() {
		Aluno aluno = (Aluno) currUser;
		if (aluno.isMatriculado()) {
			System.out.println("Matricula feita com sucesso nas seguintes disciplinas:");
			System.out.print("Obrigatorias: ");
			aluno.listarObrigatorias();
			System.out.print("Optativas: ");
			aluno.listarOptativas();
			System.out.println("Solicita��o de cobran�a enviada ao Sistema Financeiro");
		} else
			System.out.println("� necessario se matricular antes de realizar inscricao no semestre");
	}

	public static void cancelarMatricula() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aluno aluno = (Aluno) currUser;
		ArrayList<Disciplina> disciplinas = Arquivos.readDisciplinas();

		aluno.listarObrigatorias();
		aluno.listarOptativas();

		System.out.print("Digite o nome da disciplina para cancelar: ");
		entrada.nextLine();
		String dis = entrada.nextLine();
		for (Disciplina disciplina : disciplinas) {
			if (dis.equals(disciplina.getNome())) {
				if (disciplina.isObrigatoria())
					aluno.removeObrigatoria(disciplina);
				else
					aluno.removeOptativa(disciplina);
				disciplina.desmatricular(aluno);
				Arquivos.updateUsuario(aluno);
				Arquivos.updateDisciplina(disciplina);
				System.out.println("Desmatriculado com sucesso");
			}
		}
	}

	public static void matricular() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aluno aluno = (Aluno) currUser;
		ArrayList<Disciplina> disciplinas = Arquivos.readDisciplinas();

		System.out.println("Disciplinas obrigatorias disponiveis:");
		System.out.println(
				disciplinas.stream().filter(d -> d.isObrigatoria() && d.isOfertada()).collect(Collectors.toList()));

		entrada.nextLine();
		for (int i = 1; i <= 4; i++) {
			System.out.print("Digite o nome da " + i + " disciplina obrigatoria: ");
			String dis = entrada.nextLine();
			for (Disciplina disciplina : disciplinas) {
				if (dis.equals(disciplina.getNome())) {
					if (disciplina.temVaga()) {
						aluno.addObrigatoria(disciplina);
						disciplina.matricular(aluno);
						Arquivos.updateUsuario(aluno);
						Arquivos.updateDisciplina(disciplina);
						System.out.println("Matriculado com sucesso");
					} else
						System.out.println("N�o h� vagas para a disciplina");
				}
			}
		}

		System.out.println("Disciplinas optativas disponiveis:");
		System.out.println(
				disciplinas.stream().filter(d -> !d.isObrigatoria() && d.isOfertada()).collect(Collectors.toList()));
		for (int i = 1; i <= 2; i++) {
			System.out.print("Digite o nome da " + i + " disciplina optativa: ");
			String dis = entrada.nextLine();
			for (Disciplina disciplina : disciplinas) {
				if (dis.equals(disciplina.getNome())) {
					if (disciplina.temVaga()) {
						aluno.addOptativa(disciplina);
						disciplina.matricular(aluno);
						Arquivos.updateUsuario(aluno);
						Arquivos.updateDisciplina(disciplina);
						System.out.println("Matriculado com sucesso");
					} else
						System.out.println("N�o h� vagas para a disciplina");
				}
			}
		}

	}

	public static void menuProfessor() throws FileNotFoundException, ClassNotFoundException, IOException {
		int opc;
		do {
			System.out.println("\nProfessor");
			System.out.println("=========");
			System.out.println("1- Verificar alunos matriculados na disciplina");
			System.out.println("0- Sair");
			opc = opcao();
			switch (opc) {
			case 1:
				listarMatriculados();
				break;
			case 0:
				return;
			default:
				System.out.println("Digite uma opcao valida");
				break;
			}
		} while (opc != 0);
	}

	public static void listarMatriculados() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Disciplina> disciplinas = Arquivos.readDisciplinas();

		for (Disciplina d : disciplinas) {
			System.out.println(d.getNome() + ":");
			d.listarAlunos();
			System.out.println("\n");
		}
	}

	public static void menuSecretaria() throws FileNotFoundException, ClassNotFoundException, IOException {
		int opc;
		do {
			Secretaria secretaria = (Secretaria) currUser;
			System.out.println("\nSecretaria");
			System.out.println("==========");
			System.out.println("1- Criar Curso");
			System.out.println("2- Criar Aluno");
			System.out.println("3- Criar Professor");
			System.out.println("4- Criar Disciplina");
			System.out.println("5- Listar Disciplinas ativas");
			System.out.println("6- Listar Cursos");
			System.out.println("0- Sair");
			opc = opcao();

			switch (opc) {
			case 1:
				secretaria.criarCurso(entrada);
				break;
			case 2:
				secretaria.criarAluno(entrada);
				break;
			case 3:
				secretaria.criarProfessor(entrada);
				break;
			case 4:
				secretaria.criarDisciplina(entrada);
				break;
			case 5:
				listarAtivas();
				break;
			case 6:
				listarCursos();
				break;
			case 0:
				return;
			default:
				System.out.println("Digite uma op��o valida");
				break;
			}
		} while (opc != 0);
	}

	public static void listarAtivas() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Disciplina> disciplinas = Arquivos.readDisciplinas();
		System.out.println(disciplinas.stream().filter(d -> d.isAtiva()).collect(Collectors.toList()));
	}

	public static void listarCursos() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println(Arquivos.readCursos());
	}

	public static void menuLogar() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("\nSistema de Matriculas");
		System.out.println("\tLogin");
		System.out.println("=====================");
		System.out.print("Digite seu usuario: ");
		String login = entrada.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = entrada.nextLine();

		Usuario u = logar(login, senha);
		if (u != null) {
			if (u instanceof Professor)
				menuProfessor();
			if (u instanceof Aluno)
				menuAluno();
			if (u instanceof Secretaria)
				menuSecretaria();
		} else
			System.out.println("usuario nao localizado");
	}

	public static Usuario logar(String login, String senha)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Usuario> usuarios = Arquivos.readUsuarios();
		for (Usuario u : usuarios) {
			if (u.logar(login, senha)) {
				currUser = u;
				return u;
			}
		}
		return null;
	}

	public static int opcao() {
		System.out.print("\nDigite a opcao desejada: ");
		int opc = entrada.nextInt();

		return opc;
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		menuLogar();

		entrada.close();
	}

}
