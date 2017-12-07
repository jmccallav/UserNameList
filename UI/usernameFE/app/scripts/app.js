'use strict';

/**
 * @ngdoc overview
 * @name usernameAppApp
 * @description
 * # usernameAppApp
 *
 * Main module of the application.
 */
angular
  .module('usernameAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/username.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
