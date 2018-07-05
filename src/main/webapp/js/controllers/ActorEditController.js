// START - USED SERVICES
/*
 *	ActorService.create
 *		PARAMS: 
 *		
 *
 *	ActorService.get
 *		PARAMS: 
 *		
 *
 *	ActorService.update
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * ActorService  
 */
// END - REQUIRED RESOURCES

app.controller('ActorEditController', ['$scope', '$location', '$routeParams', '$q', 'ActorService', 'FilmService',
    function ($scope, $location, $routeParams, $q, ActorService , FilmService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = ActorService.get({_id: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new ActorService();
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/actors/');
    		});
    	}
    	
    	$scope.remove = function(){
    		ActorService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/actors/');
    		});
    	}
    	
    		
        //manage relation FilmObj
        		
    	$scope.list_Film = FilmService.query();

}]);