package Ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Academico.Disciplina;
import EntradaSaida.Arquivos;
import Login.Usuario;
import SistemaDeMatricula.Aluno;
import SistemaDeMatricula.Professor;
import SistemaFinanceiro.Secretaria;

public class App {

	public static void menuAluno(Usuario u) {
		System.out.println("1- Inscrever-se no semestre ");
		System.out.println("2- Cancelar matricula");
		System.out.println("3- Matricular");
		System.out.println("0- Sair");
	}

	public void SubmenuMatricula() {
		System.out.println("1- Matricular em disciplina optativa ");
		System.out.println("2- Matricular em disciplina obrigatoria");
		System.out.println("0- Sair");
	}

	public void matricular(Aluno u) throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		System.out.println(disciplinas);
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome da disicplina : ");
		String dis = sc.nextLine();
		for (Disciplina disciplina : disciplinas) {
			if (dis.equals(disciplina.getNome()))
				if (disciplina.isObrigatoria())
					u.addObrigatoria(disciplina);
				else
					u.addOptativa(disciplina);
				return;
		}
		System.out.println("Disiplina n„o encontrada");
	}

	public static void menuProfessor(Usuario u) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("1- Verificar alunos matriculados na disciplina");
		System.out.println("0- Sair");
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a opcao: ");
		int opc = sc.nextInt();
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
	}

	public static void listarMatriculados() throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Disciplina> disciplinas = Arquivos.readDisciplinas();

		for (Disciplina d : disciplinas) {
			System.out.println(d.getNome() + ":");
			d.listarAlunos();
			System.out.println("\n");
		}
	}

	public static void menuSecretaria(Usuario u) {
		System.out.println("1- Gerar Curriculo");
		System.out.println("2- Atualizar Curriculo");
		System.out.println("3- Criar Aluno");
		System.out.println("4- Criar Professor");
		System.out.println("5- Criar Disciplina");
		System.out.println("0- Sair");
	}

	public static void menuLogar() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite seu login: ");
		String login = sc.next();
		sc.nextLine();
		System.out.print("Digite sua senha: ");
		String senha = sc.next();
		sc.nextLine();
		sc.close();
		Usuario u = logar(login, senha);
		if (u != null) {
			if (u instanceof Professor)
				menuProfessor(u);
			if (u instanceof Aluno)
				menuAluno(u);
			if (u instanceof Secretaria)
				menuSecretaria(u);
		} else
			System.out.println("usuario n√£o localizado");
	}

	public static Usuario logar(String login, String senha)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Usuario> usuarios = Arquivos.readUsuarios();
		for (Usuario u : usuarios) {
			if (u.logar(login, senha))
				return u;
		}
		return null;
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Usuarios.ser", true));
//		Arquivos.writeUsuario(new Secretaria("secretaria", "senha"), oos );
//		Arquivos.writeUsuario(new Aluno("nomeAluno", 123456, "aluno", "senha"),oos);
//		Arquivos.writeUsuario(new Professor("nomeProf", "professor", "senha"), oos);
//		menuLogar();
		System.out.println(Arquivos.readUsuarios());
	}

}
