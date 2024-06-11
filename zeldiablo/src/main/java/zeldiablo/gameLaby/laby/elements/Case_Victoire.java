package zeldiablo.gameLaby.laby.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

import java.io.FileInputStream;

public class Case_Victoire extends Case {

    private String IMGPATH = "zeldiablo/src/main/resources/textures/exit.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    };
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Case_Victoire(int dx, int dy) throws Exception {
        super(dx, dy);
        setNom("CaseVictoire");
    }

    /**
     * permet d'interagir avec une entite
     *
     * @param l labyrinthe
     * @param e entite
     */
    @Override
    public void interagir(Labyrinthe l, Entite e)
    {
        if(e instanceof Personnage)
        {
            System.out.println("Victoire du joueur!");
            l.finir();
        }
    }
}
