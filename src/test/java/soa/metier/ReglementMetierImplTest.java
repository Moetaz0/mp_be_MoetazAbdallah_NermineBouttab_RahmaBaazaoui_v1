package soa.metier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import soa.entities.Reglement;
import soa.repository.ReglementRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ReglementMetierImplTest {

    @Mock
    private ReglementRepository reglementRepository;

    @InjectMocks
    private ReglementMetierImpl reglementMetier;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void ajouterReglementTest() {

        Reglement reglementToSave = new Reglement(); // Create a Reglement object with the necessary properties


        when(reglementRepository.save(any(Reglement.class))).thenReturn(reglementToSave);


        reglementMetier.ajouterReglement(reglementToSave);
        verify(reglementRepository, times(1)).save(eq(reglementToSave));
    }

    @Test
    void getAllReglements() {
        List<Reglement> expectedReglements = Arrays.asList(new Reglement(/* initialize with required values */));
        when(reglementRepository.findAll()).thenReturn(expectedReglements);

        List<Reglement> result = reglementMetier.getAllReglements();

        verify(reglementRepository, times(1)).findAll();

        assertEquals(expectedReglements, result);
    }
}

