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
public class Case_Vide extends Case{
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public Case_Vide(int dx, int dy) throws Exception{
        super(dx, dy);
        setColor(Color.WHITE);
        setNom("Vide");
        getData();
    }
    /**
     * méthode pour stocker la case dans le labyrinthe
     * et donner un effet au joueur
     * @param l
     * @param e
     */
    public void interagir(Labyrinthe l, Entite e){{
        e.setPos(this.getX(), this.getY());
    }}
}
