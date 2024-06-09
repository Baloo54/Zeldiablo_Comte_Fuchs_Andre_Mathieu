package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;

public abstract class Case extends Element{
    /**
     * constructeur
     * @param dx position selon x
     * @param dy position selon y
     * 
     */
    public Case(int dx, int dy) {
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
     * methode equals
     * @param o
     * @return boolean 
     */
    public boolean equals(Object o){
        boolean res = false;
        if(o instanceof Case){
            Case c = (Case) o;
            res = (this.getX() == c.getX() && this.getY() == c.getY());
        }return res;
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