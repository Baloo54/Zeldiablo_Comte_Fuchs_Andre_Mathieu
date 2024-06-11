package zeldiablo.gameLaby.laby.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

import java.io.FileInputStream;

/**
 * Case vide
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public class Escalier_Down extends Case{

    private String IMGPATH = "zeldiablo/src/main/resources/textures/stairs.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    };

    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public Escalier_Down(int dx, int dy) throws Exception{
        super(dx, dy);
        setColor(Color.DARKGRAY);
        setNom("Escalier_Descendre");
        getData();
    }
    /**
     * méthode pour stocker la case dans le labyrinthe
     * et donner un effet au joueur
     * @param l
     */
    public void interagir(Labyrinthe l, Entite p){
        //si c'est un personnage car on ne veut pas que les monstres puissent changer les étages du labyrinthe
        if(p instanceof Personnage){l.setEtagesPerso(l.getEtagesPerso()-1);}
        p.setPos(this.getX(), this.getY());
    }
}
