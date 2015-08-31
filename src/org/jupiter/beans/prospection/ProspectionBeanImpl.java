package org.jupiter.beans.prospection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jupiter.entities.Company;
import org.jupiter.entities.Prospection;
import org.jupiter.entities.ProspectionStatus;
import org.jupiter.entities.User;

/**
 * Session Bean implementation class ProspectionBeanImpl
 */
@Stateless
public class ProspectionBeanImpl implements ProspectionBeanRemote,
		ProspectionBeanLocal {

	@PersistenceContext(unitName = "JUPITER_PU")
	private EntityManager em;

	public ProspectionBeanImpl() {
	}

	@Override
	public void addPropection(Prospection prospect) {
		Date date = getDate();
		
		prospect.setCreatedDate(date);
		prospect.setUpdateDate(date);
		
		em.persist(prospect);
	}

	@Override
	public Prospection findProspection(int id) {
				return em.find(Prospection.class, id);
	}

	@Override
	public void updateProspection(Prospection prospect) {
		
		Date date = Calendar.getInstance().getTime();
		prospect.setUpdateDate(date);
		em.merge(prospect);
	}
	
	public Date getDate() {
		
		Date dNow  = new Date( );
		Date dateSortie = null;
		 SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
		 String  strDate = ft.format(dNow);
		 try {
			 dateSortie = ft.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateSortie;
		  
		  

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findAllProspections() {
		
		Query prospects = em.createQuery("SELECT p FROM Propesction p");
		return prospects.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findProspectionByOwner(User owner) {
		Query prospects = em.createQuery("SELECT p FROM Propesction p WHERE  p.owner = :owner");
		return prospects.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findProspectionByCustomer(User customer) {
		Query prospects = em.createQuery("SELECT p FROM Propesction p WHERE  p.customer = :customer");
		return prospects.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findProspectionByCompany(Company company) {
		Query prospects = em.createQuery("SELECT p FROM Propesction p WHERE  p.company = :company");
		return prospects.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findProspectionByStatus(ProspectionStatus status) {
		Query prospects = em.createQuery("SELECT p FROM Propesction p WHERE  p.status = :status");
		return prospects.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prospection> findProspectionBySector(String sector) {
		Query prospects = em.createQuery("SELECT p FROM Propesction p WHERE  p.sector = :sector");
		return prospects.getResultList();
	}

}
