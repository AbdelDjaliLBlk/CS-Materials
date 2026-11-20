public class VoitureDeSport extends Voiture{
    private int maxSpeed;
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    public int getMaxSpeed(){
        return maxSpeed;
    }
    public VoitureDeSport(String marque , double anneefab , int maxSpeed){
        super(marque,anneefab);
        this.maxSpeed = maxSpeed;
    }
    public String toString(){
        return "{Voiture de sport. "+ super.toString() + "Vitesse max :" + maxSpeed + " }";
    }
    public void afficherDetails(){
        System.out.println(this.toString());
    }
}
