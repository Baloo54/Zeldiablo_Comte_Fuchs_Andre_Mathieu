package zeldiablo.gameLaby.laby;

public class CaseEscalierAsc implements Case{

    public void interagir(Labyrinthe l, Entite e){
        if (e instanceof Perso){
            l.etageCourant++;
            l.murs = l.etages[l.etageCourant];
        }
    }

}
