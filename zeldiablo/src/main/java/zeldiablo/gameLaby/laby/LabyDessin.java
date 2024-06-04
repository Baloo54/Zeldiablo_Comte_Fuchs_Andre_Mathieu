package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        Labyrinthe labyrinthe = laby.getLabyrinthe();
        for(int i = 0; i < labyrinthe.murs.length; i++){
            for(int j = 0; j < labyrinthe.murs[i].length; j++){
                if(labyrinthe.pj.getX() == i && labyrinthe.pj.getY() == j){
                    gc.setFill(Color.RED);
                    gc.fillOval(i*80, j*60, 80, 60);
                }else if(labyrinthe.murs[i][j] instanceof Mur){ //a modifier après
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i*80, j*60, 80, 60);
                }else{
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i*80, j*60, 80, 60);
                }
            }
        }
    }
}