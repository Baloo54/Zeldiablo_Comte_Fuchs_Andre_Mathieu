package zeldiablo.gameLaby.laby.elements;

/**
 * Case Glaive
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Massue extends Case_Arme
{
    /**
     * super constructeur
     *
     * @param dx
     * @param dy
     */
    public Case_Massue(int dx, int dy) throws Exception{
        super(dx, dy);
        setArme(new Massue());
    }
}
