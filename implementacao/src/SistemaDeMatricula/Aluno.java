package SistemaDeMatricula;

import Login.Usuario;

import java.util.ArrayList;

import Academico.Disciplina;

public class Aluno extends Usuario {
	private static final long serialVersionUID = 1L;
	private String nome;
	private long matricula;
	private ArrayList<Disciplina> obrigatorias;
	private ArrayList<Disciplina> optativas;

	public Aluno(String nome, long matricula, String login, String senha) {
		super(login, senha);
		this.nome = nome;
		this.matricula = matricula;
	}

	public void addObrigatoria(Disciplina disciplina) {
		if (obrigatorias == null)
			obrigatorias = new ArrayList<Disciplina>();
		obrigatorias.add(disciplina);
	}

	public void removeObrigatoria(Disciplina disciplina) {
		obrigatorias.remove(disciplina);
	}

	public void listarObrigatorias() {
		if (obrigatorias == null)
			obrigatorias = new ArrayList<Disciplina>();
		System.out.println(obrigatorias.toString());
	}

	public void addOptativa(Disciplina disciplina) {
		if (optativas == null)
			optativas = new ArrayList<Disciplina>();
		optativas.add(disciplina);
	}

	public void removeOptativa(Disciplina disciplina) {
		optativas.remove(disciplina);
	}

	public void listarOptativas() {
		if (optativas == null)
			optativas = new ArrayList<Disciplina>();
		System.out.println(optativas.toString());
	}

	public String getNome() {
		return nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public boolean isMatriculado() {
		return obrigatorias.size() > 0 && optativas.size() > 0;
	}

	@Override
	public String toString() {
		return "Aluno [" + "nome=" + nome + ", matricula=" + matricula + "]";
	}

}
