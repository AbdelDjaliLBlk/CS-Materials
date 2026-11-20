package c;
import a.*;
import b.*;
import java.util.*;
public class Main {
    ArrayList<I> aL ;
    Main(){
        aL = new ArrayList<>();
    }
    public static void main(String[] args) {
        Main main= new Main();
        main.aL.add(new B(12));
        main.aL.add(new C());
        main.aL.add(new B(-2));
        main.aL.add(new B(4));
        main.aL.add(new C());
        //Affichage.
        for (Object x : main.aL) {
            if (x instanceof B) {
                ((B) x).afficher();
            }
        }
        System.out.println("Somme = " + somme(main.aL));

        Iterator <I> it = main.aL.iterator();
        while (it.hasNext()) {
            (it.next()).afficher();
        }

    }
    //Methode somme.
    static int somme(ArrayList arr){
        int sum = 0;
        for(Object x : arr){
            if(x instanceof B){
                sum += ((B) x).getA();
            }
        }
        return sum;
    }
}