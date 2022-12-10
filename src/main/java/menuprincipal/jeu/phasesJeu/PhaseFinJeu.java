package menuprincipal.jeu.phasesJeu;

import menuprincipal.jeu.Jeu;

public class PhaseFinJeu extends PhaseJeu{

    public PhaseFinJeu(Jeu jeu_) {
        super(jeu_);
    }

    @Override
    public void prochaineAction() {
        jeu.enregistrer();
        jeu.visualiser();
    }
}
