import java.awt.*;
class TestList {
    static public void main (String arg [ ]) {
        Frame frame = new Frame("Une liste");
        List list = new List(5,true);
        list.add("element 0");
        list.add("element 1");
        list.add("element 2");
        list.add("element 3");
        list.add("element 4");
        frame.add(list);
        frame.pack();
        frame.show();
    }
}