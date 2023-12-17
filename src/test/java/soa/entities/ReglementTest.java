package soa.entities;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReglementTest {

    @Test
    public void testGettersAndSetters() {
        //create instance pour le reglement
        Reglement reglement = Mockito.mock(Reglement.class);
        //recuperer les donner
        Long expectedId = 1L;
        String expectedCode = "ABC";
        String expectedType = "TypeB";
        double expectedMp = 200.0;
        String expectedDate = "2023-02-01";
        //getting les valeur de reglemnet
        when(reglement.getId()).thenReturn(expectedId);
        when(reglement.getCode()).thenReturn(expectedCode);
        when(reglement.getType()).thenReturn(expectedType);
        when(reglement.getMp()).thenReturn(expectedMp);
        when(reglement.getDate()).thenReturn(expectedDate);
        //assert equals les valeur
        assertEquals(expectedId, reglement.getId());
        assertEquals(expectedCode, reglement.getCode());
        assertEquals(expectedType, reglement.getType());
        assertEquals(expectedMp, reglement.getMp());
        assertEquals(expectedDate, reglement.getDate());
        //setter
        reglement.setCode("ABC");
        reglement.setType("TypeB");
        reglement.setMp(200.0);
        reglement.setDate("2023-02-01");
        //assert equals les valeur
        assertEquals("ABC", reglement.getCode());
        assertEquals("TypeB", reglement.getType());
        assertEquals(200.0, reglement.getMp());
        assertEquals("2023-02-01", reglement.getDate());
    }

    //toString method
    @Test
    public void testToString() {
        Reglement reglement = new Reglement(150.0, "2023-03-01", "DEF", "TypeC");
        assertEquals("Reglement [id=null, Montant paye=150.0, date=2023-03-01]", reglement.toString());
    }
}
