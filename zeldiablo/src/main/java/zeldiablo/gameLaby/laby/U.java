package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class U extends Case{
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public U(int dx, int dy){
        super(dx, dy);
    }
    public void interagir(Labyrinthe l, Entite p){
        l.etageCourant++;
        l.elements = l.etages[l.etageCourant];
    }
    /**
     * à toi le reuf de définir comment afficher la case
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.BLACK);
        c.fillRect(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
}
