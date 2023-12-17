package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Facture;

public interface FactureR extends JpaRepository<Facture, Long> {
}
