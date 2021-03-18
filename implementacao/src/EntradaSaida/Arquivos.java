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
import Login.Usuario;

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

	public static ArrayList<Usuario> readUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Usuarios.ser"));

		try {
			Usuario usuario = (Usuario) entrada.readObject();
			while (usuario != null) {
				usuarios.add(usuario);
				usuario = (Usuario) entrada.readObject();
			}
		} catch (EOFException e) {

		}

		entrada.close();
		return usuarios;
	}

	public static void writeUsuario(Usuario usuario, ObjectOutputStream saida) throws FileNotFoundException, IOException {

		saida.writeObject(usuario);

	}
}
