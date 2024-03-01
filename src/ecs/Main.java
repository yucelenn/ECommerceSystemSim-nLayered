package ecs;

import ecs.business.concretes.UserManager;
import ecs.business.concretes.adapters.Adapter;
import ecs.business.concretes.adapters.GoogleIntegrationManager;
import ecs.business.concretes.adapters.YandexIntegrationManager;
import ecs.dataAccess.concretes.InMemoryUserDao;
import ecs.entities.concretes.User;

public class Main {

	public static void main(String[] args) throws Exception {

		User user1 = new User(1, "Şahin", "Üstün", "sahin@hotmail.com", "sasasa");
		User user2 = new User(2, "Ali", "Üstün", "aliustun@hotmail.com", "alalal");
		User user3 = new User(3, "Zahide", "Üstün", "zahideustun@hotmail.com", "zazazaza");
		
		UserManager manager = new UserManager(new InMemoryUserDao());
		
		manager.createAccount(user1);
		System.out.println("***********************************************");
		manager.createAccount(user2);
		System.out.println("***********************************************");
		manager.createAccount(user3);
		System.out.println("***********************************************");
		
		//manager.deleteAccount(user1);
		
		manager.updateAccount(user1, "Yücelen", "Üstün", "yuce@hotmail.com", "yuyuyu");
		//System.out.println(manager.getAll().size());
		System.out.println("***********************************************");

		manager.logIn("yuce@hotmail.com", "yuyuyu");
		System.out.println("***********************************************");
		
		Adapter adapter = new Adapter(new GoogleIntegrationManager());
		
		manager.createAccount(adapter.getUserFromAdapter()); //google dan bilgileri alıp yeni kullanıcı oluşturma simülasyonu

	}	


}
