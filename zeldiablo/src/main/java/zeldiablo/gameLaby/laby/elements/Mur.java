package zeldiablo.gameLaby.laby.elements;

import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

/**
 * Case vide
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public class Mur extends Case{
    public Mur(int dx, int dy) throws Exception{
        super(dx, dy);
        setColor(Color.BLACK);
        setNom("Mur");
        getData();
    }
/**
 * méthode pour stocker la case dans le labyrinthe
 * le fantome peut se déplacer à travers les murs
 * @param l
 * @param e
 */
public void interagir(Labyrinthe l, Entite e){
    if(e instanceof Fantome){
        e.setPos(this.getX(), this.getY());
    }
}
}