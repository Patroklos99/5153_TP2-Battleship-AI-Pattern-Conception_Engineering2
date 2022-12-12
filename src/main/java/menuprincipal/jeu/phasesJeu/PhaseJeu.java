package menuprincipal.jeu.phasesJeu;

import menuprincipal.jeu.Jeu;

public abstract class PhaseJeu {
    protected Jeu jeu;

    public PhaseJeu(Jeu jeu_){
        this.jeu = jeu_;
    }

    /**
     * Exécuter la prochaine action à effectuer pour Jeu.
     * */
    abstract public void prochaineAction();

}
