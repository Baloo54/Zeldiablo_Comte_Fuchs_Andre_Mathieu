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
    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";
    /**
     * les murs du labyrinthe
     */
    private ArrayList<ArrayList<Case>> cases = new ArrayList<ArrayList<Case>>();
    private int etage = 0;
    private int etagesPerso = 0;
    int nbLignes, nbColonnes;
    /**
     * tableau d'entites
     */
    private ArrayList<ArrayList<Entite>> entites = new ArrayList<ArrayList<Entite>>();
    // perso
    private P pj;
    /**
     * retourne la case suivante selon une actions
     *
     * @param x case depart
     * @param y case depart
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
            fichier = new FileReader(DEFAULT_MAP);
        }
        BufferedReader bfRead = new BufferedReader(fichier);
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());
        //création labyrinthe vide
        int nbEtages = Integer.parseInt(bfRead.readLine());
        // creation labyrinthe vide
        // lecture des cases
        String ligne = bfRead.readLine();
        // parcours le fichier
        for (int i = 0; i <= nbEtages; i++){
            int numeroLigne = 0;
            // ajout arraylist pour entites 
            entites.add(new ArrayList<Entite>());
            // ajout arraylist pour cases
            cases.add(new ArrayList<Case>());
            while (ligne != null && numeroLigne<nbColonnes) {
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
                throw new Error("Erreur lors de la lecture du labyrinthe" + e.getMessage());
            }
            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }
        etage++;
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
        int[] courante = {pj.getX(), pj.getY()};
        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // Vérifier si la case suivante est occupée par une entité
        for (Entite entite : this.entites.get(this.etagesPerso)) {
            if (entite.getX() == suivante[0] && entite.getY() == suivante[1]) {
                // Si la case suivante est occupée par une entité, ne pas déplacer le personnage
                return;
            }
        }

        // Si la case suivante n'est pas occupée par une entité, interagir avec la case suivante
        getCase(suivante[0], suivante[1]).interagir(this, pj);
    }
    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }
    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public Case getCase(int x, int y) {
        Case res = null;
        for(Case c : cases.get(etagesPerso)){
            if(c.getX() == x && c.getY() == y){
                res = c;
            }
        }
        return res;
    }

    public boolean verifierProximiteJoueur(P joueur,F fantonme)
    {
        int distance = Math.abs(joueur.getX() - fantonme.getX()) + Math.abs(joueur.getY() - fantonme.getY());
        if(distance <= 1)
        {
            return true;
        }

        return false;
    }



    /**
     * return entite
     * @return ArrayList<Entite>
     */
    public ArrayList<ArrayList<Entite>> getEntites(){return entites;}
    /**
     * return personnage
     * @return P
     */
    public P getPerso(){return pj;}
    /**
     * return etage
     * @return int
     */
    public int getEtage(){return etage;}
    /**
     * return etagesPerso
     * @return int
     */
    public int getEtagesPerso(){return etagesPerso;}
    /**
     * methode getCases
     * @return ArrayList<ArrayList<Case>>
     */
    public ArrayList<ArrayList<Case>> getCases(){return cases;}
    /**
     * return nbLignes
     * @return int
     */
    public int getNbLignes(){return nbLignes;}
    /**
     * return nbColonnes
     * @return int
     */
    public int getNbColonnes(){return nbColonnes;}
    /**
     * set etagesPerso
     * @param i
     */
    public void setEtagesPerso(int i){etagesPerso = i;}
    /**
     * set Pj
     * @param i
     */
    public void setPj(P i){pj = i;}
    /**
     * set Case
     * @param Case
     */
    public void setCases(Case c){
        cases.get(etagesPerso).remove(c);
        cases.get(etagesPerso).add(c);
    }
}
