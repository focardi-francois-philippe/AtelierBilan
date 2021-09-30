public class TestJeu {
    public static void main(String[] args) throws Exception {
        Jeu jeu1 = new Jeu("AtelierPOO", 4,10);
        Joueur joueur1 = new Joueur("Paul");
        Joueur joueur2 = new Joueur("Lucien");
        Tauren t1 = new Tauren("Hector", 15, 10);
        Tauren t2 = new Tauren("Hercule", 20, 5);
        Humain h1 = new Humain("Jean", 10);
        Humain h2 = new Humain("Marie", 10);

        joueur1.ajouterPersonnage(t1);
        joueur1.ajouterPersonnage(h1);
        joueur2.ajouterPersonnage(t2);
        joueur2.ajouterPersonnage(h2);
        jeu1.ajouterJoueur(joueur1);
        jeu1.ajouterJoueur(joueur2);
        jeu1.lancerJeu();
        jeu1.afficherCases();
        jeu1.afficherResultats();
    }
}
