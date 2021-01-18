package Decorateur.DecoMethode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test extends junit.framework.TestCase{

    public void testUpperCase() throws Exception{
        InputStream is = new UpperCaseInputStream(new FileInputStream(new File("src\\Decorateur\\DecoMethode\\TestFile.txt")));
        int c = is.read();
        while (c != -1){
            assertTrue("erreur !, '" + Character.valueOf((char)c) + "' ne semble pas être une majuscule ...", Character.isUpperCase((char)c) || (char)c==' ');
            c = is.read();
        }
    }
}
