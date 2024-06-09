package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

public  class F extends Entite{
    public F(int x, int y) {
        super(x, y);
        setNom("Fantome");
        setPv(10);
        setForce(2);
        setColor(Color.LIGHTSKYBLUE);
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
}