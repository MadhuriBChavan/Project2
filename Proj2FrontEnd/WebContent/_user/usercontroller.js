app.controller('UserController',function($scope,$location,UserService,$rootScope){
	$scope.users={};
	$scope.user={id:'',username:'',password:'',email:'',role:'',isOnline:'',enabled:''};
	$scope.message;
	$scope.submit=function(){
		console.log('Entering - submit function in usercontroller')
		UserService.authenticate($scope.user)
		.then(function(response){
			
				$scope.user=response.data;
				$rootScope.currentUser=$scope.user;
				console.log("value of currentUser id is= "+$rootScope.currentUser.id);
				$location.path("/home");
			
		},function(response){
			console.log('Invalid username or password');
			$scope.message="Invalid Username or Password";
			$location.path("/login")
		})
	}
		
	function getAllUsers()
			{
		console.log('Entering getAllUsers')
		UserService.getAllUsers()
			.then(function(response){
					console.log(response.data)
					console.log(response.status)
					return response.data;
					 
				},
				function(response){
					console.log(response.data);
					return response.data;
				})
			}
	   getAllUsers();
	   
	   
/*	   userService.fetchAllUsers=function(){
			console.log('Entering fetchAllUserss in service');
			return $http.get(BASE_URL + "/allUsers")
			.then(function(response){
				console.log(response.data)
				console.log(response.status)
				return response.data
			},
			function(response){
				console.log(response.data)
				return response.data
			})
		}
*/
	   
	   
				
		
	$scope.registerUser=function(){
		console.log('Entering registerUser')
		UserService.registerUser($scope.user)
			.then(function(response)// success
					{
						console.log('Registration sucess' + response.status)
						$location.path("/login")
					},
					function(response)// Failure
					{
						console.log('Registration failed' +response.status)
						console.log(response.data)
						$scope.errorMessage="Registration Failed..." + response.data.message
						$location.path("/register")
				})
	}
	
	$rootScope.logout=function(){
		console.log('Entering in logout()');
		delete $rootScope.currentUser;
		UserService.logout()
		.then(function(response){
			console.log('logged out sucessfully..');
			$scope.message="Logged out Successfully";
			$location.path('/login')
		},function(response){
			console.log('logout failure');
			
		})
		}
	
	/*$rootScope.hasRole=function(role){
		if($rootScope.currentUser.role==undefined)
			return false;
		return
	}*/
	
	
	
})		