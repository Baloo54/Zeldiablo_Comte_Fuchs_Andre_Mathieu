package zeldiablo.gameLaby.laby.elements;

import javafx.scene.paint.Color;
import zeldiablo.gameLaby.laby.Case;
import zeldiablo.gameLaby.laby.Entite;
import zeldiablo.gameLaby.laby.Labyrinthe;
/**
 * Case avec effet
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 * 
 */
public class Case_Effet extends Case{
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
                e.setPv(e.getPv()+1);
                break;
            case 2:
                e.setPv(e.getPv()-1);
                break;
            case 3:
                //prendre un glaive mais qui n'a pas 3 en degats
                // mais des dégats aléatoires
                Glaive g = new Glaive();
                g.setDegats((int)(Math.random()*6));
                e.PrendreArme(g);
                break;
            default:
                break;
        }
        System.out.println(e +" a subi un effet !");
        e.setPos(this.getX(), this.getY());
    }
}
