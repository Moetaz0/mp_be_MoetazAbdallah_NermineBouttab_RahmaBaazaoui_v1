package soa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soa.entities.Reglement;
import soa.entities.ReglementFacture;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ReglementDaoImplTest {
    private EntityManager entityManager;
    @Mock
    private ReglementDaoImpl reglementDao;

    //before each method the setUp will exucted
    //create a mock object for the EntityManager
    //create an instance of the ReglementDaoImpl class is created
    @BeforeEach
    public void setUp() {
        entityManager = mock(EntityManager.class);
        reglementDao = new ReglementDaoImpl(entityManager);
    }

    @Test
    public void testSaveReglement() {
        assertNotNull(reglementDao, "reglementDao should not be null");

        Reglement reglement = new Reglement();

        reglementDao.save(reglement);

        verify(entityManager).persist(reglement);
    }

    @Test
    public void testFindAllReglements() {

        Query query = mock(Query.class);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(new Reglement(), new Reglement()));

        List<Reglement> result = reglementDao.findAll();

        verify(entityManager).createQuery(anyString());
        verify(query).getResultList();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindOneReglement() {
        Long reglementId = 1L;
        Reglement reglement = new Reglement();
        when(entityManager.find(Reglement.class, reglementId)).thenReturn(reglement);
        Reglement result = reglementDao.findOne(reglementId);
        //verifies that the find method is called with the class type Reglement.class and the reglementId as the second argument.
        verify(entityManager).find(Reglement.class, reglementId);
        assertEquals(reglement, result);
    }
    @Test
    public void testUpdateReglement() {

        Reglement reglement = new Reglement(/* initialize your Reglement object */);


        reglementDao.update(reglement);

        verify(entityManager).merge(reglement);
    }

    @Test
    public void testDeleteReglement() {

        Long reglementId = 1L;
        Reglement reglement = new Reglement();
        when(entityManager.find(Reglement.class, reglementId)).thenReturn(reglement);


        reglementDao.delete(reglementId);


        verify(entityManager).find(Reglement.class, reglementId);
        verify(entityManager).remove(reglement);
    }



    @Test
    public void testSaveReglementFacture() {

        ReglementFacture reglementFacture = new ReglementFacture(/* initialize your ReglementFacture object */);

        reglementDao.saveReglementFacture(reglementFacture);

        verify(entityManager).persist(reglementFacture);
    }

    @Test
    public void testFindAllReglementFactures() {

        Query query = mock(Query.class);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(new ReglementFacture(), new ReglementFacture()));

        List<ReglementFacture> result = reglementDao.findAllReglementFactures();

        verify(entityManager).createQuery(anyString());
        verify(query).getResultList();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindOneReglementFacture() {

        Long reglementFactureId = 1L;
        ReglementFacture reglementFacture = new ReglementFacture();
        when(entityManager.find(ReglementFacture.class, reglementFactureId)).thenReturn(reglementFacture);

        ReglementFacture result = reglementDao.findOneReglementFacture(reglementFactureId);

        verify(entityManager).find(ReglementFacture.class, reglementFactureId);
        assertEquals(reglementFacture, result);
    }

    @Test
    public void testUpdateReglementFacture() {

        ReglementFacture reglementFacture = new ReglementFacture(/* initialize your ReglementFacture object */);

        reglementDao.updateReglementFacture(reglementFacture);


        verify(entityManager).merge(reglementFacture);
    }

    @Test
    public void testDeleteReglementFacture() {

        Long reglementFactureId = 1L;
        ReglementFacture reglementFacture = new ReglementFacture();
        when(entityManager.find(ReglementFacture.class, reglementFactureId)).thenReturn(reglementFacture);

        reglementDao.deleteReglementFacture(reglementFactureId);

        verify(entityManager).find(ReglementFacture.class, reglementFactureId);
        verify(entityManager).remove(reglementFacture);
    }

    @Test
    public void testFindByDateReglementFacture() {

        Date date = new Date();
        Query query = mock(Query.class);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(Arrays.asList(new ReglementFacture(), new ReglementFacture()));


        List<ReglementFacture> result = reglementDao.findByDateReglementFacture(date);
        verify(entityManager).createQuery(anyString());
        verify(query).setParameter(anyString(), any());
        verify(query).getResultList();
        assertEquals(2, result.size());
    }
}
