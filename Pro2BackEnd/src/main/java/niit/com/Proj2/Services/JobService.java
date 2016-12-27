package niit.com.Proj2.Services;

import java.util.List;

import niit.com.Proj2.Model.Job;

public interface JobService {
	void postJob(Job job);
	List<Job> getAllJobs();
}
