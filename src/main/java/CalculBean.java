import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CalculBean implements Serializable {

    private double a;
    private double b;
    private double c;
    private String resultat;

    // ----- Getters et Setters -----
    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public double getC() { return c; }
    public void setC(double c) { this.c = c; }

    public String getResultat() { return resultat; }
    public void setResultat(String resultat) { this.resultat = resultat; }

    // ----- Opérations de base -----
    public void addition() {
        resultat = String.valueOf(a + b);
    }

    public void soustraction() {
        resultat = String.valueOf(a - b);
    }

    public void multiplication() {
        resultat = String.valueOf(a * b);
    }

    public void division() {
        if (b != 0) {
            resultat = String.valueOf(a / b);
        } else {
            resultat = "Erreur : division par zéro";
        }
    }

    // ----- Équation 1D : ax + b = 0 -----
    public void eq1() {
        if (a != 0) {
            double x = -b / a;
            resultat = "x = " + x;
        } else {
            resultat = (b == 0) ? "∞ solutions" : "Aucune solution";
        }
    }

    // ----- Équation 2D : ax² + bx + c = 0 -----
    public void eq2() {
        if (a == 0) {
            eq1(); // réduit à équation 1D
            return;
        }
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            resultat = "x1 = " + x1 + " ; x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            resultat = "x = " + x;
        } else {
            resultat = "Aucune solution réelle";
        }
    }

    // ----- Effacer tous les champs -----
    public void effacer() {
        a = 0;
        b = 0;
        c = 0;
        resultat = "";
    }
}
