package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

public class X extends Case{
    public X(int dx, int dy){
        super(dx, dy);
        setColor(Color.BLACK);
    }
    /**
     * interagir avec la case
     */
    public void interagir(Labyrinthe l, Entite e){
        //rien
    }
}