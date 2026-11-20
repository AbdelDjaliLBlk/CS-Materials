import java.util.Arrays;
import java.util.Scanner;

public class Exo2 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int size;
//        try {
//            System.out.println("Enter the size of the table :");
//            size = scan.nextInt();
//            if(size <= 0) throw new RuntimeException();
//        }
//            catch (RuntimeException e)
//            {
//                System.out.println(e.toString());
//            }
//        finally{
//            scan.close();
//        }
//        String []strings = new String [size];
//        for(int i = 0 ; i < size ; i++) {
//            System.out.print("Arr ["+i+"] = ");
//            strings[i] = scan.next();
//        }
        String []strings ={ "F", "B" ,"O", "R" , "O"};
        System.out.println(Arrays.toString(strings));

        System.out.println(findFirstOcc(strings , "O"));
        System.out.println(findFirstOcc(strings , "A" , 2));

        Etudiant []etudiants = new Etudiant[3];
        etudiants[0] = new Etudiant("Mohammed");
        etudiants[1] = new Etudiant("Amine");
        etudiants[2] = new Etudiant("Fouad");

        System.out.println(Arrays.toString(findAllOcc(strings,"O")));

    }

    public static <A> int findFirstOcc(A[] arr, A key) {
        if (arr == null) {
            throw new NullPointerException("Tableau vide!");
        }
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
    public static <A> int findFirstOcc(A[] arr, A key , int ignoredParameter) {
        if (arr == null)
            return -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == key)
                return 1;
        }
        return -1;
    }
    public static <A> int [] findAllOcc(A[] arr , A key){
        int [] occurences = new int [arr.length];
        if(arr == null)
            return occurences;
        int occ = 0 , tmp = 0;
        for(A x : arr)
        {
            if(x == key){
                occurences[tmp] = occ;
                tmp ++ ;
            }
            occ++;
        }
        return occurences;
    }

}