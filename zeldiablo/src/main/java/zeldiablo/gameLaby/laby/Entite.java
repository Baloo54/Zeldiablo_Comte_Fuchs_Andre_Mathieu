package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entite extends Element{
    /**
     * attribut vie
     */
    private int pv = 3;
    private int force;
    private Arme arme;
    private String nom;
    /**
     * super constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Entite(int dx, int dy) {
        super(dx, dy);   
    }
    /**
     * permet de savoir si le l'entite est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le l'entite est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.getX() == dx && this.getY() == dy);
    }
    public void subirDegats(int i){
        this.pv-=i;
    }
    /**
     * méthode stocker
     * permet de stocket l'entite dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        laby.getCases().get(laby.getEtage()).add(new V(this.getX(), this.getY()));
        laby.getEntites().get(laby.getEtage()).add(this);
    }
    /**
     * méthode attaquer
     * permet d'attaquer une entite
     * @param e
     */
    public void attaquer(Entite e){e.subirDegats(this.force);}
    /**
     * à définir poto jsuis pas devin
     * @param arme
     */
    public void PrendreArme(Arme arme) {

    }
    /**
     * getter force
     * @return force
     */
    public int getForce(){return this.force;}
    /**
     * getter arme
     * @return arme
     */
    public Arme getArme(){return this.arme;}
    /**
     * getter pv
     * @return pv
     */
    public int getPv(){return pv;}
    /**
     * getter nom
     * @return nom
     */
    public String getNom(){return nom;}
    /**
     * setPv
     * @param pv
     */
    public void setPv(int pv){this.pv = pv;}
    /**
     * setForce
     * @param force
     */
    public void setForce(int force){this.force = force;}
    /**
     * setNom
     * @param nom
     */
    public void setNom(String nom){this.nom = nom;}
    /**
     * affiche l'entite
     * @param c canvas
     * @param tileWidth largeur de la case
     * @param tileHeight hauteur de la case
     */
    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.setFill(getColor());
        c.fillOval(getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    }
}
