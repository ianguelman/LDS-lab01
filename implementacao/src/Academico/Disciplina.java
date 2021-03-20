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

	public Disciplina(String nome, ArrayList<Aluno> inscritos, boolean obrigatoria, boolean ativa) {
		this.nome = nome;
		this.inscritos = inscritos;
		this.obrigatoria = obrigatoria;
		this.ativa = inscritos.size() >= 3;
	}

	public Disciplina(String nome, boolean obrigatoria) {
		this.nome = nome;
		this.inscritos = new ArrayList<Aluno>();
		this.obrigatoria = obrigatoria;
		this.ativa = false;
	}

	public void matriucular(Aluno aluno) {
		inscritos.add(aluno);
	}

	public void desmatriucular(Aluno aluno) {
		inscritos.remove(aluno);
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
		return ativa;
	}

	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", inscritos=" + inscritos + ", obrigatoria=" + obrigatoria + ", ativa="
				+ ativa + "]";
	}

}
