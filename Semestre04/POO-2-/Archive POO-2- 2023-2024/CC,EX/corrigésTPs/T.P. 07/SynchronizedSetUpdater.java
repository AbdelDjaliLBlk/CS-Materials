import java.util.*;

public class SynchronizedSetUpdater {
    private static Set<Object> set = new HashSet<>();

    public static void main(String[] args) {
        // Création et démarrage des threads pour ajouter différents types d'éléments
        Thread threadString = new Thread(new StringUpdater());
        Thread threadInteger = new Thread(new IntegerUpdater());
        Thread threadBoolean = new Thread(new BooleanUpdater());
        
        threadString.start();
        threadInteger.start();
        threadBoolean.start();
        
        // Attente de la fin de tous les threads
        try {
            threadString.join();
            threadInteger.join();
            threadBoolean.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Affichage du contenu final de l'ensemble
        System.out.println("Contenu final de l'ensemble : " + set);
    }

    // Classe interne pour ajouter des chaînes de caractères à l'ensemble
    static class StringUpdater implements Runnable {
        @Override
        public void run() {
            synchronized(set) {
                set.add("hello");
                set.add("world");
            }
        }
    }

    // Classe interne pour ajouter des entiers à l'ensemble
    static class IntegerUpdater implements Runnable {
        @Override
        public void run() {
            synchronized(set) {
                set.add(123);
                set.add(456);
            }
        }
    }

    // Classe interne pour ajouter des booléens à l'ensemble
    static class BooleanUpdater implements Runnable {
        @Override
        public void run() {
            synchronized(set) {
                set.add(true);
                set.add(false);
            }
        }
    }
}
/**
 * Output 1 : Contenu final de l'ensemble : [world, false, 456, hello, 123, true].
 * Output 2 : Contenu final de l'ensemble : [world, false, 456, hello, 123, true].
 * */