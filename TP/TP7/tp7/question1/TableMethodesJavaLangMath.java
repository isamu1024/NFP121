package question1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.*;

/**
 * Gestion par introspection des m�thodes de la classe java.lang.Math,<br>
 * Seules sont conserv�es :les m�thodes retournant un double et d'arit� 1 ou 2<p>
 * Note : Emploi du Pattern Singleton pour cette table, accessible uniquement en lecture par des accesseurs<p>
 * La convention de nommage est la suivante :
 * le "Nom" de la fonction suivi de "(double)"  exemple : "sqrt(double)"
 * ou le "Nom" de la fonction suivi de "(double, double)"  exemple : "IEEEremainder(double, double)"
 */

final public class TableMethodesJavaLangMath {
    /**
     * Singleton
     */
    private static TableMethodesJavaLangMath instanceUnique = null;
    /**
     * Le dictionnaire contient la liste des m�thodes disponibles.
     * un choix de dictionnaire pourrait �tre pour la Cl� une String soit le Nom de la fonction + "(double)" ou "(double, double)".<br>
     * et en Valeur =  la Method correspondante.
     * ou tout autre choix
     */
    private static Map<String, Method> tableDesMethodes = null;// � compl�ter ...

    /** bloc statique d'intialisation de la table des m�thodes */
    static {
        tableDesMethodes = new TreeMap<>();
        for (Method m : Math.class.getDeclaredMethods()) {
            String paramType = Arrays.toString(m.getParameterTypes());

            if ((paramType.equals("[double, double]") || paramType.equals("[double]"))
                    && m.getReturnType().toString().equals("double")) {
                String methodName = m.getName() +
                        "(" +
                        paramType.substring(1, paramType.length() - 1) +
                        ")";
                tableDesMethodes.put(methodName, m);
            }
        }
    }
    // fin du Singleton

    private TableMethodesJavaLangMath() {
    }


    // Cr�� une instance de la classe si celle-ci n'est pas pr�sente.
    public static TableMethodesJavaLangMath getInstance() {
        synchronized (TableMethodesJavaLangMath.class) {
            if (instanceUnique == null) {
                instanceUnique = new TableMethodesJavaLangMath();
            }
            return instanceUnique;
        }
    }

    /**
     * @param nomDeLaM�thode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est pr�sente
     */
    public boolean cetteMethodeEstPresente(String nomDeLaM�thode) {
        return tableDesMethodes.containsKey(nomDeLaM�thode); // � compl�ter
    }

    /**
     * @param nomDeLaMethode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est binaire, d'arit� 2
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas
     */
    public boolean cetteMethodeAttendDeuxParametres(String nomDeLaMethode) {
        if (!tableDesMethodes.containsKey(nomDeLaMethode))
            throw new NoSuchElementException();
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 2;
    }

    /**
     * @param nomDeLaMethode Nom de la fonction + "(double)" ou "(double, double)"
     * @return true si la fonction est unaire, d'arit� 1
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas
     */
    public boolean cetteMethodeAttendUnSeulParametre(String nomDeLaMethode) {
        if (!tableDesMethodes.containsKey(nomDeLaMethode))
            throw new NoSuchElementException();
        return tableDesMethodes.get(nomDeLaMethode).getParameterTypes().length == 1;
    }

    /**
     * Obtention de la liste ordonn�e des m�thodes
     *
     * @return la liste tri�e des fonctions issues de java.lang.Math
     */
    public String[] listeDesMethodes() {
        return tableDesMethodes.keySet().toArray(new String[0]);
    }

    /**
     * Invocation d'une m�thode de la table
     *
     * @param nomDeLaMethode Nom de la fonction + "(double)"
     * @param arg1 l'op�rande
     * @return un r�sultat
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas ou une exception lev�e par la fonction appel�e
     */
    public double invoquer(String nomDeLaMethode, double arg1) throws Exception {
        if (!tableDesMethodes.containsKey(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double) tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1);
    }

    /**
     * Invocation d'une m�thode de la table
     *
     * @param nomDeLaMethode Nom de la fonction + "(double, double)"
     * @param arg1 l'op�rande
     * @return un r�sultat
     * @throws NoSuchElementException si la m�thode demand�e n'existe pas ou une exception lev�e par la fonction appel�e
     */
    public double invoquer(String nomDeLaMethode, double arg1, double arg2) throws Exception {
        if (!tableDesMethodes.containsKey(nomDeLaMethode))
            throw new NoSuchElementException();
        return (double) tableDesMethodes.get(nomDeLaMethode).invoke(this, arg1, arg2);
    }
}