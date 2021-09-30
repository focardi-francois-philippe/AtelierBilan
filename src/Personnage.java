abstract public class Personnage {
    protected String nom;
    protected int age;
    protected int position;
    private Joueur proprietaire;

    protected Personnage(String nom,int age)
    {
        this.nom = nom;
        this.age = age;
    }
    public void deplacer(int destination,int gain)
    {
        position +=destination;
        proprietaire.modifierPoint(gain);
    }
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void penaliser(int penalite)
    {
        if(penalite>0)
            penalite = penalite*-1;
        proprietaire.modifierPoint(penalite);
    }
    public abstract int positionSouhaiter();
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nom;
    }
}
