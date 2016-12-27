package niit.com.Proj2.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import niit.com.Proj2.Dao.JobDao;
import niit.com.Proj2.Model.Job;
import niit.com.Proj2.Services.JobService;
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;
	

	public void postJob(Job job) {
		// TODO Auto-generated method stub
		
		jobDao.postJob(job);

	}

	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.getAllJobs();
	}

}
