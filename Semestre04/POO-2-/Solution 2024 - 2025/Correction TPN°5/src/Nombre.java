public class Nombre {
    private int valeur ;
    public Nombre(int d){
        valeur = d;
    }
    public double racineCarree() throws NegativeException{
        if(valeur < 0 ) throw new NegativeException(valeur + "est une valeur negative !");
        else return Math.sqrt(valeur);
    }
}
