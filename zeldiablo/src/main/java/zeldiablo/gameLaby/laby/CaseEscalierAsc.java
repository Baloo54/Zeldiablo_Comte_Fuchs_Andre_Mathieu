package zeldiablo.gameLaby.laby;

public class CaseEscalierAsc implements Case{

    public void interagir(Labyrinthe l, Perso p){
        l.etageCourant++;
        l.murs = l.etages[l.etageCourant];
    }

}
