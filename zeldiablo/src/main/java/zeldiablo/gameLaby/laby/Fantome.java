package zeldiablo.gameLaby.laby;

public  class Fantome implements Entite{
    int pv;
    String nom;
    int force;
    Arme arme;
    int x, y;

    public Fantome(String nom, int pv, int force, int x, int y) {
        this.nom = nom;
        this.pv = pv;
        this.force = force;
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

}
