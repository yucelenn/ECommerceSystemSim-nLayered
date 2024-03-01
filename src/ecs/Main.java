package ecs;

import ecs.business.concretes.UserManager;
import ecs.dataAccess.concretes.InMemoryUserDao;
import ecs.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "Yücelen", "Üstün", "yucelenn@hotmail.com", "yuyuyu");
		User user2 = new User(2, "Ali", "Üstün", "aliustun@hotmail.com", "alalal");
		User user3 = new User(3, "Zahide", "Üstün", "zahideustun@hotmail.com", "zazazaza");
		
		UserManager manager = new UserManager(new InMemoryUserDao());
		
		manager.createAccount(user1);
		manager.createAccount(user2);
		manager.createAccount(user3);
		
		//manager.deleteAccount(user1);
		
		manager.updateAccount(user1, "yüco", "üstün", "yucelen@hotmail.com", "yuyuyu");
		System.out.println(manager.getAll().size());

	}

}
