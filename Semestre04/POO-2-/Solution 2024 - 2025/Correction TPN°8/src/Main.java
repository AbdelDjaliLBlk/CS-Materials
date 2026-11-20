import java.util.*;

public class Main {
    public static void main(String[] args) {
       //Creation d'un objet ArrayList et ajouter des elements.
        ArrayList <Object> arraylist = new ArrayList<>();
       arraylist.add("Ahmed");
       arraylist.add(20);
       arraylist.add(false);
       System.out.println("ArrayList : "+arraylist.toString());

        //Creation d'un objet LinkedList à partir d'un ArrayList.
        LinkedList <Object> ll = new LinkedList<>(arraylist);
        ll.addFirst("Amine");
        System.out.println("LinkedList : "+ll.toString());

        //Verifier s'il contient tous les elements.
        System.out.println("Checking if it contains all : "+ ll.containsAll(arraylist));

        //Augmenter puis diminuer la taille.
        arraylist.ensureCapacity(2);
        arraylist.trimToSize();

        //Shuffle and reverse the LinkedList.
        Collections.shuffle(ll);
        System.out.println("Shuffled LinkedList : "+ll.toString());
        Collections.reverse(ll);
        System.out.println("Reversed LinkedList : "+ll.toString());

        //Comparer arrayList et linkedList.
        double taux= 0 ;
        for(Object x : arraylist) {
            if (ll.contains(x))
                ++taux;
            }
        taux = (taux/arraylist.size()) * 100;
        System.out.println("Taux de similarite = "+ taux+"%.");

        //Extraire une sous-liste.
        System.out.println("SubLinkedList : "+ll.subList(0,2).toString());

        //Supprimer le premier element et afficher la liste.
        ll.removeFirst();
        System.out.println("Taille apres suppression: "+ll.size());

        //Supprimer tous les elements de l'objet ArrayList.
        arraylist.clear();
        System.out.println("Taiile de arrayList apres clear():"+arraylist.size());
        }
    }