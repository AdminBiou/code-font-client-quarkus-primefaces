package com.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EquationHttpService {

    // Addition
    public String add(int a, int b) {
        return String.valueOf(a + b);
    }

    // Soustraction
    public String sub(int a, int b) {
        return String.valueOf(a - b);
    }

    // Multiplication
    public String mul(int a, int b) {
        return String.valueOf(a * b);
    }

    // Division
    public String div(int a, int b) {
        if (b == 0) {
            return "Erreur : division par zéro";
        }
        return String.valueOf(a / b);
    }

    // Equation du 1er degré ax + b = 0
    public String eq1(int a, int b) {
        if (a == 0) {
            return b == 0 ? "Infinité de solutions" : "Pas de solution";
        }
        double x = -b / (double) a;
        return "X = " + x;
    }

    // Equation du 2nd degré ax² + bx + c = 0
    public String eq2(int a, int b, int c) {
        if (a == 0) {
            return eq1(b, c);
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return "Pas de solution réelle";
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            return "X = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            return "X1 = " + x1 + ", X2 = " + x2;
        }
    }
}
