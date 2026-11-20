import java.util.Scanner;
public class Vowelcheck {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with vowels : ");
    String s = scanner.next();
    try{
        checkvowels(s);
    }
        catch(NoVowelsException e){
            System.out.println(e.toString());
        }
        finally{
            scanner.close();
            }
    }

    public static void checkvowels (String s) throws NoVowelsException {
        String []strings = { "a" , "e" , "i" , "o" , "u" , "A" , "E" , "I" , "O" , "U"};
        boolean bo = false ;
        for(String x : strings){
            if(s.contains(x)){
                bo = true;
            }
        }
        if(bo)
            System.out.println(s+ " contains at least one vowel .");
        else
            throw new NoVowelsException("Does not contains vowels !");
    }

}