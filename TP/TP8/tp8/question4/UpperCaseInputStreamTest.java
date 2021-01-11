package question4;

import java.io.*;
import java.net.*;

public class UpperCaseInputStreamTest extends junit.framework.TestCase{

  public void testAccès_README_TXT(){
    try{
      InputStream is = new BufferedInputStream( new FileInputStream(new File("README.TXT")));
	    int c = is.read();
	    assertTrue(" erreur de lecture ???", c!= -1);
	    is.close();
	  }catch(Exception e){
	    fail(" Erreur sur ce fichier : README.TXT ??? " + e.getMessage());
	   }
	}
	
	public void testUpperCase_README_TXT() throws Exception{
//    InputStream is = new BufferedInputStream( new FileInputStream(new File("README.TXT")));   // déclaration à décorer ....

		InputStream is = new UpperCaseInputStream(new FileInputStream(new File("question4\\README.TXT")));

	  int c = is.read();
	  while( c != -1){
	    assertTrue("erreur !, '" + Character.valueOf((char)c) + "' ne semble pas être une majuscule ...", Character.isUpperCase((char)c) || (char)c==' ');  
	    c = is.read();
	  }

	  is.close();
	}
	
	public void testPushPackUpperCase_README_TXT() throws Exception{
		StringBuilder output = new StringBuilder();
		PushbackInputStream pbis = new PushbackInputStream( new UpperCaseInputStream(new FileInputStream(new File("question4\\README.TXT"))));

		int count = 0;
		int c = pbis.read();

		// Sans le unread()
		while(count < 5){
			output.append((char) c);
			c = pbis.read();
			count++;
		}

		pbis.close();

		assertEquals("TESTS", output.toString());

		output.delete(0, output.length());
		count = 0;

		// Avec le unread()
		PushbackInputStream pbis2 = new PushbackInputStream( new UpperCaseInputStream(new FileInputStream(new File("question4\\README.TXT"))));

		c = pbis2.read();

		while(count < 5){
			output.append((char) c);
			pbis2.unread(c);
			c = pbis2.read();
			count++;
		}

		assertEquals("TTTTT", output.toString());

		pbis2.close();

	}

	public void testInputStream() throws Exception {

		InputStream is = new UpperCaseInputStream(new FileInputStream(new File("question4\\README.TXT")));
		 int c = is.read();
		while( c != -1){
			System.out.print((char) c);
			c = is.read();
		}
		is.close();
	}

	public void testInpustreamWithByte() throws Exception{
		InputStream is = new UpperCaseInputStream(new FileInputStream(new File("question4\\README.TXT")));

		byte[] data = new byte[7];
		int byteRead = is.read(data, 2, 4);

		while(byteRead != -1) {

			for (int i = 0; i < 2; i++) {
				data[i] = (byte) 'Z';
			}

			for (byte b : data)
				System.out.print((char) b);
			byteRead = is.read(data);
		}
		is.close();
	}
}
