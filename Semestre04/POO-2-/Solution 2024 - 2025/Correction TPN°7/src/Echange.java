public class Echange <T> {
    private T v1, v2;
    public Echange(T v1 , T v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    public T getV1(){
        return v1;
    }
    public T getV2() {
        return v2;
    }
    public  <V> void permuterValeurs(Echange <V> e) {
        V tmp = e.v2;
        e.v2 = e.v1;
        e.v1= tmp;
    }
    public static void main (String[] args){

    Echange <Number> e1 = new Echange<>(13, 4);
    Echange <String> e2 = new Echange<>("A" , "Z");

        System.out.println("V1 : "+e1.getV1()+". V2 : "+ e1.getV2()+".");
        e1.permuterValeurs(e2);
        System.out.println("e2 : v1 = "+e2.getV1() +". v2 = "+e2.getV2()+".");

    }
}
