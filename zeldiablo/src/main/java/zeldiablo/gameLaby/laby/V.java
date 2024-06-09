package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

public class V extends Case{
    public V(int dx, int dy){
        super(dx, dy);
        setColor(Color.WHITE);
    }
    public void interagir(Labyrinthe l, Entite e){{
        e.setPos(this.getX(), this.getY());
    }}
}
