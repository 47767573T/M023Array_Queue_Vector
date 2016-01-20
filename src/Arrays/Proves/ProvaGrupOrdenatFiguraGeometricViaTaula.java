package Arrays.Proves;

import Arrays.Main.GrupOrdenatFiguraGeometricaViaTaula;
import Arrays.figGeometricas.Cercle02;
import Arrays.figGeometricas.FiguraGeometrica02;
import Arrays.figGeometricas.Rectangle02;
import Arrays.figGeometricas.Triangle02;

import java.awt.*;

/**
 * Created by Moises on 20/01/2016.
 */
public class ProvaGrupOrdenatFiguraGeometricViaTaula {


    private static void missatgeAfegir (int error, FiguraGeometrica02 obj) {
        System.out.println ("Afegir l'objecte " + obj);
        if (error==-1) System.out.println("   Afegit.");
        else if (error==-2) System.out.println("   No afegit per ser null.");
        else if (error==-3) System.out.println("   No afegit per manca d'espai.");
        else System.out.println("   Codi "+obj.getCodi()+" existent a la posici� "+error);
    }

    public static void main(String args[]) {
        GrupOrdenatFiguraGeometricaViaTaula tfg= new GrupOrdenatFiguraGeometricaViaTaula(50);
        Rectangle02 r1 = new Rectangle02(35,"Rectangle35", Color.yellow, 4.3, 3.2);
        Rectangle02 r2 = new Rectangle02(90,"Rectangle90", Color.pink, 5.1, 4.2);

        Triangle02 t1 = new Triangle02(21,"Triangle21", Color.red, 8.6, 2.2);
        Triangle02 t2 = new Triangle02(10,"Triangle10", Color.orange, 3.6, 4.2);

        Cercle02 c2 = new Cercle02(3,"Cercle03", Color.gray, 3.2);
        Cercle02 c1 = new Cercle02(42,"Cercle42", Color.white, 5.2);
        int pos;

        System.out.println("Procedim a afegir alguns elements al grup.");
        missatgeAfegir(tfg.afegir(r1), r1);
        missatgeAfegir(tfg.afegir(t1), t1);
        missatgeAfegir(tfg.afegir(c1), c1);
        missatgeAfegir(tfg.afegir(r2), r2);
        missatgeAfegir(tfg.afegir(t2), t2);
        missatgeAfegir(tfg.afegir(c2), c2);
        System.out.println();
        tfg.visualitzar();
        System.out.println();
        System.out.println("Procedim a cercar la figura amb codi 42:");
        pos=tfg.cercar(42);

        if (pos>=0){
            System.out.println("Hem trobat el codi a la posici� " + pos + ":");
            tfg.exemplarAt(pos).visualitzar();

        } else {
            System.out.println("No existeix el codi cercat.");
            System.out.println("Per fer inserci� ordenada caldria inserir-lo a la posici� " + (-pos-1) + ".");
        }
        System.out.println();
        System.out.println("Procedim a cercar la figura amb codi 50:");
        pos=tfg.cercar(50);

        if (pos>=0) {
            System.out.println("Hem trobat el codi a la posici� " + pos + ":");
            tfg.exemplarAt(pos).visualitzar();

        } else {
            System.out.println("No existeix el codi cercat.");
            System.out.println("Per fer inserci� ordenada caldria inserir-lo a la posici� " + (-pos-1) + ".");
        }
    }

}
