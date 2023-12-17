package soa.metier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soa.entities.ReglementFacture;
import soa.repository.ReglementFactureRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReglementFactureMetierImplTest {

    @Mock
    private ReglementFactureRepository reglementFactureRepository;

    @InjectMocks
    private ReglementFactureMetierImpl reglementFactureMetier;

    @Test
    void ajouterReglement() {
        ReglementFacture reglementFacture = new ReglementFacture();

        when(reglementFactureRepository.save(any(ReglementFacture.class))).thenAnswer(invocation -> {

            return reglementFacture;
        });



        reglementFactureMetier.ajouterReglement(reglementFacture);
        verify(reglementFactureRepository).save(reglementFacture);
    }
}

