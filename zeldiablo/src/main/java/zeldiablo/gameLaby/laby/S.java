package zeldiablo.gameLaby.laby;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class S extends Case{
    /**
     * attribut postition du passage secret 
     *
     */
    private int x;
    private int y;
    private boolean present = false, visible = false;
    /**
     * super constructeur
     * @param dx
     * @param dy
     */
    public S(int dx, int dy){
        super(dx, dy);
        setColor(Color.GREEN);
    }
    public void interagir(Labyrinthe l, Entite p){
        //si le passage secret n'est pas présent on le place
        if (!this.present){
            this.present = true;
            //création d'un tableau contenant tous les murs n'etant pas au bord du labyrinthe
            ArrayList<Case> murs = new ArrayList<Case>();
            ArrayList<Case> cases = l.getCases().get(l.getEtagesPerso());
            for(Case c : cases){
                if(c instanceof X){
                    if(c.getX() != 0 && c.getX() != l.getNbColonnes()-1 && c.getY() != 0 && c.getY() != l.getNbLignes()-1){
                        murs.add(c);
                    }
                }
            }
            //on choisit un mur au hasard
            int i = (int)(Math.random()*murs.size());
            x = murs.get(i).getX();
            y = murs.get(i).getY();
        }
        //permet de changer la case en fonction de si le passage secret est visible ou non
        if(!visible){l.setCases(new V(x, y));}
        else{l.setCases(new X(x, y));}
        p.setPos(this.getX(), this.getY());
        visible = visible ? false : true;
    }
}
