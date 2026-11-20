public class Voiture{
    String marque ;
    double anneefab;
    public Voiture(String marque , double anneefab){
        this.marque = marque ;
        this.anneefab = anneefab;
    }
    public String toString() {
        return "Modele : "+marque+",fabrique en "+anneefab+" .";
    }
    public void afficherDetails(){
        System.out.println(this.toString());
    }

}