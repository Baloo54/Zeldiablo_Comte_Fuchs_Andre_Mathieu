package zeldiablo.gameLaby.laby.elements;

import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Arme;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

/**
 * Fantome
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public  class Fantome extends Entite{
    public Fantome(int x, int y) throws Exception{
        super(x, y);
        setNom("Fantome");
        setPv(10);
        setForce(2);
        setColor(Color.LIGHTSKYBLUE);
        getData();
    }
    public void PrendreArme(Arme arme) {

    }
    /**
     * Pour le coup faut qu'on redefinisse cette méthode ensemble et qui par ailleur ira dans Entite
     */
    public void interagir(Labyrinthe l, Entite p) {
        {
            System.out.println(p +" s'est fait attaquer par un Fantome !");
        }
        this.attaquer(p);
    }
}