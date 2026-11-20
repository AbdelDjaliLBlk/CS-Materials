public class Principale {
    public static void main(String [] args) {
        Garage garage = new Garage(2);
        VoitureFamiliale v1 = new VoitureFamiliale("Hyundai", 2016, 4);
        VoitureDeSport v2 = new VoitureDeSport("Porshe", 2024, 230);
        VoitureFamiliale v3 = new VoitureFamiliale("Picanto", 2012, 5);
     try{
        garage.ajouter(v1);
        garage.ajouter(v2);
        //garage.ajouter(v3);
    } catch (GarageFull e) {
         throw new RuntimeException(e);
     }
     garage.afficherDetailsVoitures();
     garage.rechercheVoiture("Hyundai");
     garage.rechercheVoiture("Renault");

    }
}
