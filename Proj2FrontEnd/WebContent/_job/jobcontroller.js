app.controller('JobController',function($scope, $location, JobService){
	$scope.jobs={};
	$scope.job={jobTitle:'',jobDescription:'',skillsRequired:'',salary:'',location:''};
	
	$scope.saveJob=function(){
		console.log('Entering in saveJob method in JobController');
		JobService.saveJob($scope.job)
		.then(function(response){
			console.log('Sucessfully inserted job details');
			$location.path('/home');
				alert("Posted job sucessfully");
		},function(response){
			console.log("Failure" +response.status);
			if(response.status==401){
				$location.path('/login')
			}
			else{
			console.log(response.data.message);
			$location.path('/postJob');
			}
			})
		}
		
	function getAllJobs(){
		console.log('Entering in getAllJobs');
		JobService.getAllJobs()
		.then(function(response){
		console.log(response.status)
		$scope.jobs=response.data;
		},function(response){
			console.log('Failure' + response.status);
		})
	}
	getAllJobs();
		
	
	
})		