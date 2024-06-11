package zeldiablo.gameLaby.laby;

import java.io.IOException;
import static zeldiablo.gameLaby.laby.Labyrinthe.BAS;
import static zeldiablo.gameLaby.laby.Labyrinthe.DROITE;
import static zeldiablo.gameLaby.laby.Labyrinthe.GAUCHE;
import static zeldiablo.gameLaby.laby.Labyrinthe.HAUT;
import zeldiablo.moteurJeu.Clavier;
import zeldiablo.moteurJeu.Jeu;

/**
 * Classe LabyJeu
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class LabyJeu implements Jeu {
    private Labyrinthe labyrinthe;

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public LabyJeu() throws IOException {
        this.labyrinthe = new Labyrinthe(3);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.haut) {
            this.labyrinthe.deplacerPerso(HAUT);
        } else if (clavier.bas) {
            this.labyrinthe.deplacerPerso(BAS);
        } else if (clavier.gauche) {
            this.labyrinthe.deplacerPerso(GAUCHE);
        } else if (clavier.droite) {
            this.labyrinthe.deplacerPerso(DROITE);
        }
        else if(labyrinthe.getPerso().getPv()<=0)
        {
            System.out.println("Defaite ! Le joueur est mort ");
            labyrinthe.finir();
        }
        else if(clavier.attaquer)
        {
            this.labyrinthe.attaquerJoueur();
        }
        this.labyrinthe.deplacerEntites();
        this.labyrinthe.attaquer();
        this.labyrinthe.mortEntites();        
        this.labyrinthe.tick++;

    }

    @Override
    public void init(){};

    @Override
    public boolean etreFini() {
        return labyrinthe.etreFini();
    }
}