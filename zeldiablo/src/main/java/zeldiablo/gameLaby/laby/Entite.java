package zeldiablo.gameLaby.laby;

/**
 * Interface Entite représentant les entités du jeu (perso, monstre, etc.)
 */

public interface Entite {

    void attaquer(Entite e);
    void subirDegats(int i);
    String getNom();
    int getPv();
    int getForce();
    Arme getArme();
    void PrendreArme(Arme arme);
    boolean etrePresent(int dx, int dy);

    int getX();

    int getY();

}
