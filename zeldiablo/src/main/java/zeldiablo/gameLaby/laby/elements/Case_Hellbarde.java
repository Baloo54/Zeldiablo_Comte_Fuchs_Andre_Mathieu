package zeldiablo.gameLaby.laby.elements;


import zeldiablo.gameLaby.laby.Case;

/**
 * Case Glaive
 * @autor Gabriel Comte, Thomas Fuchs, Jules Andre, Gabin Mattieu
 * @version 3.0
 */
public class Case_Hellbarde extends Case_Arme
{
    /**
     * super constructeur
     *
     * @param dx
     * @param dy
     */
    public Case_Hellbarde(int dx,int dy)
    {
        super(dx,dy);
        setArme(new Hellbarde());
    }


}
