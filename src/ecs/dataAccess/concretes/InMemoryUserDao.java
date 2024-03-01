package ecs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ecs.dataAccess.abstracts.UserDao;
import ecs.entities.concretes.User;

public class InMemoryUserDao implements UserDao {  //local database olarak 

	public List<User> userList = new ArrayList<User>();
	
	@Override
	public void addUser(User user) {
	
		userList.add(user);
		System.out.println("In memory kaydedildi. Id:" + user.getId() + " " + user.geteMail());
	}

	@Override
	public void updateUser(User user) {
		
		userList.set(user.getId(), user);
		System.out.println("In memory güncellendi. Id:" + user.getId() + " " + user.geteMail());		
	}

	@Override
	public void deleteUser(User user) {

		userList.remove(user);
		System.out.println("In memory silindi. id:" + user.getId() + " " + user.geteMail());	
	}

	@Override
	public List<User> getAllUsers() {
		
		return userList;
	}

	@Override
	public User getUserById(int id) {
		
		for (User user : this.getAllUsers()) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

}
