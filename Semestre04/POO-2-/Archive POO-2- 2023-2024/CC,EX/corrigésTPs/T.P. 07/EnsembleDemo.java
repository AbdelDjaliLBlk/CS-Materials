import java.util.*;

public class EnsembleDemo {
    public static void main(String[] args) {
        /**
         * Official documentation :
         * Set (Java class) : A collection that contains no duplicate elements. More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), and at most one null element. As implied by its name, this interface models the mathematical set abstraction.
         * HashSet (Java class) : This class implements the Set interface, backed by a hash table (actually a HashMap instance). It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. This class permits the null element.
         * */
        Set<Object> set = new HashSet<>();
        // Ajout d'éléments à l'ensemble.
        set.add(true);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble avant l'ajout de doublons : " + set);
        // Ajout de doublons à l'ensemble.
        set.add(1);
        set.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble après l'ajout de doublons : " + set);
        /**
         * Does the HashSet order according to the HashCode ?
         * */
        for(Object object : set)
            System.out.println(object.hashCode());
        /**
         * Official Documentation :
         * TreeSet : A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.
         * */
        Set<Object> set2 = new TreeSet<>();
        // Ajout d'éléments à l'ensemble.
        set2.add(true);
        set2.add(false);
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble avant l'ajout de doublons : " + set2);
        // Ajout de doublons à l'ensemble.
        set2.add(true);
        set2.add(false);
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble après l'ajout de doublons : " + set2);
        /**
         * set2.add(1);
         * set2.add(2);
         * set2.add(3);
         * set2.add("chaine");
         * // Affichage du contenu de l'ensemble.
         * System.out.println("Contenu de l'ensemble : " + set2);
         * // Ajout de doublons à l'ensemble.
         * set2.add(1);
         * set2.add("chaine");
         * // Affichage du contenu de l'ensemble.
         * System.out.println("Contenu de l'ensemble après l'ajout de doublons : " + set2);
         * Exception :
         * Exception in thread "main" java.lang.ClassCastException: class java.lang.Boolean cannot be cast to class java.lang.Integer (java.lang.Boolean and java.lang.Integer are in module java.base of loader 'bootstrap')
         * 	at java.base/java.lang.Integer.compareTo(Integer.java:71)
         * 	at java.base/java.util.TreeMap.put(TreeMap.java:814)
         * 	at java.base/java.util.TreeMap.put(TreeMap.java:534)
         * 	at java.base/java.util.TreeSet.add(TreeSet.java:255)
         * 	at EnsembleDemo.main(EnsembleDemo.java:22) // Ajout de 1
         * */
        Set<Object> set3 = new TreeSet<>(new CustomComparator());
        // Ajout d'éléments à l'ensemble.
        set3.add(true);
        set3.add(1);
        set3.add(2);
        set3.add(3);
        set3.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble avant l'ajout de doublons : " + set3);
        // Ajout de doublons à l'ensemble.
        set3.add(1);
        set3.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble après l'ajout de doublons : " + set3);
        /**
         * Official documentation :
         * LinkedHashSet (Java class) : Hash table and linked list implementation of the Set interface, with predictable iteration order. This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order). Note that insertion order is not affected if an element is re-inserted into the set. (An element e is reinserted into a set s if s.add(e) is invoked when s.contains(e) would return true immediately prior to the invocation.)
         * */
        Set<Object> set4 = new LinkedHashSet<>();
        // Ajout d'éléments à l'ensemble.
        set4.add(true);
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble avant l'ajout de doublons : " + set4);
        // Ajout de doublons à l'ensemble.
        set4.add(1);
        set4.add("chaine");
        // Affichage du contenu de l'ensemble.
        System.out.println("Contenu de l'ensemble après l'ajout de doublons : " + set4);
    }
}
