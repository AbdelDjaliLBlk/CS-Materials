import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Création d'une liste d'entiers
        List<Integer> entiers = new ArrayList<>();
        entiers.add(5);
        entiers.add(10);
        entiers.add(3);
        entiers.add(7);

        // Test de la méthode max avec des entiers
        Integer maxEntier = Maximal.max(entiers, 0, entiers.size());
        System.out.println("Le plus grand entier est : " + maxEntier);

        // Création d'une liste de chaînes de caractères
        List<String> chaines = new ArrayList<>();
        chaines.add("hello");
        chaines.add("world");
        chaines.add("java");

        // Test de la méthode max avec des chaînes de caractères
        String maxChaine = Maximal.max(chaines, 0, chaines.size());
        System.out.println("La plus grande chaîne est : " + maxChaine);
    }
}