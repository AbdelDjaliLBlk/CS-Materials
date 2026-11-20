import java.util.ArrayList;

public class Garage {
    private int capacite , current = 0;
    ArrayList<Voiture> voitures= new ArrayList<Voiture>();
    public Garage() {
        capacite = 1;
    }
    public Garage(int capacite) {
        this.capacite = capacite;
    }
    public int getCapacite(){
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public int getCurrent() {
        return current;
    }
    public void ajouter(Voiture voiture) throws GarageFull {
        if (voitures.size() == capacite) {
            throw new GarageFull("Garage est plein!");
        } else {
            voitures.add(voiture);
        }

    }

    public void afficherDetailsVoitures() {
        System.out.println("--> Garage contient " + voitures.size() + " voitures :");
        if(voitures.size() != 0)
            for (int i = 0 ; i < voitures.size() ; i++)
            voitures.get(i).afficherDetails();

    }

    public void rechercheVoiture(String marque) {
        for (int i = 0 ; i< voitures.size() ; i++) {
            if (voitures.get(i).marque.equals(marque)) {
                System.out.println("--> Voiture de marque " + marque + " trouve !");
                voitures.get(i).afficherDetails();
                return;
            }
        }
        System.out.println("--> Voiture de marque " + marque + " non trouve !");
    }
}