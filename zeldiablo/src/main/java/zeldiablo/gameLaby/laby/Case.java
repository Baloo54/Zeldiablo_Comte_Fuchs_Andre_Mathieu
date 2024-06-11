package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;

/**
 * classe abstraite Case
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public abstract class Case extends Element {
    /**
     * constructeur
     * @param dx position selon x
     * @param dy position selon y
     * 
     */
    public Case(int dx, int dy) throws Exception{
        super(dx, dy);
    }
    /**
     * permet d'interagir avec une entite
     * @param l labyrinthe
     * @param e entite
     */
    public abstract void interagir(Labyrinthe l, Entite e);
    /**
     * methode stocker dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        laby.getCases().get(laby.getEtage()).add(this);
    }
    /**
     * affiche la case
     * @param c canvas
     */
    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.setFill(getColor());
        c.fillRect(getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    }
}