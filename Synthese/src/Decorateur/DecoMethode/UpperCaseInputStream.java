package Decorateur.DecoMethode;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream  extends FilterInputStream {

    protected  UpperCaseInputStream(InputStream in){
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
