package org.jupiter.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.jupiter.beans.prospection.ProspectionBeanLocal;
import org.jupiter.entities.Address;
import org.jupiter.entities.Company;
import org.jupiter.entities.Prospection;
import org.jupiter.entities.ProspectionStatus;
import org.jupiter.entities.User;

/**
 * Session Bean implementation class ProspectionService
 */
@Stateless
@WebService(name = "http.jupiter.org")
public class ProspectionService {

	@EJB
	private ProspectionBeanLocal prospectionBean;

	public ProspectionService() {
	}

	@WebMethod(action = "add")
	public void addProspection(
			@WebParam(name = "customerfirstname") String firstname,
			@WebParam(name = "customerlastname") String lastname,
			@WebParam(name = "customerlogin") String login,
			@WebParam(name = "customeremail") String email,
			@WebParam(name = "customerphone") String phone,
			@WebParam(name = "customerstreet") int street,
			@WebParam(name = "customercity") String city,
			@WebParam(name = "costomerzipcode") String zipcode,
			@WebParam(name = "customercountry") String country,
			@WebParam(name = "customercompanyname") String companyName,
			@WebParam(name = "customercompanyphone") String companyPhonee,
			@WebParam(name = "customercompanywebsite") String companyWebsite,
			@WebParam(name = "customercompanysector") String CompanySector,
			@WebParam(name = "customercompanydescription") String companyDescription,
			@WebParam(name = "prospectionstatus") String prospectionStatus) {

		Address address = new Address();
		User user = new User();
		Prospection prospect = new Prospection();
		ProspectionStatus prospectStatus = new ProspectionStatus();
		Company company = new Company();

		address.setStreet(street);
		address.setCity(city);
		address.setContry(country);
		address.setZipcode(zipcode);

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setLogin(login);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);

		prospectStatus.setStatusName(prospectionStatus);

		company.setCompanyName(companyName);
		company.setDescription(companyDescription);
		company.setPhone(companyPhonee);
		company.setWebsite(companyWebsite);
		company.setSector(CompanySector);

		prospect.setCustomer(user);
		prospect.setCompany(company);
		prospect.setProspectionStatus(prospectStatus);
		prospect.setAddress(address);

		if (null != company) {
			prospectionBean.addPropection(prospect);
		}
	}

	@WebMethod(action = "remove")
	public List<Prospection> findAll(
			@WebParam(name = "prosepection") Prospection prospect) {
		List<Prospection> prospects = null;

		if (null != prospect) {

			prospects = prospectionBean.findAllProspections();

		}

		return prospects;
	}

	
	@WebMethod(action = "update")
	public void  update(@WebParam(name = "id") int id) {
		Prospection pros = prospectionBean.findProspection(id);
		prospectionBean.updateProspection(pros);
	}
}
