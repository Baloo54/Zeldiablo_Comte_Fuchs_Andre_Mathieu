package zeldiablo.gameLaby.laby.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import zeldiablo.gameLaby.laby.LabyDessin;

import java.io.FileInputStream;

/**
 * Case Glaive
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Massue extends Case_Arme
{
    private String IMGPATH = "zeldiablo/src/main/resources/textures/mace.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    };
    /**
     * super constructeur
     *
     * @param dx
     * @param dy
     */
    public Case_Massue(int dx, int dy) throws Exception{
        super(dx, dy);
        setArme(new Massue());
    }
}
