package ehtp._gi.tp_initiation_sonarqube.Service;



public class Calculator {

    // Bug logique volontaire : division incorrecte
    public int divide(int a, int b) {
        return a / a; // devrait être a / b
    }

    // Bug logique volontaire : condition incorrecte
    public boolean isPositive(int x) {
        if (x < 0) {
            return true; // faux, devrait être false
        }
        return false;
    }
}

