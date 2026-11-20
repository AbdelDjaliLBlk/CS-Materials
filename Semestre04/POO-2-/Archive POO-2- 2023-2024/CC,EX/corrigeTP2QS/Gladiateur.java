/**
 * Un gladiateur dans une arène.
 */
class Gladiateur extends Humain implements Guerrier {
    int force;
    private static final String[] nomsAleatoires = { "Spartacus", "Maximus", "Cesar", "Crixus", "Spiculus", "Flamma",
            "Carpophorus", "Commodus", "Hermes", "Marcus Attilius", "Mevia" };
    private static int indiceNomsAleatoires = 0;
    Gladiateur() {
        super(nomsAleatoires[indiceNomsAleatoires++]);
        this.force = 10 + (int) (Math.ceil(Math.random() * 10));
    }
    public int getForce() {
        return force;
    }

    public void attaque(Personnage adversaire) {
        if (adversaire == null)
            System.out.println("Aucun adversaire sélectionné !!!");
        else if (!(adversaire instanceof Gladiateur))
            System.out.println("L'adversaire n'est pas un gladiateur !!!");
        else if (this == adversaire)
            System.out.println("Auto-attaque interdite !!!");
        else if (!(adversaire.estVivant()))
            System.out.println("Adversaire déjà mort !!!");
        else {
            System.out.println(this + " attaque " + adversaire);
            adversaire.pointsVie -= getForce();
        }
    }
}