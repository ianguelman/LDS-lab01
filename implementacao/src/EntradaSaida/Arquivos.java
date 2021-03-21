package EntradaSaida;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;

import Academico.Curso;
import Academico.Disciplina;
import Academico.Oferta;
import Login.Usuario;

public class Arquivos {

	private final static String arqUsuarios = "Usuarios.ser";
	private final static String arqOfertas = "Ofertas.ser";
	private final static String arqDisciplinas = "Disciplinas.ser";
	private final static String arqCursos = "Cursos.ser";

	@SuppressWarnings("unchecked")
	public static ArrayList<Curso> readCursos() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arqCursos));

		try {
			cursos = (ArrayList<Curso>) entrada.readObject();
		} catch (EOFException e) {

		}
		entrada.close();
		return cursos;
	}

	public static void writeCurso(Curso curso) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		try {
			cursos = readCursos();
		} catch (FileNotFoundException e) {

		}
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqCursos));
		cursos.add(curso);
		saida.writeObject(cursos);
		saida.close();

	}

	public static void updateCurso(Curso curso)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Curso> cursos = readCursos();
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqCursos));
		cursos = (ArrayList<Curso>) cursos.stream().filter(c -> !c.getNome().equals(curso.getNome()))
				.collect(Collectors.toList());
		cursos.add(curso);
		saida.writeObject(cursos);
		saida.close();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Disciplina> readDisciplinas() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arqDisciplinas));

		try {
			disciplinas = (ArrayList<Disciplina>) entrada.readObject();
		} catch (EOFException e) {

		}
		entrada.close();
		return disciplinas;
	}

	public static void writeDisciplina(Disciplina disciplina) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try {
			disciplinas = readDisciplinas();
		} catch (FileNotFoundException e) {

		}
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqDisciplinas));
		disciplinas.add(disciplina);
		saida.writeObject(disciplinas);
		saida.close();

	}

	public static void updateDisciplina(Disciplina disciplina)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Disciplina> disciplinas = readDisciplinas();
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqDisciplinas));
		disciplinas = (ArrayList<Disciplina>) disciplinas.stream().filter(d -> !d.getNome().equals(disciplina.getNome()))
				.collect(Collectors.toList());
		disciplinas.add(disciplina);
		saida.writeObject(disciplinas);
		saida.close();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Oferta> readOfertas() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arqOfertas));

		try {
			ofertas = (ArrayList<Oferta>) entrada.readObject();
		} catch (EOFException e) {

		}
		entrada.close();
		return ofertas;
	}

	public static void writeOferta(Oferta oferta) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			ofertas = readOfertas();
		} catch (FileNotFoundException e) {

		}
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqOfertas));
		ofertas.add(oferta);
		saida.writeObject(ofertas);
		saida.close();

	}

	public static void updateOferta(Oferta oferta)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Oferta> ofertas = readOfertas();
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqOfertas));
		ofertas = (ArrayList<Oferta>) ofertas.stream().filter(o -> !o.getNome().equals(oferta.getNome()))
				.collect(Collectors.toList());
		ofertas.add(oferta);
		saida.writeObject(ofertas);
		saida.close();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Usuario> readUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arqUsuarios));

		try {
			usuarios = (ArrayList<Usuario>) entrada.readObject();
		} catch (EOFException e) {

		}
		entrada.close();
		return usuarios;
	}

	public static void writeUsuario(Usuario usuario) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = readUsuarios();
		} catch (FileNotFoundException e) {

		}
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqUsuarios));
		usuarios.add(usuario);
		saida.writeObject(usuarios);
		saida.close();

	}

	public static void updateUsuario(Usuario usuario)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Usuario> usuarios = readUsuarios();
		ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arqUsuarios));
		usuarios = (ArrayList<Usuario>) usuarios.stream().filter(u -> !u.getLogin().equals(usuario.getLogin()))
				.collect(Collectors.toList());
		usuarios.add(usuario);
		saida.writeObject(usuarios);
		saida.close();

	}
}
