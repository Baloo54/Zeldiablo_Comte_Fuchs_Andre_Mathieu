package zeldiablo.gameLaby.laby.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Arme;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

import java.io.FileInputStream;

/**
 * Case avec effet
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public class Case_Effet extends Case{

    private String IMGPATH = "zeldiablo/src/main/resources/textures/effect.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    };

    /**
     * super constructeur
     * @param x
     * @param y
     */
    public Case_Effet(int x, int y) throws Exception{
        super(x, y);
        setColor(Color.PURPLE);
        setNom("CaseEffet");
        getData();
    }
    /**
     * méthode pour stocker la case dans le labyrinthe
     * et donner un effet au joueur
     * @param l
     */
    public void interagir(Labyrinthe l, Entite e){
        int r = (int)(Math.random()*3);
        switch (r) {
            case 1:
                e.setPv(e.getPv()+2);
                break;
            case 2:
                e.setPv(e.getPv()-2);
                break;
            default:
               if(!(e instanceof Fantome)){Arme[] armes = {new Hellbarde(), new Glaive(), new Massue()};
                e.PrendreArme(armes[(int)(Math.random()*3)]);
                System.out.println(e + "a trouvé une arme !");}
                break;
        }
        System.out.println(e +" a subi un effet !");
        e.setPos(this.getX(), this.getY());
    }
}
