abstract class Humain extends Personnage {
    Humain(String nom) {
        super(nom, 0, 0, 1);
    }
    String parler() {
        return "Je suis " + nom;
    }
}