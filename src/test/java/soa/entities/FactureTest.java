package soa.entities;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactureTest {

    @Test
    public void testFactureGetterAndSetter() {
        //create instance
        Facture facture = Mockito.mock(Facture.class);
        //call values
        Long expectedId = 1L;
        int expectedNum = 100;
        //getting id facture et numero de facture
        when(facture.getIdF()).thenReturn(expectedId);
        when(facture.getNum()).thenReturn(expectedNum);
        assertEquals(expectedId, facture.getIdF());
        assertEquals(expectedNum, facture.getNum());
    }

    //Constructeur de test facture
    @Test
    public void testFactureConstructor() {
        Long expectedId = 1L;
        int expectedNum = 100;
        //create new facture
        Facture facture = new Facture(expectedId, expectedNum);
        //insuring that the value that we get and the expected value
        //are equales
        assertEquals(expectedId, facture.getIdF());
        assertEquals(expectedNum, facture.getNum());
    }
}
