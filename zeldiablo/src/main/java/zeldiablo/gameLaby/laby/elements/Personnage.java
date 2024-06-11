package zeldiablo.gameLaby.laby.elements;

import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

/**
 * Personnage
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Personnage extends Entite{
    // super constructeur
    public Personnage(int dx, int dy) throws Exception{
        super(dx, dy);
        setColor(Color.RED);
        setNom("Personnage");
        getData();
    }
    /**
     * méthode stocker par polymorphisme
     * permet de stocket l'entite dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        try {
            laby.getCases().get(laby.getEtage()).add(new Case_Vide(this.getX(), this.getY()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ajout de perso dans pj
        laby.setPj(this);
    }
}
