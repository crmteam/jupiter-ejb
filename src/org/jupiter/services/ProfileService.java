package org.jupiter.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.jupiter.beans.profile.ProfileBeanLocal;
import org.jupiter.entities.Acl;
import org.jupiter.entities.Profile;


/**
 * Session Bean implementation class ProfileService
 */
@Stateless
@WebService(name = "http.jupiter.org")
public class ProfileService {

	@EJB
	private ProfileBeanLocal profileBean;

	public ProfileService() {
	}
	
	@WebMethod(action = "add")
	public void addProfile(@WebParam(name = "profilename") String userprofile,
			@WebParam(name = "acl") List<Acl> acls) {
	
		

		Profile profile = new Profile();
		
		profile.setUserProfile(userprofile);
		profile.setAcls(acls);
		
		profileBean.addProfile(profile);
	}

	@WebMethod(action = "remove")
	public void deleteProfile(@WebParam(name = "profilename") Profile profile) {

		if (null != profile) {

			profileBean.deleteProfile(profile);;
		}
	}
	
	
	@WebMethod(action = "all")
	public List<Profile> findAllProfile() {
		return profileBean.findAllProfile();
	}

}
