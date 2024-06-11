/**
import org.junit.jupiter.api.Test;
import zeldiablo.gameLaby.laby.Entite;

import zeldiablo.gameLaby.laby.Labyrinthe;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntite
{

    //Test si entitee est au bon emplacement
    @Test
    void testInitialisationCoordonnees() throws IOException
    {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby1.txt");
        Entite monstre = labyrinthe.getEntites().get(0);
        assertEquals(5, monstre.getX());
        assertEquals(5, monstre.getY());
    }

    @Test
    void testAttaque() throws IOException
    {
        Labyrinthe labyrinthe = new Labyrinthe("zeldiablo/src/main/resources/labySimple/laby1.txt");
        Entite monstre = labyrinthe.getEntites().get(0);
        F f = new F(5, 5);
        monstre.attaquer(f);
        assertEquals(1, f.getVie());
    }


    @Test
    public void testSubirDegats() {
        Entite entite = new Entite(0, 0) {
            // Implémentation des méthodes abstraites
        };
        entite.setPv(10);
        entite.subirDegats(5);
        assertEquals(5, entite.getPv());
    }

 @Test
 public void testDeplacement() {
 labyrinthe.deplacerEntites();
 // Vérifiez que le fantome s'est déplacé
 assertTrue(fantome.getX() != 2 || fantome.getY() != 2);
 }

 @Test
 public void testCollisionAvecPersonnage() {
 personnage.setX(3);
 personnage.setY(2);

 labyrinthe.deplacerEntites();
 // Vérifiez que le fantome ne se déplace pas sur le personnage
 assertFalse(fantome.getX() == 3 && fantome.getY() == 2);
 }

 @Test
 public void testInteractionAvecCase() {
 Case caseSpeciale = new Case() {
 @Override
 public void interagir(Labyrinthe labyrinthe, Entite entite) {
 entite.setX(entite.getX() + 1); // Exemple d'interaction simple
 }
 };
 labyrinthe.cases.get(2).set(3, caseSpeciale);

 labyrinthe.deplacerEntites();
 // Vérifiez que l'interaction avec la case s'est produite
 if (fantome.getX() == 3 && fantome.getY() == 2) {
 assertEquals(4, fantome.getX());
 }
 }
 }
*/