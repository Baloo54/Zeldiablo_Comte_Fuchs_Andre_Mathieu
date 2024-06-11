package zeldiablo.gameLaby.laby.elements;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

/**
 * Case Glaive
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Hellbarde extends Case_Arme
{

    private String IMGPATH = "zeldiablo/src/main/resources/textures/hallberd.png";
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
    public Case_Hellbarde(int dx,int dy) throws Exception
    {
        super(dx,dy);
        setArme(new Hellbarde());
    }


}
