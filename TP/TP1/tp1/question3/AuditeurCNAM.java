package question3;

import java.text.Normalizer;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author Alexandre Moro
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son pr�nom et son
     * matricule.
     * 
     * @param nom       le nom de l'auditeur
     * @param prenom    son prénom
     * @param matricule sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premières lettres du nom suivies de la première lettre
     * du prénom séparées de '_' . le login retourné est en minuscules, le trait
     * d'union, ou spéciaux <i>(pour unix)</i> sont remplacés par des '_' pas de
     * caractères accentués pour le login voir les classes prédéfines,
     * java.lang.String : les méthodes replaceAll, toLowerCase et substring
     * java.lang.Math : la méthode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifié, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {

        String loginNom = CommonLoginRules(this.nom.substring(0, Math.min(this.nom.length(), 6)));

        String loginPrenom = CommonLoginRules(this.prenom.substring(0, Math.min(this.nom.length(), 1)));

        return loginNom + "_" + loginPrenom;

    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom;
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return this.prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule;
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

    private static String CommonLoginRules(String input) {

        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase()
                .replaceAll("[\\s \\W]", "_");
    }

}
