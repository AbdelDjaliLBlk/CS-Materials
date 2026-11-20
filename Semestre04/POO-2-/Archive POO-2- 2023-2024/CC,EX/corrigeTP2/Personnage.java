abstract class Personnage {    

    String nom;    
    int pointsVie;
    double x, y, vitesse;

    Personnage(String n, double x, double y, double v) {    
        this.nom = n; 
        this.x = x; this.y = y;
        this.pointsVie = 100;
        this.vitesse = v;
    }    

    void seDeplacer(double dx, double dy, double t) {
        this.x = this.x + dx*this.vitesse*t/Math.sqrt(dx*dx+dy*dy);
        this.y = this.y + dy*this.vitesse*t/Math.sqrt(dx*dx+dy*dy);
    }

    abstract String parler();    
}
