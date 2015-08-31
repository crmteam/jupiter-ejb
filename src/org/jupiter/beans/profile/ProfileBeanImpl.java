package org.jupiter.beans.profile;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jupiter.entities.Profile;

/**
 * Session Bean implementation class ProfileBeanImpl
 */
@Stateless
public class ProfileBeanImpl implements ProfileBeanRemote, ProfileBeanLocal {

	@PersistenceContext(unitName = "JUPITER_PU")
	private EntityManager em;

	public ProfileBeanImpl() {
	}

	@Override
	public void addProfile(Profile profile) {
		em.persist(profile);
	}

	@Override
	public void updateProfile(Profile profile) {
		em.merge(profile);
	}

	@Override
	public Profile findProfile(int id) {
		return em.find(Profile.class, id);
	}

	@Override
	public List<Profile> findAllProfile() {
		TypedQuery<Profile> profiles = em.createNamedQuery("Profile.findAll",Profile.class);
		return profiles.getResultList();
	}

	@Override
	public void deleteProfile(Profile profile) {
		if( null != em.find(Profile.class, profile.getId())){
			em.remove(profile);
		}

	}

}
