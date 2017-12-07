'use strict';

/**
 * @ngdoc function
 * @name usernameAppApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the usernameAppApp
 */
angular.module('usernameAppApp')
  .controller('MainCtrl', function (mainFactory) {
	
    this.checkUsername = function() {
		var md = this;
		mainFactory.checkUsername(md.username)
			.then(function(result) {
				if(!result.data){
					mainFactory.createUser(md.username).then(function(createResult){
						md.success;
					},function(error){
						console.error(error);
						md.error =true;
					});
				}else{
					mainFactory.getUsernameSugesstions(md.username).then(function(sugesstionsResult){
						md.warning=true;
						md.showList=true;
						md.suggestionList = sugesstionsResult.data;
					},function(error){
						console.error(error);
						md.error =true;
					});
				}
			},function(error){
				console.error(error);
				md.error =true;
			});
    };
  });
