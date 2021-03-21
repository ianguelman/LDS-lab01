package Academico;

import java.io.Serializable;
import java.util.ArrayList;

public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Disciplina> disciplinasOfertadas;
	private String nome;

	public Oferta(String nome, ArrayList<Disciplina> disciplinasOfertadas) {
		this.nome = nome;
		this.disciplinasOfertadas = disciplinasOfertadas;
	}

	public ArrayList<Disciplina> getDisciplinasOfertadas() {
		return disciplinasOfertadas;
	}
	
	public String getNome() {
		return this.nome;
	}

}
