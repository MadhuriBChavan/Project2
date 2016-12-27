package niit.com.Proj2.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import niit.com.Proj2.Dao.UserDao;
import niit.com.Proj2.Model.User;
import niit.com.Proj2.Services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}


	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userDao.registerUser(user);
	}

}
