import java.util.Arrays;

public class Exo1 {
    public static void main(String[] args) {
    Integer [] integers = { 1 , 2 , 3 , 4 , 5};
    swap(integers , 3 , 1);
        System.out.println(Arrays.toString(integers));


        String [] strings = {"A" , "B" , "C" , "D" , "E"};
    swap(strings,-1,4);
        System.out.println(Arrays.toString(strings));
    }

    public static <T> void swap(T[] arr, int first, int last) {
        if (first < 0 || last < 0) {
            throw new IndexOutOfBoundsException("Un des parametres est hors limites!");
        }
        else if(arr == null){
            throw new NullPointerException("Tableau vide!");
        }
            T tmp = arr[first];
            arr[first] = arr[last];
            arr[last] = tmp;
        }
    }
