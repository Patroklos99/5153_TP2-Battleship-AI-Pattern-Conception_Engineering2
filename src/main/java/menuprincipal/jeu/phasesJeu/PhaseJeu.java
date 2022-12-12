package menuprincipal.jeu.phasesJeu;

import menuprincipal.jeu.Jeu;

public abstract class PhaseJeu {
    protected Jeu jeu;

    public PhaseJeu(Jeu jeu_){
        this.jeu = jeu_;
    }

    abstract public void prochaineAction();

}
