package Academico;

import java.io.Serializable;
import java.util.ArrayList;

import SistemaDeMatricula.Aluno;

public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private ArrayList<Aluno> inscritos;
	private boolean obrigatoria;
	private boolean ativa;
	private boolean ofertada;

	public Disciplina(String nome, boolean obrigatoria, boolean ofertada) {
		this.nome = nome;
		this.inscritos = new ArrayList<Aluno>();
		this.obrigatoria = obrigatoria;
		this.ativa = false;
		this.ofertada = ofertada;
	}

	public void matricular(Aluno aluno) {
		if (inscritos == null)
			inscritos = new ArrayList<Aluno>();
		inscritos.add(aluno);
	}

	public void desmatricular(Aluno aluno) {
		Aluno ar = null;
		for (Aluno a : inscritos) {
			if (a.getLogin().equals(aluno.getLogin()))
				ar = a;
		}
		inscritos.remove(ar);
	}

	public void listarAlunos() {
		System.out.println(inscritos.toString());
	}

	public void cancelarDisciplina() {
		this.ativa = false;
	}

	public String getNome() {
		return nome;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	public boolean isAtiva() {
		this.ativa = inscritos.size() >= 3;
		return ativa;
	}
	
	public void setOfertada(boolean bol) {
		this.ofertada = bol;
		
	}
	public boolean isOfertada() { 
		return ofertada;
	}

	public boolean temVaga() {
		return inscritos.size() <= 60;
	}

	@Override
	public String toString() {
		return "\nDisciplina [nome=" + nome + ", inscritos=" + inscritos + ", obrigatoria=" + obrigatoria + ", ativa="
				+ ativa + "]";
	}

}
