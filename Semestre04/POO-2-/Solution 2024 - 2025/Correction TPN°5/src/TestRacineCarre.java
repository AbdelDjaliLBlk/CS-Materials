import java.util.Scanner;

public class TestRacineCarre {
    public static void main(String [] args){
        int entier=0;
        Nombre d;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrer un entier: ");
        try {
            entier = clavier.nextInt();
        } catch (Exception e) {
            System.out.println("Il faut saisir un entier!");

        }
        try {
            d = new Nombre(entier);
            System.out.println(d.racineCarree());
        }
        catch (NegativeException e){
            throw new RuntimeException(e);
        }
        finally{
            clavier.close();
        }
    }
}
