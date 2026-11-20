import java.util.ArrayList;

class Arene {

    ArrayList<Gladiateur> gladiateurs;

    Arene(int nombreGladiateurs) {
        gladiateurs = new ArrayList<Gladiateur>();
        for (int i = 0; i < nombreGladiateurs; i++)
            gladiateurs.add(new Gladiateur());
    }

    private int nombreGladiateursVivants() {
        int nombreDeGladiateursVivants = 0;
        for (Gladiateur gladiateur : gladiateurs)
            if (gladiateur.estVivant())
                nombreDeGladiateursVivants++;
        return nombreDeGladiateursVivants;
    }

    private Gladiateur getGagnant() {
        if (nombreGladiateursVivants() == 1)
            for (Gladiateur gladiateur : gladiateurs)
                if (gladiateur.estVivant())
                    return gladiateur;
        return new Gladiateur();
    }

    public void commencer() {
        int indiceAttaquant = 0;
        while (nombreGladiateursVivants() > 1) {
            if (gladiateurs.get(indiceAttaquant).estVivant())
                gladiateurs.get(indiceAttaquant).attaque(
                        gladiateurs.get((int) ((gladiateurs.size() * Math.random())))
                );
            indiceAttaquant = (++indiceAttaquant) % gladiateurs.size();
        }
        Gladiateur gladiateurGagnant = getGagnant();
        System.out.println(gladiateurGagnant + " dit : " + gladiateurGagnant.parler());
    }
}