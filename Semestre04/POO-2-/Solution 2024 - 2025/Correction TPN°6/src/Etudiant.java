public class Etudiant {
    String nom;
    public Etudiant(String nom){
        this.nom = nom;
    }

    public int chercherEtudiant(Etudiant []etudiants , Etudiant e){
        if(etudiants == null)
            return -1;

        for(Etudiant x : etudiants)
            if(x.nom == e.nom)
                return 1;
        return -1;
    }
}
