package zeldiablo.gameLaby.laby.elements;

import zeldiablo.gameLaby.laby.Arme;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

//import javafx.scene.paint.Color;

/**
 * Classe Glaive, c'est un type d'arme
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Glaive extends Arme{
    public Glaive()
    {
        setNom("Glaive");
        setDegats(3);
    }
    public void utiliser(Labyrinthe l, Entite e)
    {
        //Fantome fantome = (F)e;
        //Personnage joueur = (P)e ;
        if(e instanceof Personnage)
        {
            e.PrendreArme(this);
           // l.setCases(new V(e.getX(),e.getY()));
            System.out.println("Le joueur a recupere "+ getNom());
        }
        //if(e != null && e.getArme()!=null && l.verifierProximiteJoueur(joueur,fantome))
        {
            //fantome.subirDegats(super.getDegats());
            //System.out.println("Le fantome subit des degats"+fantome.getPv());
        }
    }
}
