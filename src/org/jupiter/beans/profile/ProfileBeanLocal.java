package org.jupiter.beans.profile;

import java.util.List;

import javax.ejb.Local;

import org.jupiter.entities.Profile;

@Local
public interface ProfileBeanLocal {
	
	public void addProfile(Profile profile);

	public void updateProfile(Profile profile);

	public Profile findProfile(int id);

	public List<Profile> findAllProfile();

	public void deleteProfile(Profile profile);
}
