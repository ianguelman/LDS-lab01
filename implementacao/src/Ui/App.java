package Ui;

import java.util.Scanner;

public class App {
	
	public void menuAluno() {
		System.out.println("1- Inscrever-se no semestre ");
		System.out.println("2- Cancelar matricula");
		System.out.println("3- Matricular");			
	}
	
	public void SubmenuMatricula() {
		System.out.println("1- Matricular em disciplina optativa ");
		System.out.println("2- Matricular em disciplina obrigatoria");
	}
	
	public void menuProfessor() {
		System.out.println("1- Verificar alunos matriculados na disciplina");
	}
	
	public void menuSecretaria() {
		System.out.println("1- Gerar Curriculo");
		System.out.println("2- Atualizar Curriculo");
	}

	public void menuLogar(Usuario usuario) {
		if(usuario == null) {
			System.out.println("Usuario não encontrado!");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite seu login: ");
		String login = sc.next();
		sc.Next();
		System.out.println("Digite sua senha: ");
		String senha = sc.next();
		sc.Next()
	}
	
	public static void main(String[] args) {
		
		int usuario = 0;
		
		switch(usuario) {
		case 1:
			menuAluno();
		break;
		case 2:
			menuProfessor();
		break;
		case 3:
			menuSecretaria();
		break;
		}

	}

}
