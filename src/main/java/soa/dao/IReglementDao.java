package soa.dao;


import soa.entities.Reglement;
import soa.entities.ReglementFacture;

import java.util.Date;
import java.util.List;


public interface IReglementDao
{
	Reglement save (Reglement r);
	List<Reglement> findAll();
	Reglement findOne(Long id);
	Reglement update (Reglement p);
	void delete (Long id);
	List<Reglement> findByDate( Date date);
	ReglementFacture saveReglementFacture(ReglementFacture reglementFacture);


	}
