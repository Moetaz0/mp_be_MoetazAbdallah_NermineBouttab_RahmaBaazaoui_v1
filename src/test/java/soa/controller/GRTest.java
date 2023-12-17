package soa.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import soa.entities.Facture;
import soa.entities.Reglement;
import soa.entities.ReglementFacture;
import soa.repository.FactureR;
import soa.repository.ReglementFactureRepository;
import soa.repository.ReglementRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GRTest {
    private MockMvc mockMvc;

    @Mock
    private ReglementRepository reglementRepository;

    @Mock
    private ReglementFactureRepository reglementFactureRepository;

    @Mock
    private FactureR factureRepository;

    @InjectMocks
    private GR gr;



    @Test
    void getAll() {
        //when the findAll() is called from the repository and interact correctly
        // it should return two reglements objects
        when(reglementRepository.findAll()).thenReturn(Arrays.asList(new Reglement(), new Reglement()));
        //the method getAll() is called and the resutls will be stored in variable
        List<Reglement> result = gr.getAll();
        //checking that the results is correct
        assertEquals(2, result.size());
    }

    @Test
    void getReglement() {
        //id is set
        Long id = 1L;
        //when the findById() is called from the repository and interact correctly
        // it should return one reglement object with specified
        when(reglementRepository.findById(id)).thenReturn(Optional.of(new Reglement()));
        //the method getReglement() is called and the resutls will be stored in variable
        Reglement result = gr.getReglement(id);
        //checking that the results
        assertEquals(Optional.of(new Reglement()).get(), result);
    }

    @Test
    void deleteReglement() {
        //id is set
        Long id = 1L;
        //when the DeleteById is called from the repository and interact correctly
        // it should do the deletion operation and do nothing
        doNothing().when(reglementRepository).deleteById(id);
        //the method DeleteById() is called and the resutls will be stored in variable
        ResponseEntity<String> result = gr.deleteReglement(id);
        //checking that the status of httpStatus
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


    @Test
    void saveReglementFacture() {
        //make an instance for reglement
        Reglement reglement = new Reglement();
        //make an instance for Facture
        Facture facture = new Facture();
        //make an instance for reglementFacture
        ReglementFacture reglementFacture = new ReglementFacture(facture, reglement, 10.5);
        //intract with the repository and call the method findById()
        // it should return one facture object with specified id
        when(factureRepository.findById(facture.getIdF())).thenReturn(Optional.of(facture));
        //intract with the repository and call the method findById()
        // it should return one reglement object with specified id
        when(reglementRepository.findById(reglement.getId())).thenReturn(Optional.of(reglement));
        //intract with the repository and call the method save()
        // it should return the ReglementFacture object
        when(reglementFactureRepository.save(any(ReglementFacture.class))).thenReturn(reglementFacture);

        // Call the method from the controller
        ResponseEntity<?> result = gr.saveReglementFacture(reglementFacture);

        // Assert the result
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void getAllRF() {
        //intract with the repository and call the method findById()
        // it should return all reglementFacture
        when(reglementFactureRepository.findAll()).thenReturn(Arrays.asList(new ReglementFacture(), new ReglementFacture()));

        // Call the method from the controller
        List<ReglementFacture> result = gr.getAllRF();

        // Assert the result
        assertEquals(2, result.size());
    }

}
