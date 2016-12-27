package niit.com.Proj2.Dao;

import java.util.List;

import niit.com.Proj2.Model.Job;

public interface JobDao {
	void postJob(Job job);
	List<Job> getAllJobs();
}
