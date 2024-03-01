package ecs.business.abstracts;

import java.util.List;

import ecs.entities.concretes.User;

public interface UserCheckService {

	boolean checkFirstName(String firstName);
	boolean checkLastName(String lastName);
	boolean checkMail(String eMail);
	boolean checkMailIsUseable(String eMail, List<User> users);
	boolean checkPassword(String password);
	boolean isValidUser(User user);
	
}
