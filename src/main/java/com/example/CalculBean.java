package com.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculBean {

    private double a;  // Coefficient devant x
    private double b;  // Terme constant pour le 1er degré ou coefficient de x pour le 2nd degré
    private double c;  // Terme constant pour le 2nd degré
    private String resultat;

    // Getters et Setters
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }
    public double getB() { return b; }
    public void setB(double b) { this.b = b; }
    public double getC() { return c; }
    public void setC(double c) { this.c = c; }
    public String getResultat() { return resultat; }
    public void setResultat(String resultat) { this.resultat = resultat; }

    // Opérations de base
    public void addition() { resultat = String.valueOf(a + b); }
    public void soustraction() { resultat = String.valueOf(a - b); }
    public void multiplication() { resultat = String.valueOf(a * b); }
    public void division() {
        if (b != 0) resultat = String.valueOf(a / b);
        else resultat = "Erreur : division par zéro";
    }

    // Equation du 1er degré ax + b = 0
    public void eq1() {
        if (a != 0) resultat = "X = " + (-b / a);
        else resultat = "Impossible : a = 0";
    }

    // Equation du 2nd degré ax² + bx + c = 0
    public void eq2() {
        if (a == 0) {
            // Si a = 0, on retombe sur une équation du 1er degré bx + c = 0
            if (b != 0) resultat = "X = " + (-c / b);
            else resultat = (c == 0) ? "Infinité de solutions" : "Pas de solution";
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            resultat = "Pas de solution réelle";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            resultat = "X = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            resultat = "X1 = " + x1 + ", X2 = " + x2;
        }
    }

    // Réinitialisation
    public void effacer() {
        a = 0; b = 0; c = 0;
        resultat = "";
    }
}
