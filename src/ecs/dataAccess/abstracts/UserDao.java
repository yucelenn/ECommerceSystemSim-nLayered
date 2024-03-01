package ecs.dataAccess.abstracts;

import java.util.List;

import ecs.entities.concretes.User;

public interface UserDao {

	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> getAllUsers();
	User getUserById(int id);
	
}
