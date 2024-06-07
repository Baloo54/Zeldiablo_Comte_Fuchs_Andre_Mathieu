package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public  class Fantome extends Entite{
    public Fantome(int x, int y) {
        super(x, y);
        setNom("Fantome");
        setPv(10);
        setForce(2);
    }
    public void PrendreArme(Arme arme) {

    }
    /**
     * Pour le coup faut qu'on redefinisse cette méthode ensemble et qui par ailleur ira dans Entite
     */
    public void interagir(Labyrinthe l, Entite p) {
        {
            System.out.println(""+p+" s'est fait attaquer par un Fantome !");
        }
        this.attaquer(p);
    }
    /**
     * à toi le reuf de définir cette méthode: c'est comment tu veux que ton entité soit affichée
     * @param c canvas
     */
    public void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight){
        c.setFill(Color.RED);
        c.fillOval(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
    }
}