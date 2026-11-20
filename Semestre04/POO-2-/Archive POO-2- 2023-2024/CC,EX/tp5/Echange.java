public class Echange<T> {
    private T val1;
    private T val2;
    public Echange(T val1, T val2) {
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
    
    static <V> void permuterValeurs(Echange<V> e) {
        V getVal1 = e.getVal1();
        e.setVal1(e.getVal2());
        e.setVal2(getVal1);
    }
    
    public static void main(String[] args) {
    /*
        Dans le code ci-dessous, l'utilisation d'un wildcard (?) dans la déclaration Echange<?> p2 = p1; 
        permet de déclarer une variable p2 qui peut faire référence à un objet de type Echange avec n'importe quel type paramétré.
        
        Lorsque vous déclarez Echange<?> p2, vous créez une référence p2 qui peut pointer vers n'importe quel objet de type Echange,
        mais vous ne spécifiez pas le type exact du paramètre générique de cet objet. 
        
        En d'autres termes, vous dites au compilateur : "Je veux une référence qui pointe vers un objet de type Echange, 
        mais je ne me soucie pas du type exact du paramètre générique de cet objet. Cela peut être utile dans des situations où
        vous souhaitez traiter des objets Echange de différents types paramétrés de manière générique, sans avoir besoin 
        de connaître ces types exacts à l'avance. Par exemple, si vous avez besoin d'une méthode qui prend en paramètre 
        des objets Echange de n'importe quel type, vous pouvez utiliser Echange<?> pour cela.

        Dans votre cas, Echange<?> p2 = p1; permet de copier la référence p1 dans p2, où p1 est une instance de Echange<Integer>.
        Cela signifie que p2 peut également faire référence à cette instance. L'utilisation du wildcard (?) dans Echange<?> 
        permet de garantir que p2 peut être utilisé pour faire référence à des objets Echange de tout type paramétré, 
        pas seulement Integer.
        */
        
        /* Dans le contexte où vous essayez de remplacer le wildcard par une variable de type T, vous rencontrez l'erreur 
          de compilation "non-static type variable T cant be referenced from a static context" car T est une variable de 
          type non statique et vous essayez de l'utiliser dans un contexte statique.

        En Java, lors de l'utilisation de classes génériques, les types paramétrés (comme T) sont déterminés au moment de 
        l'instanciation de la classe. Cela signifie que les types génériques ne sont pas accessibles dans un contexte statique, 
        comme dans une méthode main(), à moins que vous ne les spécifiiez explicitement.

        Dans votre exemple, Echange<Integer> p1 = new Echange<Integer>(10, 20); est une instantiation d'une classe générique
        Echange avec un type paramétré Integer. Si vous essayez d'utiliser T à la place de ?, comme ceci :
        
        Echange<Integer> p1 = new Echange<Integer>(10, 20);
        System.out.println("Avant : " + p1.getVal1() + ", " + p1.getVal2());
        Echange<T> p2 = p1; // Erreur de compilation ici
        
        Vous obtiendrez une erreur de compilation car T n'est pas défini dans le contexte statique de la méthode main(). T est une variable de type non statique qui est déclarée au niveau de la classe Echange, donc elle n'est pas accessible dans la méthode main().

        En revanche, lorsque vous utilisez un wildcard (?), vous n'avez pas besoin de spécifier explicitement le type paramétré 
        lors de la déclaration, ce qui évite cette erreur.
        */
        
        Echange<Integer> p1 = new Echange<Integer>(10, 20);
        System.out.println("Avant : " + p1.getVal1() + ", " + p1.getVal2());
        Echange<?> p2 = p1;
        
        
        permuterValeurs(p2);
        System.out.println("Apres : " + p2.getVal1() + ", " + p2.getVal2());
        System.out.println(p2.getVal1().getClass().getName());  //affichera donc Integer 
        
        Echange<Etudiant> e1 = new Echange<Etudiant>(new Etudiant(), new Etudiant());
        System.out.println("Avant : " + e1.getVal1() + ", " + e1.getVal2());
        Echange<?> e2 = e1;
        permuterValeurs(e2);
        System.out.println("Apres : " + e2.getVal1() + ", " + e2.getVal2());
        System.out.println(e2.getVal1().getClass().getName());
    }
}

class Etudiant {}
