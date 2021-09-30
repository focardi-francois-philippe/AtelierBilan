import java.util.ArrayList;
import java.util.Random;

public class Jeu {
    private String titre;
    private final int NBJOUEURMAX = 6;
    private final int NBRCASES = 50;
    private ArrayList<Joueur> listeJoueurs;
    private Case[] cases;
    private int nbEtapes;
    private int nbObstacles;
    private int scoreMax;

    public Jeu(String titre,int nbEtapes,int nbObstacles)
    {
        this.titre = titre;
        this.nbEtapes = nbEtapes;
        this.nbObstacles = nbObstacles;
        listeJoueurs = new ArrayList<Joueur>();
        cases = new Case[50];
    }
    public void ajouterJoueur(Joueur j)
    {
        listeJoueurs.add(j);
    }
    public ArrayList<Personnage> tousLesPersos()
    {
        ArrayList<Personnage> persoRetour = new ArrayList<Personnage>();
        for(Joueur j : listeJoueurs)
        {
            for(Personnage p : j.getListePersos())
            {
                persoRetour.add(p);
            }
        }
        return persoRetour;
    }
    public void initialiserCases()
    {
        Random rand = new Random();
        int nombreAlea =0;
        int compteurObstacle = 0;
        for(int i=0;i<NBRCASES;i++)
        {
            nombreAlea = rand.nextInt(NBRCASES);
            if(nombreAlea %5==0)
            {
                if(compteurObstacle < nbObstacles)
                {
                    Obstacle o = new Obstacle(nombreAlea*2*-1);
                    cases[i] = new Case(o,o.getPenalite());
                    compteurObstacle++;
                }
                else
                    cases[i] = new Case(nombreAlea);
            }
            else
                cases[i] = new Case(nombreAlea);
        }
    }
    public void lancerJeu()
    {
        initialiserCases();
        ArrayList<Personnage> personnages = tousLesPersos();
        int compteurCase = 0;
        int nbrJoueur = personnages.size();
        boolean flag = false;
        int positionVoulu=0;
        for(int i =0;i<nbrJoueur;i++)
        {
            flag = true;
            while(flag) // tant que personnage pas placer 
            {
                if(cases[compteurCase].estLibre())
                {
                    flag = false;
                    cases[compteurCase].placerPersonnage(personnages.get(i));
                }
                compteurCase++;
            }
        }
        for(int i =0;i<nbEtapes;i++)
        {
            for (Personnage personnage : personnages) {
                positionVoulu = personnage.positionSouhaiter();
                if(positionVoulu>50)
                {
                    positionVoulu = 49;
                    while(!cases[positionVoulu].estLibre())
                        positionVoulu--;
                }
                if(cases[positionVoulu].estLibre())
                {
                    personnage.deplacer(positionVoulu, cases[positionVoulu].getGain());
                }
                else if(!cases[positionVoulu].sansObstacle())
                {
                    personnage.penaliser(cases[positionVoulu].getPenalite());
                }
                else
                {
                    personnage.penaliser(cases[positionVoulu].getGain());
                }
            }
        }
        afficherCases();
    }
    public void afficherCases()
    {
        for(int i =0;i<this.NBRCASES;i++)
        {
            System.out.println(cases[i]);
        }
    }
    public void afficherParticipants()
    {
        System.out.println("LISTE DES JOUEURS");
        for(Joueur j : listeJoueurs)
        {
            System.out.println("--------------------------------");
            System.out.println(j);
        }
    }
    public void afficherResultats()
    {
        Joueur premierJoueur = listeJoueurs.get(0);
        for(Joueur j : listeJoueurs)
        {
            if(premierJoueur.getNbPoint() < j.getNbPoint())
                premierJoueur = j;
        }
        afficherParticipants();
        System.out.println("RESULTATS");
        System.out.println("Le gagnant est "+premierJoueur.getNom() + " avec " + String.valueOf(premierJoueur.getNbPoint()));
        if(scoreMax < premierJoueur.getNbPoint())
        {
            System.out.println("RECORD BATTU : le record etait de "+scoreMax);
            scoreMax = premierJoueur.getNbPoint();
        }
           
        
    }
}