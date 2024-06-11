package zeldiablo.gameLaby.laby;

import java.io.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * classe abstraite Element
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public abstract class Element {

    @SuppressWarnings("unused")
    private String IMGPATH; // = "zeldiablo/src/main/resources/textures/slab.png";
    private Image IMG;
  /**
   * attributs position
   * couleur
   * nom
   */
  private int x, y;
  private Color color;
  private String nom;
  /**
   * constructeur
   * @param dx position selon x
   * @param dy position selon y
   * @param Color couleur
   */
  public Element(int dx, int dy) throws Exception{
      this.x = dx;
      this.y = dy;
  }
  /**
     * méthode afficher l'entite
     * @param canvas
     */
  public void afficher(GraphicsContext c, double tileWidth, double tileHeight){
      c.drawImage(IMG ,getX()*tileWidth, getY()*tileHeight, tileWidth, tileHeight);
  };
  /**
   *  abstract méthode stocker 
   * permet de stocket l'element dans le labyrinthe
   * @param laby
   */
  public abstract void stocker(Labyrinthe laby);
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
   * methode setColor
   * @param color
   */
  public void setColor(Color color){this.color = color;}
  /**
   * methode getColor
   */
  public Color getColor(){return this.color;}
  /**
   * methode setNom
   * @param nom
   */
  public void setNom(String nom){this.nom = nom;}
  /**
   * methode toString
   */ 
  public String toString(){return this.nom;}
  /**
   * methode getData
   */
  public void getData() throws Exception{
    File file = new File("zeldiablo/src/main/resources/data/data.txt");
    File file2 = new File("zeldiablo/src/main/resources/data/data2.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    boolean found = false;
      while((line = reader.readLine()) != null){
          if(line.split(":")[0].equals(this.nom)){
              found = true;
              String[] data = line.split(":");
              int nb = Integer.parseInt(data[1]);
              writer.write(this.nom + ":" + (nb+1) + "\n");
          }else{
              writer.write(line + "\n");
          }
      }
      if(!found){
            writer.write(this.nom + ":1");
      }
      writer.close();
      reader.close();
      file.delete();
      file2.renameTo(file);
    }
    /**
     * methode equals
     * @param o
     * @return boolean 
     */
    public boolean equals(Object o){
      boolean res = false;
      if(o instanceof Element){
          Element c = (Element) o;
          res = (this.getX() == c.getX() && this.getY() == c.getY());
      }return res;
  }
}