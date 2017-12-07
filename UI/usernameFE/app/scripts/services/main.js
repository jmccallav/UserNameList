'use strict';

/**
 * @ngdoc service
 * @name usernameAppApp.main
 * @description
 * # main
 * Factory in the usernameAppApp.
 */
angular.module('usernameAppApp')
  .factory('mainFactory', function ($http, $q) {


    // Public API here
    return {
      checkUsername: function (username) {
        var deferred = $q.defer();
		var url = 'http://localhost:8080/checkUsername/'+username;
		$http({
		  method: 'GET',
		  url: url
	    }).then(deferred.resolve);
		return deferred.promise;
      },
	  
	  getUsernameSugesstions: function (username) {
        var deferred = $q.defer();
		var url = 'http://localhost:8080/getSuggestion/'+username;
		$http({
		  method: 'GET',
		  url: url
	    }).then(deferred.resolve);
		return deferred.promise;
      },
	  
	  createUser: function (username) {
        var deferred = $q.defer();
		var url = 'http://localhost:8080/createUsername/';
		console.info(username);
		$http({
		  method: 'POST',
		  url: url,
		  data:username
	    }).then(deferred.resolve);
		return deferred.promise;
      }
    };
  });
