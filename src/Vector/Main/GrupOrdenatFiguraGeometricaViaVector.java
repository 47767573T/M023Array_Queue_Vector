package Vector.Main;

import java.util.Vector;
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


	public FiguraGeometrica02 exemplarAt(int i) {
		if ((i < 0) || (i >= v.size()))return null;

		return v.get(i);
	}


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
