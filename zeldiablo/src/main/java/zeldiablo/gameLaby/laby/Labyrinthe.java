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
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char PIEGE = 'T';
    public static final char EFFET = 'E';

    public static final char STR_ASC = '^';

    public static final char STR_DESC = 'v';

    public static final char FANTOME = 'F';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;

    public Fantome f;

    /**
     * les murs du labyrinthe
     */
    public Case[][] murs;

    public Case[][][] etages;

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

        this.etages = new Case[nbEtages][nbColonnes][nbLignes];
        // creation labyrinthe vide
        this.murs = new Case[nbColonnes][nbLignes];
        this.pj = null;

        for(int i = 0; i < nbEtages; i++) {

            FileReader fichierMap;

            String etage = bfRead.readLine();

            System.out.println(etage);

            try{
                fichierMap = new FileReader(etage);
            } catch (FileNotFoundException e){
                fichierMap = new FileReader(DEFAULT_MAP);
            }
            BufferedReader bfReadMap = new BufferedReader(fichierMap);

            // lecture des cases
            String ligne = bfReadMap.readLine();
            System.out.println(ligne);
            // stocke les indices courants
            int numeroLigne = 0;

            // parcours le fichier
            while (ligne != null) {

                // parcours de la ligne
                for (int colonne = 0; colonne < ligne.length(); colonne++) {

                    char c = ligne.charAt(colonne);
                    System.out.println(ligne + " : "+c);
                    switch (c) {
                        case MUR:
                            this.etages[i][colonne][numeroLigne] = new Mur();
                            break;
                        case VIDE:
                            this.etages[i][colonne][numeroLigne] = new CaseVide();
                            break;
                        case PIEGE:
                            this.etages[i][colonne][numeroLigne] = new CasePiegee();
                            break;
                        case EFFET:
                            this.etages[i][colonne][numeroLigne] = new CaseEffet();
                            break;
                        case STR_ASC:
                            this.etages[i][colonne][numeroLigne] = new CaseEscalierAsc();
                            break;
                        case STR_DESC:
                            this.etages[i][colonne][numeroLigne] = new CaseEscalierDesc();
                            break;
                        case FANTOME:
                            this.murs[colonne][numeroLigne] = new CaseVide();
                            this.f = new Fantome(colonne, numeroLigne);
                            break;
                        case PJ:
                            // pas de mur
                            this.etages[i][colonne][numeroLigne] = new CaseVide();
                            // ajoute PJ
                            this.pj = new Perso(colonne, numeroLigne);
                            this.murs = this.etages[i];
                            this.etageCourant = i;
                            break;

                        default:
                            throw new Error("caractere inconnu " + c);
                    }
                }

                // lecture
                ligne = bfReadMap.readLine();
                numeroLigne++;
            }

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

        int[] courante = {this.pj.getX(), this.pj.getY()};

        int[] suivante = getSuivant(courante[0], courante[1], action);

        if (!(this.murs[suivante[0]][suivante[1]] instanceof Mur)) {
            boolean caseLibre = true;

            if ((this.pj.getX() == suivante[0] && this.pj.getY() == suivante[1]) ||
                    (this.f != null && this.f.getX() == suivante[0] && this.f.getY() == suivante[1])) {
                caseLibre = false;
            }

            if (caseLibre) {
                this.pj.x = suivante[0];
                this.pj.y = suivante[1];
                this.murs[suivante[0]][suivante[1]].interagir(this, this.pj);
            }
        }
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
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public Case getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public Perso getPj() {
        return this.pj;
    }
}
