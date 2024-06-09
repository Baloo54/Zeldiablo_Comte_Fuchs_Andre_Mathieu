package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * gere un personnage situe en x,y
 */
public class P extends Entite{
    // super constructeur
    public P(int dx, int dy) {
        super(dx, dy);
        setColor(Color.RED);
    }
    /**
     * méthode stocker par polymorphisme
     * permet de stocket l'entite dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        laby.getCases().get(laby.getEtage()).add(new V(this.getX(), this.getY()));
        // ajout de perso dans pj
        laby.setPj(this);
    }
}
