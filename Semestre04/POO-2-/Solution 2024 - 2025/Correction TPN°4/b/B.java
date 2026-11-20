package b;
import a.*;
public class B extends A implements I{
    public B(int a){
        super(a);
    }
    @Override
    public void afficher(){
        System.out.println("a = "+getA());
    }
}

