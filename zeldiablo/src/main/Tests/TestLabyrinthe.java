/*
import org.junit.jupiter.api.Test;
import zeldiablo.gameLaby.laby.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


public class TestLabyrinthe {


    //Teste si le labyrinthe se charge
    @Test
    void testChargerLabyrinthe() throws IOException
    {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        assertNotNull(labyrinthe);
    }

    //Teste si une exception est bien levee quand un fichier labyrinthe n'existe pas
    @Test
    void testLabyrintheFichierInexistant()
    {
        assertThrows(Error.class, () -> {
            new Labyrinthe("zeldiablo/src/main/resources/labySimple/cuicui.txt");
        });
    }

    //Teste de déplacement et de collisions avec les murs
    @Test
    void testDeplacementPerso() throws IOException
    {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        Entite entite = labyrinthe.entites.get(0);
        int initX = entite.getX();
        int initY = entite.getY();

        //Censé ne pas bouger, case mur au-dessus, pour le laby testé
        labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        assertEquals(initY, entite.getY());
        assertEquals(initX, entite.getX());

        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        assertEquals(initX, entite.getX());
        assertEquals(initY+1, entite.getY());


        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
        assertEquals(initX-1, entite.getX());
        assertEquals(initY+1, entite.getY());

        labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        assertEquals(initX, entite.getX());
        assertEquals(initY+1, entite.getY());

    }

    //Teste si le nombre d'etage est lu correctement
    @Test
    void testInitialisationNbEtages() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        assertEquals(1, labyrinthe.nbEtages);
    }

    //Teste si les getteurs retournent bien la taille du labyrinthe
    @Test
    void testGetLengthAndLengthY() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        assertEquals(10, labyrinthe.getLength());
        assertEquals(10, labyrinthe.getLengthY());
    }

    //Teste si un element se trouve bien aux coordonnées indiquées
    @Test
    void testGetElement() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        Element element = labyrinthe.getElement(0, 0);
        assertNotNull(element);
    }

    //Teste une action invalide
    @Test
    void testDeplacerPersoInvalidAction() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/lev0.txt");
        Entite entite = labyrinthe.entites.get(0);
        int initX = entite.getX();
        int initY = entite.getY();

        assertThrows(Error.class, () -> {
            labyrinthe.deplacerPerso("INVALID_ACTION");
        });
    }

    public class LabyJeuTest {

    @Test
    public void testEtreFini() throws IOException {
        LabyJeu labyJeu = new LabyJeu();
        assertFalse(labyJeu.etreFini());
    }

    //TODO TESTER SI LE JEU SE FINI BIEN

}

 */