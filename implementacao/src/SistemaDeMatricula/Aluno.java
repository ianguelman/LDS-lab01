package SistemaDeMatricula;

import Login.Usuario;

import java.util.ArrayList;

import Academico.Disciplina;


public class Aluno extends Usuario {
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
		obrigatorias.add(disciplina);
	}
	
	public void removeObrigatoria(Disciplina disciplina) {
		obrigatorias.remove(disciplina);
	}
	
	public void listarObrigatorias() {
		System.out.println(obrigatorias.toString());
	}
	
	public void addOptativa(Disciplina disciplina) {
		optativas.add(disciplina);
	}
	
	public void removeOptativa(Disciplina disciplina) {
		optativas.remove(disciplina);
	}
	
	public void listarOptativas() {
		System.out.println(optativas.toString());
	}

	public String getNome() {
		return nome;
	}

	public long getMatricula() {
		return matricula;
	}

	
	
	
	
}
