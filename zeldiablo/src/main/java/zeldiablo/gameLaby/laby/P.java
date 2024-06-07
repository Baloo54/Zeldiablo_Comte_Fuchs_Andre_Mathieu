package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * gere un personnage situe en x,y
 */
public class P extends Entite{
    // super constructeur
    public P(int dx, int dy) {
        super(dx, dy);
    }
    /**
     * affiche le personnage
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.RED);
        c.fillOval(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
    /**
     * méthode stocker par polymorphisme
     * permet de stocket l'entite dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        laby.elements[this.getX()][this.getY()] = new V(this.getX(), this.getY());
        // ajout de l'entite dans la liste entites au debut de la liste
        laby.entites.add(0,this);
    }
}
