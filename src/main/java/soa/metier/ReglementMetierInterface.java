package soa.metier;

import soa.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface ReglementMetierInterface {

   void ajouterReglement(Reglement r);


   List<Reglement> getAllReglements();
}