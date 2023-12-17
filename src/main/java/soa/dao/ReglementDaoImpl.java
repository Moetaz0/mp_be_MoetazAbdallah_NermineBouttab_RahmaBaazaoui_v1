package soa.dao;
import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import soa.entities.Reglement;
import soa.entities.ReglementFacture;

@Repository
@Transactional
public class ReglementDaoImpl implements IReglementDao{

	@PersistenceContext
	private EntityManager em;
	public ReglementDaoImpl(EntityManager entityManager) {
		this.em = entityManager;
	}
	public Reglement save(Reglement r) {
		em.persist(r);
		return r;
	}
	public List<Reglement> findAll() {
		Query query=  
      em.createQuery("select r from Reglement r order by r.id");
		return query.getResultList();
	}

	public Reglement findOne(Long id) {
		Reglement r = em.find(Reglement.class, id);
		return r;
	}

	public Reglement update(Reglement r) {
		em.merge(r);
		return r;
	}

	public void delete(Long id) {
		Reglement r = em.find(Reglement.class, id);
		em.remove(r);
		
	}

	public List<Reglement> findByDate(Date date) {
		Query query= em.createQuery("select r from Reglement r where r.date like :date");
		query.setParameter("date", "%"+date+"%");
		return query.getResultList();
	}
	public ReglementFacture saveReglementFacture(ReglementFacture reglementFacture) {
		em.persist(reglementFacture);
		return reglementFacture;
	}

	public List<ReglementFacture> findAllReglementFactures() {
		Query query = em.createQuery("select rf from ReglementFacture rf order by rf.id");
		return query.getResultList();
	}

	public ReglementFacture findOneReglementFacture(Long id) {
		ReglementFacture rf = em.find(ReglementFacture.class, id);
		return rf;
	}

	public ReglementFacture updateReglementFacture(ReglementFacture reglementFacture) {
		em.merge(reglementFacture);
		return reglementFacture;
	}

	public void deleteReglementFacture(Long id) {
		ReglementFacture rf = em.find(ReglementFacture.class, id);
		em.remove(rf);
	}

	public List<ReglementFacture> findByDateReglementFacture(Date date) {
		Query query = em.createQuery("select rf from ReglementFacture rf where rf.date like :date");
		query.setParameter("date", "%" + date + "%");
		return query.getResultList();
	}

}
