package menuprincipal.jeu.phasesJeu;

import menuprincipal.battleship.joueur.Joueur;
import menuprincipal.jeu.Jeu;

public class PhaseJouer extends PhaseJeu{

    public PhaseJouer(Jeu jeu_) {
        super(jeu_);
    }

    @Override
    public void prochaineAction() {
        while (!jeu.effectuerProchaintour());
        jeu.effectuerPhase(new PhaseFinJeu(jeu));
    }
}
