package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class T extends Case{
    public T(int dx, int dy){
        super(dx, dy);
    }
    public void interagir(Labyrinthe l, Entite e){
        e.subirDegats(1);
        e.setPos(this.getX(), this.getY());
    }
    /**
     * affiche le piège
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.GRAY);
        c.fillRect(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
}
