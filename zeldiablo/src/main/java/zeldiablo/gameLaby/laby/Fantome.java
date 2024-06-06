package zeldiablo.gameLaby.laby;

public  class Fantome implements Entite{
    int pv = 10;
    String nom = "Fantome";
    int force = 2;
    Arme arme = null;
    int x, y;

    public Fantome(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public void subirDegats(int i){
        this.pv-=i;
    }

    public void attaquer(Entite e){
        e.subirDegats(this.force);
    }

    public void PrendreArme(Arme arme) {

    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getForce() {
        return force;
    }

    public Arme getArme() {
        return arme;
    }

    public void interagir(Labyrinthe l, Perso p) {
        {
            System.out.println(""+p+" s'est fait attaquer par un Fantome !");
        }
        this.attaquer(p);
    }

    public int getX() {
        // getter
        return this.x;
    }

    public int getY() {
        //getter
        return this.y;
    }

}