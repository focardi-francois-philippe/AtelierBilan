import java.util.Random;

public class Tauren extends Personnage{
    private int taille; //Metre

    public Tauren(String nom,int age,int taille)
    {
        super(nom, age);
        this.taille = taille;
    }
    @Override
    public int positionSouhaiter() {
        // TODO Auto-generated method stub
        position += new Random().nextInt(taille)+1;
        return position;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getClass().getName()+" "+super.toString();
    }
}
