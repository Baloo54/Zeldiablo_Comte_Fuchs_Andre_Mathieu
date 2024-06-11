package zeldiablo.gameLaby.laby.elements;

/**
 * Case Glaive
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Glaive extends Case_Arme
{
    /**
     * super constructeur
     *
     * @param dx
     * @param dy
     */
    public Case_Glaive(int dx, int dy)
    {
        super(dx, dy);
        setArme(new Glaive());
    }
}
