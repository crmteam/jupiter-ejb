package org.jupiter.beans.user;

import java.util.List;

import javax.ejb.Local;

import org.jupiter.entities.User;

@Local
public interface UserBeanLocal {

	public void addUser(User user);
	
	public User findUser(int id);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> findAllUsers();

	public User findByLoginPass(String login, String pass);

	User authentificate(String login, String pwd);

}
