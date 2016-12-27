package niit.com.Proj2.RestController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import niit.com.Proj2.Dao.JobDao;
import niit.com.Proj2.Model.Job;
import niit.com.Proj2.Model.User;
import niit.com.Proj2.Model.UserError;
import niit.com.Proj2.Services.JobService;

@RestController
public class JobController {
	
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private JobDao jobDao;

	@Autowired
	private JobService jobService;

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping(value = "/postJob", method = RequestMethod.POST)
	public ResponseEntity<?> postJob(@RequestBody Job job, HttpSession session) {
		User user = (User) session.getAttribute("user");
		//System.out.println("User Object="+user.getRole());
		if (user == null) {
		        System.out.println("User is Null");
			    UserError error = new UserError(1, "Unauthorized User.....Login using valid credentials");
			return new ResponseEntity<UserError>(error, HttpStatus.UNAUTHORIZED);
		} 
		else {
			String role = user.getRole();
			             if (role.equals("Admin")) {
				                   job.setPostedOn(new Date());
				               jobDao.postJob(job );
			      	return new ResponseEntity<Void>(HttpStatus.OK);
			}
			
				else
				{
				UserError error = new UserError(2, "Only Admin can post new jobs");
				return new ResponseEntity<UserError>(error, HttpStatus.UNAUTHORIZED);

			}
		}
	}
	

	@RequestMapping(value = "/allJobs", method = RequestMethod.GET)
	public @ResponseBody List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}

	public ResponseEntity<?> getAllJobs(HttpSession session){
		User user = (User) session.getAttribute("user");
		if (user == null) {
			UserError error = new UserError(1, "Unauthorized User.....Login using valid credentials");
			return new ResponseEntity<UserError>(error, HttpStatus.UNAUTHORIZED);
		}
		System.out.println("USER OBJECT"+ user.getRole());
		List<Job> jobs=jobDao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);

	}
	
}