package Vector.figGeometricas;
import java.awt.Color;

public class Triangle02 extends Vector.figGeometricas.FiguraGeometrica02 {
   private double base=0, altura=0;
   
   public Triangle02 (int ncodi, String nnom, Color ncolor, double nbase, double naltura) {
      super (ncodi, nnom, ncolor);
      if (nbase>0) base=nbase;
      if (naltura>0) altura=naltura;
   }

   public Triangle02() {
   }
   
   public Triangle02 (Triangle02 r) {
      this (r.codi, r.nom, r.color, r.base, r.altura);
   }
   
   public void setBase (double novaBase) {
      if (novaBase>=0) base = novaBase;
   }

   public void setAltura (float novaAltura) {
      if (novaAltura>=0) altura = novaAltura;
   }

   public double getBase() {
      return base;
   }
   
   public double getAltura() {
      return altura;
   }
   
   public double area () {
      return base*altura/2;
   }

   public void visualitzar () {
      System.out.println ("S�c un triangle");
      System.out.println ("***************");
      super.visualitzar();
      System.out.println ("Base..........:" + base);
      System.out.println ("Altura........:" + altura);
      System.out.println ("�rea..........:" + area());
   }

   public String toString() {
      return "Triangle " + super.toString();
   }

}