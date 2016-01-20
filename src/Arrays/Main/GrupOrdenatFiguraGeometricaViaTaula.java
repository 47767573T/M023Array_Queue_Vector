package Arrays.Main;

import Arrays.figGeometricas.FiguraGeometrica02;

import java.util.Arrays;

/**
 * Created by Moises on 20/01/2016.
 */
public class GrupOrdenatFiguraGeometricaViaTaula {

    public FiguraGeometrica02[] fig;
    public int cantidad = 0;


    public GrupOrdenatFiguraGeometricaViaTaula (int capacidad){
        if (capacidad <= 0) throw new NegativeArraySizeException("ERROR: "+ capacidad);
        fig = new FiguraGeometrica02[capacidad];

    }

    public GrupOrdenatFiguraGeometricaViaTaula() {this(10);}

    public int capacidad() { return fig.length; }

    public int numElementos()  { return cantidad; }


    public int afegir (FiguraGeometrica02 obj) {

        int pos,i;

        if (obj==null) return -2;
        pos= Arrays.binarySearch(fig, 0, cantidad, obj);

        if (pos>=0) return pos;

        if (cantidad == fig.length) return -3;
        pos = -pos-1;  // Posici� on pertoca estar l'element a inserir

        for (i=cantidad; i>pos; i--) fig[i] = fig[i-1];  // Fem espai per inserir
        fig[pos] = obj;
        cantidad++;

        return -1;
    }

    public int cercar(int codi) {
        int pos;
        return Arrays.binarySearch(fig, 0, cantidad,codi);
    }

    public FiguraGeometrica02 exemplarAt(int i) {
        if (i<0 || i>=cantidad) return null;
        return fig[i];
    }

    public FiguraGeometrica02 extreure(int codi) {
        FiguraGeometrica02 aux;
        int pos;
        pos=Arrays.binarySearch(fig, 0, cantidad, codi);

        if (pos<0) return null;
        aux = fig[pos];

        for (; pos < cantidad-1; pos++) fig[pos] = fig[pos+1];
        fig[cantidad-1]=null;   // Per a que la figura geom�trica no quedi apuntada innecess�riament
        cantidad--;

        return aux;
    }

    public void vaciar() {
        int i;
        for (i=0; i<cantidad; i++) fig[i]=null;
        cantidad=0;
    }

    public void visualitzar() {
        int i;
        System.out.println ("Contingut de la taula");
        System.out.println ("*********************");
        System.out.println ("Capacitat....: " + fig.length);
        System.out.println ("Nre. Elements: " + cantidad);
        for (i=0; i<cantidad; i++)
            System.out.println("Element " + i + ": " + fig[i]);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof GrupOrdenatFiguraGeometricaViaTaula){
            GrupOrdenatFiguraGeometricaViaTaula aux = (GrupOrdenatFiguraGeometricaViaTaula)obj;
            int i;
            if (cantidad!=aux.cantidad) return false;
            for (i=0; i<cantidad && fig[i].equals(aux.fig[i]); i++);
            if (i==cantidad) return true; // Vol dir que totes les figures de t s�n iguals (dos a dos) amb les figures
            // de l'altre grup obj
        }
        return false;
    }

    public int hashCode () {
        int result=0;
        int i;
        for (i=0; i<cantidad; i++) result = result + fig[i].hashCode();
        return result;
    }

}
