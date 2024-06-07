package zeldiablo.gameLaby.laby;

public abstract class Case extends Element{
    /**
     * constructeur
     * @param dx position selon x
     * @param dy position selon y
     */
    public Case(int dx, int dy) {
        super(dx, dy);
    }
    /**
     * permet d'interagir avec une entite
     * @param l labyrinthe
     * @param e entite
     */
    public abstract void interagir(Labyrinthe l, Entite e);
    /**
     * methode stocker dans le labyrinthe
     * @param laby
     */
    public void stocker(Labyrinthe laby){
        laby.elements[this.getX()][this.getY()] = this;
    }
}