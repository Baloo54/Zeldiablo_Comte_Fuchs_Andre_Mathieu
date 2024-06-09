package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

public class T extends Case{
    public T(int dx, int dy){
        super(dx, dy);
        setColor(Color.YELLOW);
    }
    public void interagir(Labyrinthe l, Entite e){
        e.subirDegats(1);
        System.out.println("l'entité a nb vie : "+e.getPv());
        e.setPos(this.getX(), this.getY());
    }
}
