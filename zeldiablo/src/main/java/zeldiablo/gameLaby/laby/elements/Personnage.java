package zeldiablo.gameLaby.laby.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

import java.io.FileInputStream;

/**
 * Personnage
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Personnage extends Entite{

    private String IMGPATH = "zeldiablo/src/main/resources/textures/hero_sideway.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight-0.5*tileHeight, tileWidth, tileHeight);
    };

    // super constructeur
    public Personnage(int dx, int dy) throws Exception{
        super(dx, dy);
        setPv(6);
        setForce(2);
        setColor(Color.RED);
        setNom("Personnage");
        getData();
    }
    /**
     * méthode stocker par polymorphisme
     * permet de stocket l'entite dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        try {
            laby.getCases().get(laby.getEtage()).add(new Case_Vide(this.getX(), this.getY()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ajout de perso dans pj
        laby.setPj(this);
    }
}
