package org.jupiter.entities;

import java.io.Serializable;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
		@NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
	 })
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROFILE_ID")
	private int id;
	private String userprofile;
	private List<Acl> acls;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserprofile() {
		return userprofile;
	}

	public void setUserProfile(String userprofile) {
		this.userprofile = userprofile;
	}

	public List<Acl> getAcls() {
		return acls;
	}

	public void setAcls(List<Acl> acls) {
		this.acls = acls;
	}

}
