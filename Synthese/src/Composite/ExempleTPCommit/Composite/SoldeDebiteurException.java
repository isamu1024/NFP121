package Composite.ExempleTPCommit.Composite;

/**
 * Exception simple, levée lorsque le solde n'est pas suffisemment créditeur pour le débit
 */
    public class SoldeDebiteurException extends Exception{
        public SoldeDebiteurException(){
            super();
        }
        public SoldeDebiteurException(String message){
            super(message);
        }
    }

