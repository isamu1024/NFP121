package question3Perso;

import java.util.List;

public class TestRack extends junit.framework.TestCase {

    public void testCreateRack(){
        Irack<Colis> rack = new RackContinu<>(3, 10);
        assertEquals(3 , rack.getNbCol());
        assertEquals(10 , rack.getColCapacity());
    }

    public void testAdd(){
        Irack<Colis> rack = new RackContinu<>(3, 10);
        try {
            rack.addItem(new Colis("test"));
        }catch (Exception e)
        {
            fail("Ajout en erreur");
        }
        try {
            assertEquals("test", rack.getColis(0, 0).getName());
        } catch (Exception e) {
            fail("Obtention du nom de colis en erreur");
        }
    }

    public void testMultipleAdd(){
        Irack<Colis> rack = new RackContinu<>(3, 1);
        try{
            rack.addItem(new Colis("Cadeau"));
            rack.addItem(new Colis("Cadeau"));
            rack.addItem(new Colis("Cadeau"));
        } catch (Exception e)
        {
            fail("ajout en erreur");
        }
        assertTrue(rack.estPlein());
        assertFalse(!rack.estPlein());
    }

    public void testNotFull(){
        Irack<Colis> rack = new RackContinu<>(3, 1);
        try {
            rack.addItem(new Colis("Cadeau"));
            rack.addItem(new Colis("Cadeau"));
        } catch (Exception e) {
            fail("ajout en erreur");
        }

        assertFalse(rack.estPlein());
    }

    public void testRemove()  {
        Irack<Colis> rack = new RackContinu<>(3, 2);
        try {
            rack.addItem(new Colis("Cadeau"));
            rack.addItem(new Colis("Cadeau2"));
            rack.addItem(new Colis("Cadeau3"));
            rack.addItem(new Colis("Cadeau4"));
            rack.addItem(new Colis("Cadeau5"));
            rack.addItem(new Colis("Cadeau6"));
        } catch (Exception e) {
            fail("ajout en erreur");
        }

        try {
            assertEquals("Cadeau2", rack.removeItem(0,1).getName());
        } catch (Exception e) {
            fail("remove en erreur");
        }
    }

    public void testFreeSlots() {
        Irack<Colis> rack = new RackContinu<>(3, 2);
        try {
            rack.addItem(new Colis("Cadeau"));
            rack.addItem(new Colis("Cadeau2"));
            rack.addItem(new Colis("Cadeau3"));
            rack.addItem(new Colis("Cadeau4"));
            rack.addItem(new Colis("Cadeau5"));
            rack.addItem(new Colis("Cadeau6"));
        } catch (Exception e) {
            fail("ajout en erreur");
        }
        assertEquals(0 , rack.freeSlots());

        try {
            rack.removeItem(0,1);
        } catch (Exception e) {
            fail("remove en erreur");
        }

        assertEquals(1 , rack.freeSlots());
    }

    public void testAf() {
        Irack<Colis> rack = new RackContinu<>(3, 2);
        try {
            rack.addItem(new Colis("Cadeau1"));
            rack.addItem(new Colis("Cadeau2"));
            rack.addItem(new Colis("Cadeau3"));
            rack.addItem(new Colis("Cadeau4"));
            rack.addItem(new Colis("Cadeau5"));
            rack.addItem(new Colis("Cadeau6"));
//            rack.addItem(new Colis("Cadeau6"));
        } catch (Exception e) {
            fail("ajout en erreur");
        }
        Colis[][] af = (Colis[][]) rack.af();
        assertTrue(af.length == rack.getNbCol());

        Colis colis;
        Colis colisAf;

        for (int i = 0; i < rack.getNbCol(); i++){
            for (int j = 0; j < rack.getColCapacity() ; j++) {
                try {
                    colis = rack.getColis(i,j);
                    colisAf = af[i][j];
                    assertTrue(colis.getName().equals(colisAf.getName()));
                } catch (Exception e) {
                    fail("oups");
                }
            }
        }
    }

    public void testRackDecorator() {
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 2));
        try {
            afDecoRack.addItem(new Colis("PS5"));
        } catch (Exception e) {
            fail("Oups");
        }
        try {
            afDecoRack.addItem(new Colis("Xbox"));
            afDecoRack.addItem(new Colis("Cheval en bois"));
            afDecoRack.addItem(new Colis("Harley Street Rod"));

        } catch (Exception e) {
            fail("Oups");
        }

        try {
            afDecoRack.removeItem(0,0);
        } catch (Exception e) {
            fail("erreur dans removeItem du decorateur");
        }
    }

    public void  testRackDecoratorIsFull(){
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 1));
        try{
            afDecoRack.addItem(new Colis("UnRepasAvecMaBelleMereCestPasUnCadeau"));
            afDecoRack.addItem(new Colis("UnRepasSansLesEnfantsCestUnVraiCadeau"));
            afDecoRack.addItem(new Colis("PasDeBraSPasDeChocolat"));
        } catch (Exception e)
        {
            fail("ajout en erreur");
        }
        assertTrue(afDecoRack.estPlein());

        try {
            afDecoRack.removeItem(2,0);
        } catch (Exception e) {
            fail("erreur dans removeItem du decorateur");
        }

        assertFalse(afDecoRack.estPlein());
    }

    public void testRackDecoratorNbCol(){
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 1));
        assertEquals(3, afDecoRack.getNbCol());
        Irack<Colis> afDecoRack0 = new RackAf<>(new RackContinu<>(0, 0));
        assertEquals(0, afDecoRack0.getNbCol());
    }

    public void testRackDecoratorColCapacity(){
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 4));
        assertEquals(4, afDecoRack.getColCapacity());
    }

    public void testRackDecoratorGetColis(){
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 1));
        try{
            afDecoRack.addItem(new Colis("UnRepasAvecMaBelleMereCestPasUnCadeau"));
            afDecoRack.addItem(new Colis("UnRepasSansLesEnfantsCestUnVraiCadeau"));
            afDecoRack.addItem(new Colis("PasDeBraSPasDeChocolat"));
        } catch (Exception e)
        {
            fail("ajout en erreur");
        }

        Colis colis = null;

        try {
            colis = afDecoRack.getColis(0, 0);
        } catch (Exception e) {
            fail("Retrait en erreur");
        }

        assertEquals("UnRepasAvecMaBelleMereCestPasUnCadeau", colis.getName());
    }

    public void testRackDecoratorFreeSlots(){
        Irack<Colis> afDecoRack = new RackAf<>(new RackContinu<>(3, 1));

        assertEquals(3 , afDecoRack.freeSlots());

        try{
            afDecoRack.addItem(new Colis("UnRepasAvecMaBelleMereCestPasUnCadeau"));
            assertEquals(2 , afDecoRack.freeSlots());
            afDecoRack.addItem(new Colis("UnRepasSansLesEnfantsCestUnVraiCadeau"));
            assertEquals(1 , afDecoRack.freeSlots());
        } catch (Exception e)
        {
            fail("ajout ou vérification en erreur");
        }
    }

    public void testRackDecoratorRepoOK(){
        Irack<Colis> afDecoRack = new RackRepOk<>(new RackContinu<>(3, 2));
        try {
            afDecoRack.addItem(new Colis("PS5"));
        } catch (Exception e) {
            fail("Oups");
        }
        try {
            afDecoRack.addItem(new Colis("Xbox"));
            afDecoRack.addItem(new Colis("Cheval en bois"));
            afDecoRack.addItem(new Colis("Harley Street Rod"));

        } catch (Exception e) {
            fail("Oups");
        }

        try {
            afDecoRack.removeItem(0,0);
        } catch (Exception e) {
            fail("erreur dans removeItem du decorateur");
        }

        assertFalse(afDecoRack.estPlein());

        try {
            afDecoRack.addItem(new Colis("cadeauMystere"));
            afDecoRack.addItem(new Colis("cadeauMystere"));
            afDecoRack.addItem(new Colis("cadeauMystere"));
        } catch (Exception e) {
            fail("Oups");
        }
        assertTrue(afDecoRack.estPlein());

        assertEquals(3, afDecoRack.getNbCol());
        assertEquals(2, afDecoRack.getColCapacity());

        try {
            assertEquals("Xbox", afDecoRack.getColis(0, 0).getName());
        }catch (Exception e){
          fail("retrait du colis en erreur");
        }

        assertEquals(0, afDecoRack.freeSlots());

        try {
            afDecoRack.removeItem(0,0);
        } catch (Exception e) {
            fail("erreur dans removeItem du decorateur");
        }

        assertEquals(1, afDecoRack.freeSlots());

    }

}
