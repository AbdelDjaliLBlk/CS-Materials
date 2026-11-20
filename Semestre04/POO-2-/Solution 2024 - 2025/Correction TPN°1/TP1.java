import javax.swing.text.AsyncBoxView;

class Person{
    String name;
    int Chd_num;
    Person(){
        this("Sans nom",0);
    }
    Person(String name, int Chd_num){
        this.Chd_num = Chd_num;
        this.name = name;
    }
    public String toString(){
        return "Nom : "+name+". Nombre d'enfants: "+Chd_num+" .";
    }
    void Afficher(){
        System.out.println(toString());
    }
    void setName(String name){
        this.name = name;
    }
    void setChd_num(int Chd_num){
        this.Chd_num = Chd_num;
    }

}

class Salarie extends Person{
    double salaire;
    static double af = 300;   //Allocation familiale.

    Salarie(String name ,double salaire){
        super(name,0);
        this.salaire = salaire;
    }

    Salarie(String name,int Chd_num , double salaire ){
        super(name,Chd_num);
        this.salaire = salaire;
    }
    static void Modifier_Af(int new_af){
        af =new_af;
    }
    double primeAf(){
        return Chd_num * af;
    }

   public String toString(){
    return  super.toString() + " Prime : "+primeAf()+"DA. Salaire : "+salaire+" DA.";
    }

     void Afficher(){
        System.out.println(this.toString());
    }
    void modifier(String name, int Chd_num){
        this.name = name;
        this.Chd_num = Chd_num;

    }

}

class Entreprise {
     String name;
    static int capacite = 100;
    static int Num_Sal = 0;
     Salarie [] salaries = new Salarie[capacite];

    Entreprise(String name){
        this.name = name;
    }
     void Ajouter(Salarie s){
       if(Num_Sal == capacite){
           System.out.println("You can't add more.");
       }
       else {
           salaries[Num_Sal] = s;
       }
       Num_Sal ++;
    }
    void AfficherSalaries(){
        System.out.println("\nSalaries de "+name + ": ");
        for(int i = 0 ; i < Num_Sal ; i++)
            salaries[i].Afficher();
    }

    double SommeSalairePrime(){
        double sum = 0;
        for(int i = 0 ; i < Num_Sal ; i++)
        sum += salaries[i].salaire + salaries[i].primeAf();
    return sum;
    }

    void SalarieMinEnfants(int min_enf){
        boolean state = false;
        System.out.println("Salaries avec plus de "+min_enf+" sont :");
        for(int i = 0 ; i< Num_Sal ; i++){
            if(salaries[i].Chd_num >= min_enf){
                salaries[i].Afficher();
                state = true;
            }
        }
        if(state == false){
            System.out.println("Aucun !!");
        }
    }

    Salarie RechercherSalarie(String name){
        for(int i = 0 ; i< Num_Sal ; i++){
        if(salaries[i].name == name){
            return salaries[i];
        }
        }
        return new Salarie("Sans nom",0);
    }

}
public class TP1{
    public static void main(String[] args){
        //Salarie1
        Salarie salarie = new Salarie("Mohammed",30000);
        salarie.Afficher();
        System.out.println("Af = "+salarie.primeAf());

        //Modifier Af
        //Salarie.Modifier_Af(450);

        System.out.println("Apres modification: ");
        salarie.modifier("Amine",4);
        salarie.Afficher();
        System.out.println("Af = "+salarie.primeAf());

        //Salarie2
        Salarie salarie1 = new Salarie("Ahmed", 2 , 45000);
        salarie1.Afficher();
        System.out.println("Af = "+salarie1.primeAf());

        //Creer Personne
        Person person = new Person();
        person.Afficher();
        Person person1 = new Person("Oussama",1);
        person1.Afficher();

        //Creer salarie declare avec person
        Person person2 = new Salarie("Ilyes",50000);
        System.out.println("\nSalarie declare avec Person :");
        person2.Afficher();

        //Tableau des salaries
        Person [] arr = {person,person1,person2,salarie,salarie1};
        System.out.println("\nTous les salaries : ");
        for(Person x : arr){
        if(x instanceof Salarie)
            x.Afficher();
        }

        System.out.println("\nToutes les personnes : ");
        for(Person x : arr){
            if(x instanceof Person)
                x.Afficher();
        }

        //Entreprise.
        Entreprise entreprise = new Entreprise("EST Company");
        entreprise.Ajouter(salarie);
        entreprise.Ajouter(salarie1);
        entreprise.Ajouter(new Salarie("Islem",3,60000));
        entreprise.AfficherSalaries();
        System.out.println("Sommes des salaires et des primes : "+entreprise.SommeSalairePrime());
        entreprise.SalarieMinEnfants(5);
        System.out.println("Recherche par Nom : ");
        entreprise.RechercherSalarie("Islem").Afficher();
        entreprise.RechercherSalarie("Ayoub").Afficher();
        //Dans ce cas le programme va simplement retourner puis afficher un salarie sans nom et sans salaire.

    }
}