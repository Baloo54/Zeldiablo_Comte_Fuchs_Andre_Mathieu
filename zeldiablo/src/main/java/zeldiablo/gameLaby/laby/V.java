package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class V extends Case{
    public V(int dx, int dy){
        super(dx, dy);
    }
    public void interagir(Labyrinthe l, Entite e){{
        e.setPos(this.getX(), this.getY());
    }}
    /**
     * affiche la case vide
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.WHITE);
        c.fillRect(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
}
