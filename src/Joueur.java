import java.util.ArrayList;

public class Joueur {
    private String nom;
    private final String code;
    private static int nbJoueur = 0;
    private int nbPoint;
    private ArrayList<Personnage> listePersos;
    public Joueur(String nom)
    {
        nbJoueur++;
        this.nom = nom;
        code = "J"+nbJoueur;
        nbPoint = 0;
        listePersos = new ArrayList<Personnage>();
    }
    public void ajouterPersonnage(Personnage perso)
    {
        listePersos.add(perso);
        perso.setProprietaire(this);
    }
    public void modifierPoint(int nb)
    {
        nbPoint += nb;
        if(nbPoint<0)
            nbPoint = 0;
    }
    public boolean peutJouer()
    {
        boolean retour = false;
        if (listePersos.size()>0)
            retour = true;
        return retour;
    }
    public static int getNbJoueur() {
        return nbJoueur;
    }
    public int getNbPoint() {
        return nbPoint;
    }
    public ArrayList<Personnage> getListePersos() {
        return listePersos;
    }
    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String chaine = code +" "+ nom +  " ("+nbPoint+") aucun personnage";
        if(peutJouer())
            chaine = code +" "+ nom + " ("+nbPoint+") "+" avec "+String.valueOf(listePersos.size())+" personnage(s)";
        return chaine;
    }
}
