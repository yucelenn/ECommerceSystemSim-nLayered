package ecs.business.concretes;

import java.util.List;

import ecs.business.abstracts.UserCheckService;
import ecs.business.abstracts.UserService;
import ecs.dataAccess.abstracts.UserDao;
import ecs.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private UserCheckService userCheckService = new UserCheckManager();
	
	public UserManager() {

	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;

	}

	@Override
	public void createAccount(User user) {

		if( (userCheckService.checkMailIsUseable(user.geteMail(), userDao.getAllUsers())) && (userCheckService.isValidUser(user)) ) {
		
			userDao.addUser(user);
		}
		else {
			if( !userCheckService.checkMail(user.geteMail()) ){
				System.out.println("E-mail geçersiz, lütfen e mail formatında bir e-mail giriniz!");
			}
		}
	}

	@Override
	public void updateAccount(User user, String fName, String lName, String eMail, String password) {

		user.setFirstName(fName);
		user.setLastName(lName);
		user.seteMail(eMail);
		user.setPassword(password);
		getAll().set(user.getId(), user);
		userDao.updateUser(user);
	}

	@Override
	public void deleteAccount(User user) {
		
		userDao.deleteUser(user);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAllUsers();
	}
	
	@Override
	public User getUserById(int id) {
		
		for (User user : getAll()) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByEmail(String eMail) {
		
		for (User user : getAll()) {
			if (user.geteMail().equals(eMail) ){
				return user;
			}
		}
		return null;
	}

}
