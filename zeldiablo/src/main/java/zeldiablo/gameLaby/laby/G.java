package zeldiablo.gameLaby.laby;

import javafx.scene.paint.Color;

/**
 * Classe G pour Glaive, c'est un type d'arme
 */
public class G extends Arme
{

    public G(String nom, int degats)
    {
        super(nom, degats);
        //setColor(Color.BLUE);
    }

    public void interagir(Labyrinthe l, Entite e)
    {

        F fantome = (F)e;
        P joueur = (P)e ;



        if(e instanceof P)
        {
            e.PrendreArme(this);
            l.setCases(new V(e.getX(),e.getY()));
            System.out.println("Le joueur a recupere "+super.getNom());
        }

        if(e != null && e.getArme()!=null && l.verifierProximiteJoueur(joueur,fantome))
        {
            fantome.subirDegats(super.getDegats());
            System.out.println("Le fantome subit des degats"+fantome.getPv());
        }
    }

}
