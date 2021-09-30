public class Humain extends Personnage{

    private int nbDeplacement;
    private int niveau;
    public Humain(String nom,int age)
    {
        super(nom, age);
        nbDeplacement = 0;
        this.niveau = 1;
    }
    @Override
    public void deplacer(int destination, int gain) {
        // TODO Auto-generated method stub
        super.deplacer(destination, gain);
        if(nbDeplacement==4)
            this.niveau++;
        else if(nbDeplacement ==6)
            this.niveau++;
        
    }
    @Override
    public int positionSouhaiter() {
        // TODO Auto-generated method stub
        return position += niveau*nbDeplacement;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
