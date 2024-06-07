package zeldiablo.gameLaby.laby;

import zeldiablo.moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {
    int width = 800;
    int height = 600;
    int pFPS = 100;

    LabyJeu jeuLaby = new LabyJeu();
    LabyDessin dessinLaby = new LabyDessin();

    MoteurJeu.setTaille(width, height);
    MoteurJeu.setFPS(pFPS);

    MoteurJeu.launch(jeuLaby, dessinLaby);
    }
}
