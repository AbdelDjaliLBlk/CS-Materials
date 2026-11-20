class NainGuerrier extends Nain implements Guerrier {    
    int force;    
    NainGuerrier(String nom, int x, int y, int force) {    
        super(nom, x, y);
        this.force = force;
    }

    public void attaque(Personnage p) { 
        if ((p.pointsVie >0) && (pointsVie>0))
            p.pointsVie =p.pointsVie-this.force;
    }    
    public int getForce() { return this.force; }    
}


