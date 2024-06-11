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

    private int max_health = 15;
    private String IMGPATH = "zeldiablo/src/main/resources/textures/hero_sideway.png";
    private String HEART_FULL_PATH = "zeldiablo/src/main/resources/textures/heart_full.png";

    private String HEART_EMPTY_PATH = "zeldiablo/src/main/resources/textures/heart_empty.png";

    private Image heart_full_image = new Image(new FileInputStream((this.HEART_FULL_PATH)));
    private Image heart_empty_image = new Image(new FileInputStream((this.HEART_EMPTY_PATH)));

    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight-0.5*tileHeight, tileWidth, tileHeight);
        for(int i = 0; i < max_health; i++){
            if(this.getPv() < i){
                c.drawImage(heart_empty_image, i*tileWidth/2, 0 ,  0.5*tileWidth, 0.5*tileHeight);
            } else {
                c.drawImage(heart_full_image, i*tileWidth/2, 0 ,  0.5*tileWidth, 0.5*tileHeight);
            }
        }
    };

    // super constructeur
    public Personnage(int dx, int dy) throws Exception{
        super(dx, dy);
        setPv(15);
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
