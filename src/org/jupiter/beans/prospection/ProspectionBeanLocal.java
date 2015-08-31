package org.jupiter.beans.prospection;

import java.util.List;

import javax.ejb.Local;

import org.jupiter.entities.Company;
import org.jupiter.entities.Prospection;
import org.jupiter.entities.ProspectionStatus;
import org.jupiter.entities.User;

@Local
public interface ProspectionBeanLocal {
	
	public void addPropection(Prospection prospect);
	
	public Prospection findProspection(int id);
	
	public void updateProspection(Prospection prospect);
	
	public List<Prospection> findAllProspections();
	
	public List<Prospection> findProspectionByOwner(User owner);
	
	public List<Prospection> findProspectionByCustomer(User owner);
	
	public List<Prospection> findProspectionByCompany(Company company);
	
	public List<Prospection> findProspectionByStatus(ProspectionStatus status);
	
	public List<Prospection> findProspectionBySector(String sector);

}
