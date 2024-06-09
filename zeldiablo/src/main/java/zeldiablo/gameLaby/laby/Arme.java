package zeldiablo.gameLaby.laby;

/**
 * Classe Arme représentant les armes du jeu
 */
public class Arme {

    // attributs de l'arme
    String nom;
    int degats;

    // constructeur
    public Arme(String nom, int degats) {
        this.nom = nom;
        this.degats = degats;
    }
    // getters
    public String getNom() {
        return nom;
    }
    public int getDegats() {
        return degats;
    }


}
