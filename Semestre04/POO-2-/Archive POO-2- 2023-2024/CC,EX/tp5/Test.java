import java.util.ArrayList;
import java.util.List;

// Interface représentant une forme géométrique
interface Forme {
    double aire() throws AireNegativeException;
}

// Exceptions personnalisées
class ListeVideException extends Exception {
    public ListeVideException(String message) {
        super(message);
    }
}

class AireNegativeException extends Exception {
    public AireNegativeException(String message) {
        super(message);
    }
}

// Classe représentant un cercle
class Cercle implements Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double aire() throws AireNegativeException {
        double aire = Math.PI * rayon * rayon;
        if (aire < 0) {
            throw new AireNegativeException("L'aire d'un cercle ne peut pas être négative.");
        }
        return aire;
    }
}

// Classe représentant un carré
class Carre implements Forme {
    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    @Override
    public double aire() throws AireNegativeException {
        double aire = cote * cote;
        if (aire < 0) {
            throw new AireNegativeException("L'aire d'un carré ne peut pas être négative.");
        }
        return aire;
    }
}

// Classe représentant un rectangle
class Rectangle implements Forme {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double aire() throws AireNegativeException {
        double aire = longueur * largeur;
        if (aire < 0) {
            throw new AireNegativeException("L'aire d'un rectangle ne peut pas être négative.");
        }
        return aire;
    }
}

public class Test {
    // Méthode générique utilisant des wildcards pour calculer la somme des aires de toutes les formes
    public static double sommeAires(List<? extends Forme> formes) throws ListeVideException, AireNegativeException {
        if (formes.isEmpty()) {
            throw new ListeVideException("La liste de formes est vide.");
        }

        double somme = 0;
        for (Forme forme : formes) {
            somme += forme.aire();
        }
        return somme;
    }

    public static void main(String[] args) {
        // Création de quelques formes géométriques
        Cercle cercle = new Cercle(5);
        Carre carre = new Carre(4);
        Rectangle rectangle = new Rectangle(3, 6);

        // Création d'une liste de formes géométriques
        List<Forme> formes = new ArrayList<>();
        formes.add(cercle);
        formes.add(carre);
        formes.add(rectangle);

        try {
            // Calcul de la somme des aires des formes géométriques
            double somme = sommeAires(formes);
            System.out.println("La somme des aires des formes géométriques est : " + somme);
        } catch (ListeVideException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (AireNegativeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
