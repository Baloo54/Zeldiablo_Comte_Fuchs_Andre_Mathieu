package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class E extends Case{
    /**
     * super constructeur
     * @param x
     * @param y
     */
    public E(int x, int y) {
        super(x, y);
    }
    public void interagir(Labyrinthe l, Entite p){
        System.out.println(""+p+" a subi un effet !");
    }
    /**
     * à toi le reuf de définir cette méthode: c'est comment tu veux que ton entité soit affichée
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.WHITE);
        c.fillRect(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
}
