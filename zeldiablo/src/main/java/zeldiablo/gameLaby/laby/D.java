package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

public class D extends Case{
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public D(int dx, int dy){
        super(dx, dy);
        setColor(Color.DARKGRAY);
    }
    public void interagir(Labyrinthe l, Entite p){
        //si c'est un personnage car on ne veut pas que les monstres puissent changer les étages du labyrinthe
        if(p instanceof P){l.setEtagesPerso(l.getEtagesPerso()-1);}
        p.setPos(this.getX(), this.getY());
    }
}
