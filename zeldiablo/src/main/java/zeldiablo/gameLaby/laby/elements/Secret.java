package zeldiablo.gameLaby.laby.elements;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;

/**
 * Passage secret
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public class Secret extends Case{

    private String IMGPATH = "zeldiablo/src/main/resources/textures/button.png";
    private Image IMG = new Image( new FileInputStream(this.IMGPATH));

    public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
        c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
    };

    /**
     * attribut postition du passage secret 
     *
     */
    private Case passageSecret;
    private Case mur;
    private boolean present = false, visible = false;
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public Secret(int dx, int dy) throws Exception{
        super(dx, dy);
        setColor(Color.GREEN);
        setNom("Passage_Secret");
        getData();
    }
    /**
     * méthode interagir
     * @param l
     * @param p
     */
    public void interagir(Labyrinthe l, Entite p){
        //si le passage secret n'est pas présent on le place
        if (!this.present){
            this.present = true;
            //création d'un tableau contenant tous les murs n'etant pas au bord du labyrinthe
            ArrayList<Case> murs = new ArrayList<Case>();
            ArrayList<Case> cases = l.getCases().get(l.getEtagesPerso());
            for(Case c : cases){
                if(c instanceof Mur){
                    if(c.getX() != 0 && c.getX() != l.getNbColonnes()-1 && c.getY() != 0 && c.getY() != l.getNbLignes()-1){
                        murs.add(c);
                    }
                }
            }
            //on choisit un mur au hasard
            int i = (int)(Math.random()*murs.size());
            int x = murs.get(i).getX(), y = murs.get(i).getY();
            try {
                mur = new Mur(x, y);
                passageSecret = new Case_Vide(x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //permet de changer la case en fonction de si le passage secret est visible ou non
        if(!visible){l.setCases(passageSecret);}
        else{l.setCases(mur);}
        p.setPos(this.getX(), this.getY());
        visible = visible ? false : true;
    }
}
