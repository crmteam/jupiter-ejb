package org.jupiter.beans.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jupiter.entities.User;

/**
 * Session Bean implementation class UserBeanImpl
 */
@Stateless
public class UserBeanImpl implements UserBeanRemote, UserBeanLocal {

	@PersistenceContext(unitName = "JUPITER_PU")
	private EntityManager em;

	public UserBeanImpl() {
	}

	public void addUser(User u) {
		em.persist(u);
	}

	@Override
	public User findUser(int id) {
		 User user = em.find(User.class, id);	
		 return user;
	}

	@Override
	public void updateUser(User user) {
			em.merge(user);		
	}

	@Override
	public void deleteUser(User user) {
		user =findUser(user.getId());
		if(user != null){
			em.remove(user);
		}
		
	}
	
	public List<User> findAllUsers(){
		TypedQuery<User> users = em.createNamedQuery("User.findAllUsers", User.class);
		return users.getResultList();
	}
	
	
	/**
	 * get user login and password
	 */
	@Override
	public User findByLoginPass(String login, String pass) {
		TypedQuery<User> queryUsers = em.createNamedQuery("User.findByPassLogin", User.class);
		queryUsers.setParameter("login", login);
		queryUsers.setParameter("password", pass);
		User user = queryUsers.getSingleResult();
		return user;
	}
	
	
	@Override
	public User authentificate(String login, String pwd) {
		User user=null;
		Query query=em.createQuery("select u from User u where u.email=:l and u.pwd=:p");
		query.setParameter("l", login).setParameter("p", pwd);
		try {
			user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		return user;
	}
}
