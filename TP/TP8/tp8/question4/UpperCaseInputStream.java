package question4;

import javax.swing.text.AttributeSet;
import java.io.InputStream;
import java.io.IOException;
import java.io.FilterInputStream;

/**
 * Cette classe "décore" un fichier (InputSream) par la conversion de tous
 * les caractères Minuscule en Majuscule
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class UpperCaseInputStream  extends FilterInputStream {

    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c == -1)
            return -1;
        else
            return Character.toUpperCase(c);
    }

    @Override
    public int read(byte b[]) throws IOException {
        return this.read(b, 0, b.length);
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off ; i < off + result ; i++)
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        return result;
    }
}
