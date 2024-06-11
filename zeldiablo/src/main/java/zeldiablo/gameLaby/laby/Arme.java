package zeldiablo.gameLaby.laby;

/**
 * Classe Arme représentant les armes du jeu
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public abstract class Arme {
    // attributs de l'arme
    private String nom;
    private int degats;
    private int portee;
    /**
     * setter
     * @param nom
     */
    public void setNom(String nom) {this.nom = nom;}
    /**
     * setter
     * @param degats
    */
    public void setDegats(int degats) {this.degats = degats;}
    /**
     * getter 
     * @return nom
     */
    public String getNom() {return nom;}
    /**
     * getter
     * @return degats
     */
    public int getDegats() {return degats;}
    /**
     * getter
     * @return portee
     */
    public int getPortee() {return portee;}
    /**
     * setter
     * @param portee
     */
    public void setPortee(int portee) {this.portee = portee;}
}
