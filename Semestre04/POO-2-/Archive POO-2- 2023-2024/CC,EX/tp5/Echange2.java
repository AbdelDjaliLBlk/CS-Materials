/* Le code ne compile pas car lors de l'invocation des méthodes setVal1() et setVal2() le type des paramètres passés n'est pas connu à cause de l'utilisation du wildcard.

/*La solution pour contourner cette erreur de compilation est de définir une méthode helper dont le type paramétré utilise 
 * 
 une variable nommée. Le compilateur peut alors faire la capture et on peut faire référence au type paramétré dans le code.
*/
class Echange2<T> {
    private T val1;
    private T val2;
    public Echange2(T val1, T val2) {
        this.val1 = val1;
        this.val2 = val2;
    }
    public T getVal1() {
        return val1;
    }
    public void setVal1(T val1) {
        this.val1 = val1;
    }
    public T getVal2() {
        return val2;
    }
    public void setVal2(T val2) {
        this.val2 = val2;
    }
    
      
    
    static <V> void permuterValeursHelper(Echange2<V> e) {
        V getVal1 = e.getVal1();
        e.setVal1(e.getVal2());
        e.setVal2(getVal1);
    }

    static <V> void permuterValeurs(Echange2<?> e) {
        permuterValeursHelper(e);
    }
    
    public static void main(String[] args) {
        Echange2<Integer> p1 = new Echange2<Integer>(10, 20);
        System.out.println("Avant : " + p1.getVal1() + ", " + p1.getVal2());
        Echange2<?> p2 = p1;
        permuterValeurs(p2);
        System.out.println("Apres : " + p2.getVal1() + ", " + p2.getVal2());
        System.out.println(p2.getVal1().getClass().getName());


    }
}

class Etudiant {}
