package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import zeldiablo.moteurJeu.*;

public class LabyDessin implements DessinJeu {
    /**
     * affichage d'un jeu de type labirynthe
     *
     * @param canvas dessin dans lequel dessin
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Labyrinthe labyrinthe = laby.getLabyrinthe();

        double tileWidth = canvas.getWidth()/labyrinthe.getNbColonnes();
        double tileHeight = canvas.getHeight()/labyrinthe.getNbLignes();

        for(Case c : labyrinthe.getCases().get(labyrinthe.getEtagesPerso())){
            c.afficher(gc, tileWidth, tileHeight);
        }   
        for(Entite e : labyrinthe.getEntites().get(labyrinthe.getEtagesPerso())){
            e.afficher(gc, tileWidth, tileHeight);
        }
        //affichage du perso
        labyrinthe.getPerso().afficher(gc, tileWidth, tileHeight);
    }
}