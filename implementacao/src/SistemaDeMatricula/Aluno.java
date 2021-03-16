package SistemaDeMatricula;

import Login.Usuario;

import java.util.ArrayList;

import Academico.Disciplina;


public class Aluno extends Usuario {
	private String nome;
	private String matricula;
	private ArrayList<Disciplina> obrigatorias;
	private ArrayList<Disciplina> optativas;
}
