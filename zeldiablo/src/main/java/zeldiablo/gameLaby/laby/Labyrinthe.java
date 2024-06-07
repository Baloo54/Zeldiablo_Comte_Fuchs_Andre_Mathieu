package zeldiablo.gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Chemin pour le labyrinthe par défaut
     */
    public final static String DEFAULT_MAP = "zeldiablo/src/main/resources/labySimple/laby_default";

    public final static String DEFAULT_MAP_BUILDER = "zeldiablo/src/main/resources/labySimple/laby_default_builder.txt";
    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * tableau d'entites
     */
    public ArrayList<Entite> entites = new ArrayList<Entite>();

    /**
     * les murs du labyrinthe
     */
    public Element[][] elements;

    public Element[][][] etages;

    public int nbEtages;

    public int etageCourant;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier;
        try{
            fichier = new FileReader(nom);
        } catch (FileNotFoundException e){
            fichier = new FileReader(DEFAULT_MAP_BUILDER);
        }

        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        //lecture nombre d'étages
        this.nbEtages = Integer.parseInt(bfRead.readLine());

        this.etages = new Element[nbEtages][nbColonnes][nbLignes];
        // creation labyrinthe vide
        this.elements = new Element[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();
        // stocke les indices courants
        int numeroLigne = 0;
        // parcours le fichier
        while (ligne != null) {
            // parcours de la ligne
            try {
                for (int colonne = 0; colonne < ligne.length(); colonne++) {
                    // conversion de la case en objet Case
                    Class<?> clazz = Class.forName("zeldiablo.gameLaby.laby." + ligne.charAt(colonne));
                    Element e = (Element)clazz.getConstructor(int.class, int.class).newInstance(colonne, numeroLigne);
                    // stockage
                    e.stocker(this);
                }
            }catch (Exception e) {
                throw new Error("Erreur lors de la lecture du labyrinthe : " + e.getMessage());
            }
            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {entites.get(0).getX(), entites.get(0).getY()};
        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);
        //interagir avec la case suivante
        ((Case) this.elements[suivante[0]][suivante[1]]).interagir(this, this.entites.get(0));
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return elements[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return elements.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public Element getElement(int x, int y) {
        // utilise le tableau de boolean
        return this.elements[x][y];
    }
}
