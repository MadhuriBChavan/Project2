package niit.com.Proj2.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.Proj2.Dao.JobDao;
import niit.com.Proj2.Model.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
@Autowired
private SessionFactory sessionFactory;
	
	public void postJob(Job job) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(job);
		session.getTransaction().commit();
		session.close();
	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> jobs=query.list();
		return jobs;
	}

}
