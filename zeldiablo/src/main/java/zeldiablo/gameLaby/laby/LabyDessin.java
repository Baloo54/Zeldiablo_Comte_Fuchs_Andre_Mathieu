package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import zeldiablo.moteurJeu.*;

/**
 * classe de dessin pour un jeu de type labyrinthe
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
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
        //taille des cases
        double tileWidth = canvas.getWidth()/labyrinthe.getNbColonnes();
        double tileHeight = canvas.getHeight()/labyrinthe.getNbLignes();

        double tileSize = Math.min(tileWidth, tileHeight);

        //affichage des cases
        for(Case c : labyrinthe.getCases().get(labyrinthe.getEtagesPerso())){
            c.afficher(gc, tileSize,tileSize);
        }   
        //affichage des entites
        for(Entite e : labyrinthe.getEntites().get(labyrinthe.getEtagesPerso())){
            e.afficher(gc, tileSize, tileSize);
        }
        //affichage du perso
        labyrinthe.getPerso().afficher(gc, tileSize, tileSize);
    }
}