package org.jupiter.beans.user;

import java.util.List;

import javax.ejb.Remote;

import org.jupiter.entities.User;

@Remote
public interface UserBeanRemote {

	public void addUser(User user);

	public User findUser(int id);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> findAllUsers();

	public User findByLoginPass(String login, String pass);

	
}
