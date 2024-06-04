package zeldiablo.gameLaby.laby;

public abstract class Monstre implements Entite{
    int pv;
    String nom;
    int force;
    Arme arme;
    int x, y;

    public Monstre(int dx, int dy) {
        this.x = dx;
        this.y = dy;
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
