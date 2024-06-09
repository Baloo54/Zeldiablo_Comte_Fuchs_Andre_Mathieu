/*
import org.junit.jupiter.api.Test;
import zeldiablo.gameLaby.laby.CaseEffet;
import zeldiablo.gameLaby.laby.CasePiegee;
import zeldiablo.gameLaby.laby.Labyrinthe;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class TestLabyrinthe {

    @Test
    void testCollisionAvecMurs() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby2.txt");
        int initX = labyrinthe.getPj().getX();
        int initY = labyrinthe.getPj().getY();

            labyrinthe.deplacerPerso(Labyrinthe.DROITE);

        assertEquals(initX, labyrinthe.getPj().getX());
        assertEquals(initY, labyrinthe.getPj().getY());
    }


    @Test
    void testDeplacerPerso() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby2.txt");

        assertEquals(17, labyrinthe.getPj().getX());
        assertEquals(12, labyrinthe.getPj().getY());

        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
        assertEquals(16, labyrinthe.getPj().getX());
        assertEquals(12, labyrinthe.getPj().getY());

        labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        assertEquals(16, labyrinthe.getPj().getX());
        assertEquals(11, labyrinthe.getPj().getY());
    }

    @Test
    void testEtreFini() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby2.txt");
        assertFalse(labyrinthe.etreFini());
    }

    @Test

    void testSpecialCase() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/labyTest.txt");

        labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        assertInstanceOf(CasePiegee.class, labyrinthe.murs[labyrinthe.getPj().getX()][labyrinthe.getPj().getY()]);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        assertInstanceOf(CaseEffet.class, labyrinthe.murs[labyrinthe.getPj().getX()][labyrinthe.getPj().getY()]);
    }
}*/