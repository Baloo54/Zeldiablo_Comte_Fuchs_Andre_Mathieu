package zeldiablo.gameLaby.laby;

import zeldiablo.moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 * @author Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {
    int width = 800;
    int height = 600;
    int pFPS = 5;

    LabyJeu jeuLaby = new LabyJeu();
    LabyDessin dessinLaby = new LabyDessin();
    MoteurJeu.setTaille(width, height);
    MoteurJeu.setFPS(pFPS);
    MoteurJeu.launch(jeuLaby, dessinLaby);
    }
}
