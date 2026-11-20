import java.util.ArrayList;
import java.util.List;

public class Library <T extends  Media>{
    private ArrayList<T> elements = new ArrayList<>();
    public void addMedia (T  media){
        elements.add(media);
    }

    public T  retrieveLast (){
        if(elements.size() < 0 )
            throw new NullPointerException("Library empty");
        return elements.get(elements.size() - 1);
    }
    public ArrayList<T> getElements() {
        return elements;
    }

    public void printLibrary(){
        System.out.println("--> Library : ");
        for(T x  : elements){
            x.afficher();
        }
    }
}
