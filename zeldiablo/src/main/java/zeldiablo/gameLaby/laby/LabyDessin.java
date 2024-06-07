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

        double tileWidth = canvas.getWidth()/labyrinthe.elements.length;
        double tileHeight = canvas.getHeight()/labyrinthe.elements[0].length;

        for(Element[] row : labyrinthe.elements){
            for(Element c : row){
                c.afficher(gc, c.getX(), c.getY(), tileWidth, tileHeight);
            }
        }   
        for(Entite e : labyrinthe.entites){
            e.afficher(gc, e.getX(), e.getY(), tileWidth, tileHeight);
        }
       
    }
}