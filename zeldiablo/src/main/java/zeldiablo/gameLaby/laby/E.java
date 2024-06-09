package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;
public class E extends Case{
    /**
     * super constructeur
     * @param x
     * @param y
     */
    public E(int x, int y) {
        super(x, y);
        setColor(Color.PURPLE);
    }
    public void interagir(Labyrinthe l, Entite e){
        System.out.println(""+e+" a subi un effet !");
        e.setPos(this.getX(), this.getY());
    }
}
