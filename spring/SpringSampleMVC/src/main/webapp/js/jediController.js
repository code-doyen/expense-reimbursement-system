app.controller('jediController', function($scope, $http) {
	//Get all jedis function
	$scope.getAllJedis = () => {
		$scope.jediList = {};
		console.log('Getting all Jedis:');
		$http.post(domain + 'getAllJedis.app')
		.then((successResponse) => {
			$scope.jediList = successResponse.data;
		})
	}
	
	//Get a single jedi function
	$scope.getJedi = () => {
		$scope.jediData = {};
		console.log('Getting Jedi: ' + $scope.info.name);
		//We pass a JSON as our parameters, we can receive it with @RequestBody
		$http.post(domain + 'getJedi.app', $scope.info)
		.then((successResponse) => {
			$scope.jediData = successResponse.data;
		})
	}
});