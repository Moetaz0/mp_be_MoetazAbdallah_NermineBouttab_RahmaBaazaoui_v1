package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Reglement;
import soa.repository.ReglementRepository;

import java.util.List;

@Service
public class ReglementMetierImpl implements ReglementMetierInterface {

    @Autowired
    ReglementRepository reglementRepository;

    @Override
    public void ajouterReglement(Reglement r) {
        reglementRepository.save(r);
    }



    @Override
    public List<Reglement> getAllReglements() {
        return reglementRepository.findAll();
    }
}