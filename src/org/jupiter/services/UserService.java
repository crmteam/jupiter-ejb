package org.jupiter.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.jupiter.beans.user.UserBeanLocal;
import org.jupiter.entities.Address;
import org.jupiter.entities.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@WebService(name = "http.jupiter.org")
public class UserService {

	/**
	 * Default constructor.
	 */
	public UserService() {
	}

	@EJB
	private UserBeanLocal userBean;

	@WebMethod(action = "add")
	public void addUser(@WebParam(name = "firstname") String firstname,
			@WebParam(name = "lastname") String lastname,
			@WebParam(name = "login") String login,
			@WebParam(name = "email") String email,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "street") int street,
			@WebParam(name = "city") String city,
			@WebParam(name = "zipcode") String zipcode,
			@WebParam(name = "country") String country) {

		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setContry(country);
		address.setZipcode(zipcode);

		User user = new User();

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setLogin(login);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);

		if (null != firstname || null != lastname) {

			userBean.addUser(user);
		}
	}

	@WebMethod(action = "remove")
	public void deleteUser(@WebParam(name = "user") User user) {

		if (null != user) {

			userBean.deleteUser(user);
		}
	}

	@WebMethod(action = "all")
	public List<User> findAllUsers() {
		return userBean.findAllUsers();
	}

}
