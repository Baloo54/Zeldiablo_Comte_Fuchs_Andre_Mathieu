package zeldiablo.gameLaby.laby;

import java.io.IOException;
import static zeldiablo.gameLaby.laby.Labyrinthe.BAS;
import static zeldiablo.gameLaby.laby.Labyrinthe.DROITE;
import static zeldiablo.gameLaby.laby.Labyrinthe.GAUCHE;
import static zeldiablo.gameLaby.laby.Labyrinthe.HAUT;
import static zeldiablo.gameLaby.laby.Labyrinthe.ATTAQUE;
import zeldiablo.moteurJeu.Clavier;
import zeldiablo.moteurJeu.Jeu;

public class LabyJeu implements Jeu {

    public int tick;
    private final Labyrinthe labyrinthe;


    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public LabyJeu() throws IOException {
        this.labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/test_labymu.txt");
        tick = 0;
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        if(tick% labyrinthe.deplacementPersoCooldown == 0){
            if (clavier.haut) {
                this.labyrinthe.deplacerPerso(HAUT);
            } else if (clavier.bas) {
                this.labyrinthe.deplacerPerso(BAS);
            } else if (clavier.gauche) {
                this.labyrinthe.deplacerPerso(GAUCHE);
            } else if (clavier.droite) {
                this.labyrinthe.deplacerPerso(DROITE);
            } else if (clavier.attaque) {
                this.labyrinthe.checkAttaquePerso();
            }
        }

        tick++;
    }

    @Override
    public void init() {


    }

    @Override
    public boolean etreFini() {
        return false;
    }

}