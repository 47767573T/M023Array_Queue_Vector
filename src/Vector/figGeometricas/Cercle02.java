package Vector.figGeometricas;

import java.awt.Color;


public class Cercle02 extends FiguraGeometrica02 {
      private double radi=0;

      public Cercle02 (int ncodi, String nnom, Color ncolor, double nradi) {
            super (ncodi, nnom, ncolor);
            if (nradi>0) radi=nradi;
      }

      public Cercle02 (Cercle02 c) {
         this (c.codi, c.nom, c.color, c.radi);
      }

      public Cercle02 () {}

      public void setRadi (double nouRadi) {
         if (nouRadi>=0) radi = nouRadi;
      }

      public double getRadi () {
         return radi;
      }

      public double perimetre () {
         return 2*Math.PI*radi;
      }

      public double area () {
         return Math.PI * radi * radi;
      }

      public void visualitzar () {
            System.out.println ("S�c un cercle");
            System.out.println ("*************");
            super.visualitzar();
            System.out.println ("Radi..........:" + radi);
            System.out.println ("Longitud......:" + perimetre());
            System.out.println ("�rea..........:" + area());
      }

      public String toString() {
         return "Cercle " + super.toString();
      }

}