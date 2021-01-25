package proxy;

import java.util.*;
import container.*;

public class ProxyTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{

        ApplicationContext ctx = Factory.createApplicationContext("./proxy/README.TXT");
        Client client = ctx.getBean("client");
        System.out.print("requete en http://jfod.cnam.fr: ");
        System.out.println(client.executer("http://jfod.cnam.fr"));

        System.out.print("requete en http://www.google.com: ");
        System.out.println(client.executer("http://www.google.com"));

    }
    public void testSansInjection(){
        Requete reel = new Reel();
        // Proxy proxy = new Proxy(); // variabilit� ici
        Proxy1 proxy = new Proxy1();
        proxy.setFiltre(".fr");
        proxy.setRequete(reel);
        Client client = new Client();
        client.setRequete(proxy);
        System.out.print("requete en http://jfod.cnam.fr: ");
        System.out.println(client.executer("http://jfod.cnam.fr"));

        System.out.print("requete en http://www.google.com: ");
        System.out.println(client.executer("http://www.google.com"));

    }
}

