package zeldiablo.gameLaby.laby;

import java.io.IOException;
import static zeldiablo.gameLaby.laby.Labyrinthe.BAS;
import static zeldiablo.gameLaby.laby.Labyrinthe.DROITE;
import static zeldiablo.gameLaby.laby.Labyrinthe.GAUCHE;
import static zeldiablo.gameLaby.laby.Labyrinthe.HAUT;
import zeldiablo.moteurJeu.Clavier;
import zeldiablo.moteurJeu.Jeu;

public class LabyJeu implements Jeu {
    private Labyrinthe labyrinthe;

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }

    public LabyJeu() throws IOException {
        this.labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/test_labymultefjkscqdnklqzdzk.txt");
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
    }

    @Override
    public void init(){};

    @Override
    public boolean etreFini() {
        return false;
    }
    /**
     * méthode permettant de choisir le niveau
     * @param niveau le niveau choisi
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void choisirNiveau(int niveau) throws IOException{
        try {
            this.labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby" + niveau + ".txt");
        } catch (IOException e) {
            this.labyrinthe = new Labyrinthe(Labyrinthe.DEFAULT_MAP);
        }
    }
}