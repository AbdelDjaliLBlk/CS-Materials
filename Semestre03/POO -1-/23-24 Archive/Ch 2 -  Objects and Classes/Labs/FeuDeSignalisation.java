public class FeuDeSignalisation {
    public boolean isOn;
    public String color;
    public static double HEIGHT = 4.56;
    public FeuDeSignalisation () {
        this("Rouge");

    }

    public FeuDeSignalisation (String color) {
        setColor(color);
        this.isOn = true;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void afficher() {
        System.out.println("Couleur : " + color + " , height : " + HEIGHT + " , is ON : " + isOn);
    }
    public double getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(double height) {
        HEIGHT = height;
    }

    public void switchLight() {
        isOn = !isOn;
    }

    public void switchColor() {
        if (color == "Rouge") setColor("Orange");
        else if (color == "Orange") setColor("Vert");
        else if (color == "Vert") setColor("Rouge");
        else setColor("Rouge");
    }

    public void flash(int duration, boolean isSwitchingColors, int wholeProcessDurationLength) {
        System.out.println("Here starts the flash process.");
        for ( int i = 0 ; i < wholeProcessDurationLength ; i++ ) {
            for ( int j = 0 ; j < 2 ; j++ ) {
                try {
                    Thread.currentThread().sleep(duration * 500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if ((isSwitchingColors)&&(!isOn)) switchColor();
                switchLight();
                afficher();
            }
        }
    }

    public void flash(int duration) {
        flash(duration, true, 5);
    }

    public void flash(int duration, int wholeProcessDurationLength) {
        flash(duration, false, wholeProcessDurationLength);
    }
}
