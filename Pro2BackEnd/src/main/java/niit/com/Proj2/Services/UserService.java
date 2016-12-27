package niit.com.Proj2.Services;

import java.util.List;

import niit.com.Proj2.Model.User;

public interface UserService {
	List<User> getAllUsers();
	User registerUser(User user);

}
