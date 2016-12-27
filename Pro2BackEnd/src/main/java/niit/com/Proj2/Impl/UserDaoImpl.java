package niit.com.Proj2.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.Proj2.Dao.UserDao;
import niit.com.Proj2.Model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired 
	private SessionFactory sessionFactory;
	@Autowired
	private UserDao userDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User authenticate(User user) {
		logger.debug("USERDAOIMPL :: AUTHENTICATE");
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where username=?  and password=?");
		query.setString(0,user.getUsername());
		query.setString(1, user.getPassword());
		User validUser=(User) query.uniqueResult();
		session.close();
		if(validUser!=null)
			logger.debug("VALID USER IS  " + validUser.getUsername() + " " + validUser.getRole() + " " + validUser.isOnline());;
			if(validUser==null)
				logger.debug("Valid USER is null");
		return validUser;
	}

	public void updateUser(User user) {
		logger.debug("USERDAOIMPL::UPDATE");
		logger.debug("ISONLINE VALUE IS [BEFORE UPDATE]" + user.isOnline());

		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			User existingUser=session.get(User.class, user.getId());
			existingUser.setOnline(user.isOnline());
			session.update(existingUser);
			session.getTransaction().commit();
			//session.flush();
			session.close();
			logger.debug("ISONLINE VALUE IS [AFTER UPDATE] " + existingUser.isOnline());

	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from User");
		List<User> users=query.list();
		session.close();
		return users;
	}

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
