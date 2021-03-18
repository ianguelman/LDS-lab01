package EntradaSaida;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Academico.Curso;
import Academico.Disciplina;
import Academico.Oferta;
import SistemaDeMatricula.Aluno;
import SistemaDeMatricula.Professor;
import SistemaFinanceiro.Secretaria;

public class Arquivos {

	public static ArrayList<Curso> readCursos() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Cursos.ser"));

		try {
			Curso curso = (Curso) entrada.readObject();
			while (curso != null) {
				cursos.add(curso);
				curso = (Curso) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return cursos;
	}

	public static void writeCurso(Curso curso, ObjectOutputStream saida) throws FileNotFoundException, IOException {

		saida.writeObject(curso);

	}

	public static ArrayList<Disciplina> readDisciplinas()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Disciplinas.ser"));

		try {
			Disciplina disciplina = (Disciplina) entrada.readObject();
			while (disciplina != null) {
				disciplinas.add(disciplina);
				disciplina = (Disciplina) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return disciplinas;
	}

	public static void writeDisciplina(Disciplina disciplina, ObjectOutputStream saida)
			throws FileNotFoundException, IOException {

		saida.writeObject(disciplina);

	}

	public static ArrayList<Oferta> readOfertas() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Ofertas.ser"));

		try {
			Oferta oferta = (Oferta) entrada.readObject();
			while (oferta != null) {
				ofertas.add(oferta);
				oferta = (Oferta) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return ofertas;
	}

	public static void writeOferta(Oferta oferta, ObjectOutputStream saida) throws FileNotFoundException, IOException {

		saida.writeObject(oferta);

	}

	public static ArrayList<Aluno> readAlunos() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Alunos.ser"));

		try {
			Aluno aluno = (Aluno) entrada.readObject();
			while (aluno != null) {
				alunos.add(aluno);
				aluno = (Aluno) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return alunos;
	}

	public static void writeAluno(Aluno aluno, ObjectOutputStream saida) throws FileNotFoundException, IOException {

		saida.writeObject(aluno);

	}

	public static ArrayList<Professor> readProfessors()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Professor> professores = new ArrayList<Professor>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Professors.ser"));

		try {
			Professor professor = (Professor) entrada.readObject();
			while (professor != null) {
				professores.add(professor);
				professor = (Professor) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return professores;
	}

	public static void writeProfessor(Professor professor, ObjectOutputStream saida)
			throws FileNotFoundException, IOException {

		saida.writeObject(professor);

	}

	public static ArrayList<Secretaria> readSecretarias()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Secretaria> secretarias = new ArrayList<Secretaria>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Secretarias.ser"));

		try {
			Secretaria secretaria = (Secretaria) entrada.readObject();
			while (secretaria != null) {
				secretarias.add(secretaria);
				secretaria = (Secretaria) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return secretarias;
	}

	public static void writeSecretaria(Secretaria secretaria, ObjectOutputStream saida)
			throws FileNotFoundException, IOException {

		saida.writeObject(secretaria);

	}
}
