package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import zeldiablo.gameLaby.laby.elements.Case_Vide;

public abstract class Entite extends Element{
    /**
     * attribut vie
     */
    private int pv;
    private int force;
    private Arme arme;
    private String direction;
    /**
     * super constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Entite(int dx, int dy) throws Exception{
        super(dx, dy);   
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
        try {
            laby.getCases().get(laby.getEtage()).add(new Case_Vide(this.getX(), this.getY()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        laby.getEntites().get(laby.getEtage()).add(this);
    }
    /**
     * méthode attaquer
     * permet d'attaquer une entite
     * @param e
     */
    public void attaquer(Entite e){
        int degats = this.force;
        if (this.arme != null) {
            degats += this.arme.getDegats();
        }
        e.subirDegats(degats);
        System.out.println("degats infligés : " + degats);
        System.out.println(e + " pv restants : " + e.getPv());
    }
    /**
     * permet de prendre une arme
     * @param arme
     */
    public void PrendreArme(Arme arme)
    {
        this.arme=arme;
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
     * affiche l'entite
     * @param c canvas
     * @param tileWidth largeur de la case
     * @param tileHeight hauteur de la case
     */
    /*public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.setFill(getColor());
        c.fillOval(getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    }*/
    /**
     * getter direction
     * @return direction
     */
    public String getDirection() {
        return direction;
    }
    /**
     * setter direction
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
