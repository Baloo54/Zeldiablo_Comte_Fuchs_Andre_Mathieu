package zeldiablo.gameLaby.laby;

import java.util.Random;

public class PassageSecret
{
    public static int[] ouvrir = new int[2];
    public static boolean porteOuverte=false;

    /**
     * Position de l'activation du passage secret
     */
    public static int[] pos = new int[2];


    /**
     *initialise l'attribut tableau pos à une position aléatoire
     * qui correspond à la case qui fera ouvrir le passage secret si le jour passe dessus
     */

    public void interagir(Labyrinthe l, Perso p)
    {
        int retirerX;
        int retirerY;

        Random random = new Random();
        int x,y;


        do {
            x=random.nextInt(l.murs.length);
            y=random.nextInt(l.murs[0].length);
        }while(l.murs[x][y] instanceof  Mur || (l.pj.getX()==x && l.pj.getY()==y));

        pos[0]=x;
        pos[1]=y;

        if(pos[0]==p.getX() && pos[1]==p.getY())
        {
            do{
                retirerX = random.nextInt(l.murs.length);
                retirerY = random.nextInt(l.murs[0].length);
            }
            while(!(l.murs[retirerX][retirerY] instanceof Mur));

            porteOuverte = true;
            ouvrir[0]=retirerX;
            ouvrir[1]=retirerY;

        }
    }
}
