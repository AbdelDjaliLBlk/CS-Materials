class VoitureFamiliale extends Voiture{
    private int Nbplaces;

    public VoitureFamiliale(String marque , double anneefab , int Nplaces){
        super(marque,anneefab);
        this.Nbplaces = Nplaces;
    }
    public void setNblaces(int Nbplaces){
        this.Nbplaces = Nbplaces;
    }
    public int getNbplaces(){
        return Nbplaces;
    }
    public String toString(){
        return "{Voiture familiale."+ super.toString() + "Nombre de places :" + Nbplaces + " }";
    }
    public void afficherDetails(){
        System.out.println(this.toString());
    }
}
