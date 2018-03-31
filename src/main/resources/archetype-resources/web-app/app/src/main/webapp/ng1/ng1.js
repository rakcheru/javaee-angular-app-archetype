(function(document, window, undefined){

  var myApp = angular.module('rootModule', []);

  var myController = myApp.controller("rootController", ["$scope", function($scope){

    console.log("inside the controller");

    $scope.message = "AngularJS is working as expected!";

  }])


})(document, window);