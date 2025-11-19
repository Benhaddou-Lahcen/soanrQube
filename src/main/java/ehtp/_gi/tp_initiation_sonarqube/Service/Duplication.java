package ehtp._gi.tp_initiation_sonarqube.Service;

public class Duplication {

    // DUPLICATION TRÈS ÉVIDENTE - 15 lignes identiques
    public double calculerTotalCommande(double prixUnitaire, int quantite) {
        double sousTotal = prixUnitaire * quantite;
        double tauxTVA = 0.20;
        double montantTVA = sousTotal * tauxTVA;
        double total = sousTotal + montantTVA;

        // Logique d'arrondi
        total = Math.round(total * 100.0) / 100.0;

        // Logique de validation
        if (total < 0) {
            throw new IllegalArgumentException("Le total ne peut pas être négatif");
        }

        // Logique de logging
        System.out.println("Total commande calculé : " + total);
        System.out.println("Sous-total : " + sousTotal);
        System.out.println("TVA : " + montantTVA);

        return total;
    }

    // MÊME CODE DUPLIQUÉ - 15 lignes identiques
    public double calculerTotalFacture(double prixArticle, int nombreArticles) {
        double sousTotal = prixArticle * nombreArticles;
        double tauxTVA = 0.20;
        double montantTVA = sousTotal * tauxTVA;
        double total = sousTotal + montantTVA;

        // Logique d'arrondi
        total = Math.round(total * 100.0) / 100.0;

        // Logique de validation
        if (total < 0) {
            throw new IllegalArgumentException("Le total ne peut pas être négatif");
        }

        // Logique de logging
        System.out.println("Total commande calculé : " + total);
        System.out.println("Sous-total : " + sousTotal);
        System.out.println("TVA : " + montantTVA);

        return total;
    }

    // ENCORE UNE FOIS LE MÊME CODE - 15 lignes identiques
    public double calculerMontantFinal(double prix, int quantite) {
        double sousTotal = prix * quantite;
        double tauxTVA = 0.20;
        double montantTVA = sousTotal * tauxTVA;
        double total = sousTotal + montantTVA;

        // Logique d'arrondi
        total = Math.round(total * 100.0) / 100.0;

        // Logique de validation
        if (total < 0) {
            throw new IllegalArgumentException("Le total ne peut pas être négatif");
        }

        // Logique de logging
        System.out.println("Total commande calculé : " + total);
        System.out.println("Sous-total : " + sousTotal);
        System.out.println("TVA : " + montantTVA);

        return total;
    }
}