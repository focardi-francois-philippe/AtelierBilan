public class Case {
    private int gain;
    private Personnage perso = null;
    private Obstacle obs = null;
    public Case(Obstacle obs,int gain)
    {
        this(gain);
        this.obs = obs;
    }
    public Case(int gain)
    {
        this.gain = gain;
    }
    public int getPenalite()
    {
        int retour = 0;
        if(obs != null)
            retour = obs.getPenalite();
        return retour;
    }
    public int getGain() {
        return gain;
    }
    public void placerPersonnage(Personnage perso)
    {
        if(perso!=null)
        {
            this.perso = perso;
        }
    }
    public void placerObstacle(Obstacle obs)
    {
        if(obs!=null)
        {
            this.obs = obs;
        }
    }
    public void enleverPersonnage()
    {
        this.perso = null;
    }
    public boolean estLibre()
    {
        return perso == null && obs == null;
    }
    public boolean sansObstacle()
    {
        return obs == null;
    }
    public boolean sansPerso()
    {
        return perso == null;
    }
    @Override
    public String toString() {
        String chaine = "Libre " + "( gain = "+gain+") ";
        if(!sansObstacle())
            chaine = "Obstacle" + "( penalite = "+String.valueOf(gain*-1)+") ";
        else if(!sansPerso())
            chaine =perso.toString() + "( penalite = "+String.valueOf(gain*-1)+" ) ";
        return chaine +"\n";
    }
   
}
