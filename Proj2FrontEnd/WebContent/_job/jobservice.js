app.factory('JobService',function($http){
	var BASE_URL="http://localhost:8085/Pro2BackEnd";
		var jobService={};
		jobService.saveJob=function(job){
			return $http.post(BASE_URL + "/postJob" ,job)
			
		}
			
		jobService.getAllJobs=function()
		{
		console.log('Entering fetchAllJobs in service');
		return $http.get(BASE_URL + "/allJobs")
		
		}

	  return jobService;
})