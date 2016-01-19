package Vector.Proves;

import java.awt.Color;

import Vector.Main.GrupOrdenatFiguraGeometricaViaVector;
import Vector.figGeometricas.*;


/**
 * Created by Moises on 18/01/2016.
 */
public class ProvaGrupOrdenatFiguraGeometricaViaVector {

      public static void main(String args[]) {

            //Creamos el vector de prueba
            GrupOrdenatFiguraGeometricaViaVector vector= new GrupOrdenatFiguraGeometricaViaVector();

            //Creamos 2 objetos de cada figura
            Rectangle02 rect1 = new Rectangle02(1,"r2_rect1", Color.white, 5, 5);
            Rectangle02 rect2 = new Rectangle02(5,"r2_rect2", Color.red, 20, 5.3);

            Triangle02 tria1 = new Triangle02(9,"t2_tria1", Color.black, 25, 5.7);
            Triangle02 tria2 = new Triangle02(4,"t2_tria2", Color.white, 30, 18);

            Cercle02 cerc1 = new Cercle02(8,"c2_cerc1", Color.blue, 10);
            Cercle02 cerc2 = new Cercle02(6,"c2_cerc2", Color.yellow, 265);


            //Control de los errores
            msgError(vector.afegir(rect1), rect1);
            msgError(vector.afegir(rect2), rect2);

            msgError(vector.afegir(tria1), tria1);
            msgError(vector.afegir(tria2), tria2);

            msgError(vector.afegir(cerc1), cerc1);
            msgError(vector.afegir(cerc2), cerc2);

            System.out.println("Quantitat de figures de"+vector.nreElements()
                    +" de "+vector.capacitat()+" totals");

            System.out.println("Mostrem el métode cercar");
            vector.cercar(4);
            vector.cercar(25);

            System.out.println("Eliminamos la figura 9 y mostramos");
            vector.extreure(9);
            vector.visualitzar();

            System.out.println("Vaciamos el vector");
            vector.buidar();
            vector.visualitzar();
      }

      /**
       * Metodo que gestiona los mensages de errores inherentes en cada figura cuando se añaden a un vector
       * @param error codigo del error
       * @param obj figura añadida
        */
      private static void msgError (int error, FiguraGeometrica02 obj) {

            System.out.print ("\tAñadir:  " + obj.toString());

            if (error==-1) System.out.println(" ...OK.");
            else if (error==-2) System.out.println(" ...ERROR por NULL");
      }
}
