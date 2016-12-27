var app=angular.module("myApp",['ngRoute'])
app.config(function($routeProvider){
	console.log('entering configuration')
	$routeProvider
	.when('/login',{
		controller:'UserController',
		templateUrl:'_user/login.html'
	})
	.when('/home',{
		templateUrl:'_home/home.html'
	})
	
	.when('/allUsers',{
			controller:'UserController',
			templateUrl:'_user/allUsers.html'
          })
          
     .when('/register',{
    	 	controller:'UserController',
			templateUrl:'_user/register.html'
          })
          
          .when('/allJobs',{
    	 	controller:'JobController',
			templateUrl:'_job/allJobs.html'
          })

           .when('/postJob',{
    	 	controller:'JobController',
			templateUrl:'_job/createJob.html'
          })
          
           .when('/postJob',{
    	 	//controller:'JobController',
			templateUrl:'_user/uploadPicture.html'
          })

          
          
	console.log('Entering in appp')
	
})
