package ecs.business.abstracts;

import java.util.List;

import ecs.entities.concretes.User;

public interface UserService {

	void createAccount(User user);
	void updateAccount(User user, String fName, String lName, String eMail, String password);
	void deleteAccount(User user);
	List<User> getAll();
	User getUserById(int id) throws Exception;
	User getUserByEmail(String  eMail) throws Exception;
	void logIn(String eMail, String password) throws Exception;
	void logOut(User user);
	
}
