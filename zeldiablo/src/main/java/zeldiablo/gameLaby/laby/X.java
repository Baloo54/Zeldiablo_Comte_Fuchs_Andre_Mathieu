package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class X extends Case{
    public X(int dx, int dy){
        super(dx, dy);
    }
    /**
     * affiche la case vide
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.BLACK);
        c.fillRect(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
    /**
     * interagir avec la case
     */
    public void interagir(Labyrinthe l, Entite e){
        //rien
    }
}