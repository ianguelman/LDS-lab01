package Academico;

import java.util.ArrayList;

public class Oferta {
	private ArrayList<Disciplina> disciplinasOfertadas;

	public Oferta(ArrayList<Disciplina> disciplinasOfertadas) {
		this.disciplinasOfertadas = disciplinasOfertadas;
	}

	public ArrayList<Disciplina> getDisciplinasOfertadas() {
		return disciplinasOfertadas;
	}

}
