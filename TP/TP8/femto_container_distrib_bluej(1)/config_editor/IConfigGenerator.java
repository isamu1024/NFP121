package config_editor;
import java.io.FilenameFilter;

/** Interface pour outils d'aide � la g�n�ration des fichiers de configuration,
 * fichiers principalement destin�s � femtoContainer.<br>
 * Chaque mutateur(<i>setter</i>) est identifi� et engendre les items attendus dans le fichier de configuration,
 * un mutateur doit respecter les conventions habituelles : void setXXXX(type elt)<br>
 * - Commencer par set, avoir un seul param�tre et ne pas retourner de r�sultat (void)<br>
 * Le format en sortie des items engendr�s d�pendent du <i>formatter</i> choisi.
 */
public interface IConfigGenerator{

    /** Analyse d'un fichier .class ou d'un r�pertoire. Afin d'engendrer un fichier de configuration � "trous", 
     * dans lequel il ne reste plus qu'� affecter les valeurs des attributs/propri�t�s.
     * <b>Attention</b> au pr�alable setBeanClassFileName a �t� appel�e<br>
     */
    public IConfigGenerator analyze() throws Exception;
    
    /** Analyse d'un fichier .class ou d'un r�pertoire. Afin d'engendrer un fichier de configuration � "trous", 
     * dans lequel il ne reste plus qu'� affecter les valeurs des attributs/propri�t�s.
     * Par d�faut ce sont les fichiers .class d'un r�pertoire qui sont analys�s.
     * @param pathOrFileName un nom de fichier ou un nom de r�pertoire
     */
    public IConfigGenerator analyze(String pathOrFileName) throws Exception;

    /** Analyse d'un fichier .class ou d'un r�pertoire. 
     * @param pathOrFileName un nom de fichier ou un nom de r�pertoire
     * @param filter permet de filtrer les fichiers du r�pertoire
     */
    public IConfigGenerator analyze(String pathOrFileName, FilenameFilter filter) throws Exception;
  
    public void setBeanNumber(int beanNumber);
    public void setBeanName(String beanName);
    public void setBeanPrefixName(String beanPrefixName);
    
    /** Affectation du nom de la classe, ou du nom d'un r�pertoire.
     */
    public void setBeanClassFileName(String beanClassName);
    
    /** Choix du format de sortie. cf. le patron Strat�gie.
     * @param formatter le format 
     */
    public void setFormatter(Formatter formatter);

    /** Avec des commentaires dans le texte au format choisi.
     * @param true des commentaires seront pr�sents, pour chaque bean, pour chaque mutateur.
     */
    public void setComment(boolean comment);
    
    // accesseurs
    public int getBeanNumber();
    public String getBeanPrefixName();
    public String getBeanName();
    public String getBeanClassFileName();
    public Formatter getFormatter();
}