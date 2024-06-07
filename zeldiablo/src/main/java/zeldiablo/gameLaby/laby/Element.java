package zeldiablo.gameLaby.laby;

import javafx.scene.canvas.GraphicsContext;

public abstract class Element {
  /**
   * attributs position
   */
  private int x, y;
  /**
   * constructeur
   * @param dx position selon x
   * @param dy position selon y
   */
  public Element(int dx, int dy) {
      this.x = dx;
      this.y = dy;
  }
   /**
     * méthode afficher l'entite
     * @param canvas
     */
    public abstract void afficher(GraphicsContext c, int i, int j, double tileWidth, double tileHeight);
    /**
     * @return position x de l'entite
     */
    public int getX() {
      // getter
      return this.x;
  }

  /**
   * @return position y de l'entite
   */
  public int getY() {
      //getter
      return this.y;
  }
    /**
     * setter
     * @param x
     * @param y
     */
    public void setPos(int x, int y){
      this.x = x;
      this.y = y;
  }
  /**
   *  abstract méthode stocker 
   * permet de stocket l'element dans le labyrinthe
   * @param laby
   */
  public abstract void stocker(Labyrinthe laby);
}
