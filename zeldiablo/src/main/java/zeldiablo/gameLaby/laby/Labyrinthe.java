package zeldiablo.gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import zeldiablo.gameLaby.laby.elements.*;

/**
 * Classe Labyrinthe 
 * @author Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Labyrinthe {
    /**
     * Chemin pour le labyrinthe par défaut
     */
    public final static String DEFAULT_MAP = "zeldiablo/src/main/resources/labySimple/laby_default.txt";
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
    // personnage
    private Personnage pj;
    // etreFini
    private boolean fini = false;
    /**
     * charge le labyrinthe
     *
     * @param niveau nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(int niveau) throws IOException {
        //création d'un fichier data.txt pour stocker les données
        FileWriter f =  new FileWriter ("zeldiablo/src/main/resources/data/data.txt");
        f.close();
        // ouvrir fichier
        FileReader fichier;
        try{
            fichier = new FileReader("zeldiablo/src/main/resources/labySimple/laby"+niveau+".txt");
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
                String[] casesLigne = ligne.split(" ");
                for (int colonne = 0; colonne < nbColonnes; colonne++) {
                    Class<?> clazz = Class.forName("zeldiablo.gameLaby.laby.elements." + casesLigne[colonne]);
                    Element e = (Element)clazz.getConstructor(int.class, int.class).newInstance(colonne, numeroLigne);
                    // stockage
                    e.stocker(this);
                }
            }catch (Exception e) {
                throw new Error("Erreur lors de la lecture du fichier");
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
     * retourne la case suivante selon une actions
     *
     * @param x case depart
     * @param y case depart
     * @param action action effectuee
     * @return case suivante
     */
     public int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne tant que l'on ne sort pas du tableau
                y = y > 0 ? y - 1 : y;
                break;
            case BAS:
                // on descend une ligne
                y = y < nbLignes - 1 ? y + 1 : y;
                break;
            case DROITE:
                // on augmente colonne
                x = x < nbColonnes - 1 ? x + 1 : x;
                break;
            case GAUCHE:
                // on augmente colonne
                x = x > 0 ? x - 1 : x;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
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
        pj.setDirection(action);
    }
    /**
     * deplace les entites
     */
    public void deplacerEntites() throws NullPointerException{
        for (Entite entite : this.entites.get(this.etagesPerso)) {
            int[] courante = {entite.getX(), entite.getY()};
            String[] actions = {HAUT, BAS, GAUCHE, DROITE};
            // choisir une action aléatoire
            String action = actions[(int)(Math.random() * actions.length)];
            // calcule case suivante
            int[] suivante = getSuivant(courante[0], courante[1], action);
            // Vérifier si la case suivante est occupée par une entité
            for (Entite e : this.entites.get(this.etagesPerso)) {
                if (e.getX() == suivante[0] && e.getY() == suivante[1]) {
                    // Si la case suivante est occupée par une entité, ne pas déplacer l'entité
                    return;
                }
            }// pareil pour le personnage
            if(pj.getX() == suivante[0] && pj.getY() == suivante[1]){
                return;
            }
            getCase(suivante[0], suivante[1]).interagir(this, entite);
            entite.setDirection(action);
        }   
    }
    /**
     * méthode permettant de faire attatquer une entité
     */
    public void attaquer(){
        for (Entite entite : this.entites.get(this.etagesPerso)) {
            int[] courante = {entite.getX(), entite.getY()};
            // si le joueur est à proximité
            int[] suivante = getSuivant(courante[0], courante[1], entite.getDirection());
            //si c'est le joueur
            if(pj.getX() == suivante[0] && pj.getY() == suivante[1]){
                entite.attaquer(pj);
            }
        }
    }
    /**
     * méthode permettant de faire attaquer le joueur
     */
    public void attaquerJoueur(){
        int[] courante = {pj.getX(), pj.getY()};
        // si une entité est à proximité
        int[] suivante = getSuivant(courante[0], courante[1], pj.getDirection());
        //si c'est une entité
        for (Entite entite : this.entites.get(this.etagesPerso)) {
            if(entite.getX() == suivante[0] && entite.getY() == suivante[1]){
                pj.attaquer(entite);
            }
        }
    }
    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return fini;
    }
    /**
     * finir le jeu
     */
    public void finir(){fini = true;}
    /**
     * return mur en (i,j)
     * @param e1
     * @param e2
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
    /**
     * return entite
     * @return ArrayList<Entite>
     */
    public ArrayList<ArrayList<Entite>> getEntites(){return entites;}
    /**
     * return personnage
     * @return P
     */
    public Personnage getPerso(){return pj;}
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
    public void setPj(Personnage i){pj = i;}
    /**
     * set Case
     * @param c
     */
    public void setCases(Case c){
        cases.get(etagesPerso).remove(c);
        cases.get(etagesPerso).add(c);
    }
}
