public class Main {
    public static void main (String[] args) {
        FeuDeSignalisation feu1, feu2;
        feu1 = new FeuDeSignalisation();
        feu2 = new FeuDeSignalisation("Vert");
        feu1.color = "Orange";
        feu2.setColor("Orange");
        System.out.println(feu1.HEIGHT);
        System.out.println(feu2.getHEIGHT());
        feu1.HEIGHT = 3.99;
        feu2.setHEIGHT(7.99);
        feu1.flash(3);
        feu1.flash(5, 8);
        feu1.flash(7, true, 10);
    }
}