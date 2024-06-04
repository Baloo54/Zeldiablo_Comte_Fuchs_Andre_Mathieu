package zeldiablo.gameLaby.laby;

/**
 * gere un personnage situe en x,y
 */
public class Perso implements Entite {

    /**
     * position du personnage
     */

    int pv = 3; //valeur de base
    String nom;
    int force;
    Arme arme;
    int x, y;
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    public void subirDegats(int i){
        this.pv-=i;
    }

    public void attaquer(Entite e){
        e.subirDegats(this.force);
    }


    public void PrendreArme(Arme arme) {

    }


    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }

    public int getPv(){
        return this.pv;
    }

    public int getForce(){
        return this.force;
    }

    public Arme getArme(){
        return this.arme;
    }

    public String getNom(){
        return this.nom;
    }
}
