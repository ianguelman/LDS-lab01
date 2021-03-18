package Ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
	}

	public void SubmenuMatricula() {
		System.out.println("1- Matricular em disciplina optativa ");
		System.out.println("2- Matricular em disciplina obrigatoria");
	}

	public static void menuProfessor(Usuario u) {
		System.out.println("1- Verificar alunos matriculados na disciplina");
	}

	public static void menuSecretaria(Usuario u) {
		System.out.println("1- Gerar Curriculo");
		System.out.println("2- Atualizar Curriculo");
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
			System.out.println("usuario não localizado");
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
		menuLogar();
	}

}
