package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import soa.entities.ReglementFacture;
import soa.repository.ReglementFactureRepository;

public class ReglementFactureMetierImpl implements ReglementFactureInterface {
    @Autowired
    private ReglementFactureRepository ReglementFacture;
    @Override
    public void ajouterReglement(ReglementFacture R)
    {
        ReglementFacture.save(R);
    }
}
