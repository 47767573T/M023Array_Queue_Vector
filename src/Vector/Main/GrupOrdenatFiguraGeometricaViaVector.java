package Vector.Main;

import java.awt.Color;
import java.util.Collections;
import java.util.Vector;

import Vector.figGeometricas.Cercle02;
import Vector.figGeometricas.FiguraGeometrica02;

/**
 * Created by Moises on 18/01/2016.
 */
public class GrupOrdenatFiguraGeometricaViaVector {


	//Creamos el vector
	private Vector<FiguraGeometrica02> v;

	//CONSTRUCTORES
	public GrupOrdenatFiguraGeometricaViaVector(int capacidad) {
		if (capacidad < 0)	throw new IllegalArgumentException("Dimension no permitida: " + capacidad);

		v = new Vector<FiguraGeometrica02>(capacidad);
	}

	public GrupOrdenatFiguraGeometricaViaVector() {	}



	//RESTO DE METODOS

	public Vector<FiguraGeometrica02> getVector() {return v;}

	public int capacitat() {
		return v.capacity();
	}

	public int nreElements() {
		return v.size();
	}

	/**
	 * Afegeix, si no hi ha cap objecte amb id�ntica clau, l'objecte obj al
	 * vector Retorna -1: S'ha afegit sense cap problema -2: S'ha passat una
	 * refer�ncia nul�la - No es pot afegir >=0: Ja existeix un objecte amb
	 * igual clau a la posici� retornada per la funci�
	 */
	public int afegir(FiguraGeometrica02 obj) {

		int i;
		if (obj == null)
			return -2;
		i = v.indexOf(obj);
		if (i >= 0)
			return i;
		v.add(obj);

		return -1;
	}

	/**
	 * Retorna l'objecte que esta a la posicio i Retorna null: Si la posicio no
	 * existeix o est� buida
	 */
	public FiguraGeometrica02 exemplarAt(int i) {
		if ((i < 0) || (i >= v.size()))return null;

		return v.get(i);
	}

	/**
	 * Cerca un objecte dins la taula amb codi id�ntic a l'indicat per a
	 * treure'l de la taula Retorna null: Si no el troba L'objecte extret en cas
	 * de trobar-lo
	 */
	public FiguraGeometrica02 extreure(int codi) {
		int i;

		for (i = 0; i < v.size() && v.get(i).getCodi() != codi; i++);

		if (i == v.size()) return null;

		return v.remove(i);
	}

	public void cercar(Integer codi) {

		if (codi >= 0 && codi < v.size()) {

			if (v.get(codi) != null) v.get(codi).visualitzar();
			else System.out.println("No existeix cap figura amb aquest codi!");

		} else System.out.println("Codigo no valido");
	}

	public void buidar() {
		v.clear();
	}

	public void visualitzar() {
		int i;
		System.out.println("Contingut del vector");
		System.out.println("********************");
		System.out.println("Capacitat....: " + v.capacity());
		System.out.println("Nre. Elements: " + v.size());

		for (i = 0; i < v.size(); i++)
			System.out.println("Element " + i + ": " + v.get(i) + " " + v.get(i).area());
	}


	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (obj instanceof GrupOrdenatFiguraGeometricaViaVector) {
			GrupOrdenatFiguraGeometricaViaVector aux = (GrupOrdenatFiguraGeometricaViaVector) obj;
			int i;

			if (v.size() != aux.v.size())
				return false;

			for (i = 0; i < v.size() && aux.v.indexOf(v.get(i)) >= 0; i++)
				;

			if (i == v.size())
				return true;
		}
		return false;
	}
}
