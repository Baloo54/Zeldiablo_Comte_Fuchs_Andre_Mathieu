package zeldiablo.gameLaby.laby.elements;

import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

public class Case_Victoire extends Case {
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Case_Victoire(int dx, int dy) throws Exception {
        super(dx, dy);
        setNom("CaseVictoire");
        setColor(Color.GOLD);
    }

    /**
     * permet d'interagir avec une entite
     *
     * @param l labyrinthe
     * @param e entite
     */
    @Override
    public void interagir(Labyrinthe l, Entite e)
    {
        if(e instanceof Personnage)
        {
            System.out.println("Victoire du joueur!");
            l.finir();
        }
    }
}
