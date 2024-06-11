package zeldiablo.gameLaby.laby.elements;

import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;
import zeldiablo.gameLaby.laby.Arme;



/**
 * Case arme
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Arme extends Case
{
    private Arme arme;
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public Case_Arme(int dx, int dy)
    {
        super(dx,dy);
    }

    /**
     * méthode pour stocker la case dans le labyrinthe
     * et donner un effet au joueur
     * @param l labyrinthe
     * @param e entite
     */
    public void interagir(Labyrinthe l, Entite e)
    {

        if(!(e instanceof Fantome))
        {
            e.PrendreArme(e.getArme());
            try{
                l.setCases(new Case_Vide(getX(),getY()));
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setArme(Arme a)
    {
        this.arme=a;
    }

}
