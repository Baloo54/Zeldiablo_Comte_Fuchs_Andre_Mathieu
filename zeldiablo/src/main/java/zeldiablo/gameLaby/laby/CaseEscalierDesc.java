package zeldiablo.gameLaby.laby;

public class CaseEscalierDesc implements Case{

    public void interagir(Labyrinthe l, Perso p){
        //l.etageCourant = Math.min(l.etageCourant-1, 0); //presque inutile puisqu'il n'est pas sensé y avoir d'escalier
                                                        // descendant au dernier étage
        l.etageCourant--;
        l.murs = l.etages[l.etageCourant];
    }

}
