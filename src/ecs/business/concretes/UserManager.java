package ecs.business.concretes;

import java.util.List;

import ecs.business.abstracts.UserCheckService;
import ecs.business.abstracts.UserService;
import ecs.business.abstracts.ValidationCheckService;
import ecs.business.concretes.validators.EMailValidationCheckManager;
import ecs.dataAccess.abstracts.UserDao;
import ecs.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private UserCheckService userCheckService = new UserCheckManager();
	private ValidationCheckService validationCheckService = new EMailValidationCheckManager();
			
	public UserManager() {

	}

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;

	}

	@Override
	public void createAccount(User user) {

		if( (userCheckService.checkMailIsUseable(user.geteMail(), userDao.getAllUsers())) && (userCheckService.isValidUser(user)) ) {
			
			System.out.println("Doğrulama e-postası gönderildi."); //doğrulama e-posta gönderimi simülasyonu buraya metod yerleştirilebilir.
			if(validationCheckService.validate()) {//doğrulama e-postasına tıklandı simülasyonu
				userDao.addUser(user);
			}

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
	public User getUserById(int id) throws Exception {
		
		for (User user : getAll()) {
			if (user.getId()==id) {
				return user;
			}
		}
		throw new Exception("Id bulunamadı, bu id'de kayıtlı kullanıcı yok!");
	}

	@Override
	public User getUserByEmail(String eMail) throws Exception {
		
		for (User user : getAll()) {
			if (user.geteMail().equals(eMail) ){
				return user;
			}
		}	
		throw new Exception("E-posta bulunamadı, bu e-postaya kayıtlı kullanıcı yok!");		
	}

	@Override
	public void logIn(String eMail, String password) throws Exception {
			
		if ( getUserByEmail(eMail).getPassword().equals(password) ) {
			System.out.println(getUserByEmail(eMail).getFirstName() + getUserByEmail(eMail).getLastName() + " giriş yaptı.");
			return;
		}
		else {
			System.out.println("Parola yanlış, lütfen bilgilerinizi kontrol ediniz!");
		}	
	}

	@Override
	public void logOut(User user) {
		
		System.out.println(user.getFirstName() + user.getLastName() + " çıkış yaptı.");
	}

}
