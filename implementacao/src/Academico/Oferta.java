package Academico;

import java.io.Serializable;
import java.util.ArrayList;

public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Disciplina> disciplinasOfertadas;

	public Oferta(ArrayList<Disciplina> disciplinasOfertadas) {
		this.disciplinasOfertadas = disciplinasOfertadas;
	}

	public ArrayList<Disciplina> getDisciplinasOfertadas() {
		return disciplinasOfertadas;
	}

}
