package Composite_Visiteurs.ExempleTPCommit.Composite;

public interface Visiteur<T> {

    T visite(Contributeur c);

    T visite(GroupeDeContributeurs g);

}
