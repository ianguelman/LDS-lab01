package Academico;

import java.util.ArrayList;

public class Curso {
	private String nome;
	private int creditos;
	private ArrayList<Disciplina> disciplinas;
	
	public Curso(String nome, int creditos, ArrayList<Disciplina> disciplinas) {
		this.nome = nome;
		this.creditos = creditos;
		this.disciplinas = disciplinas;
	}

	public Curso(String nome, int creditos) {
		this.nome = nome;
		this.creditos = creditos;
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}
}
