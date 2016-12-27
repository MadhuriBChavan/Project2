package niit.com.Proj2.Dao;

import java.util.List;

import niit.com.Proj2.Model.User;

public interface UserDao {
	User authenticate(User user);
	void updateUser(User user);
	List<User> getAllUsers();
	User registerUser(User user);
}
