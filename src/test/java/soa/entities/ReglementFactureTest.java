package soa.entities;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class ReglementFactureTest {

    @Test
    void testGettersAndSetters() {
        //Create Instance(mock instance in real time)
        Facture mockFacture = mock(Facture.class);
        Reglement mockReglement = mock(Reglement.class);
        //create new reglement facture
        ReglementFacture reglementFacture = new ReglementFacture(mockFacture, mockReglement, 100.0);
        //getter ID
        when(mockFacture.getIdF()).thenReturn(1L);
        when(mockReglement.getId()).thenReturn(2L);
        //getter valeur
        assertSame(mockFacture, reglementFacture.getfacture());
        assertSame(mockReglement, reglementFacture.getReglement());
        assertEquals(100.0, reglementFacture.getMp());
        //create new facture
        Facture newFacture = new Facture();
        //set new facture
        newFacture.setIdF(3L);
        reglementFacture.setFacture(newFacture);
        assertSame(newFacture, reglementFacture.getfacture());
        //create new reglement
        Reglement newReglement = new Reglement();
        //set new reglement
        newReglement.setId(4L);
        reglementFacture.setReglement(newReglement);
        assertSame(newReglement, reglementFacture.getReglement());
        //set montant payer
        reglementFacture.setMp(200.0);
        assertEquals(200.0, reglementFacture.getMp());
        //toString method
        String expectedToString = "ReglementFacture{idF=" + newFacture + ", reglement=" + newReglement + ", mp=200.0}";
        assertEquals(expectedToString, reglementFacture.toString());
    }
}
