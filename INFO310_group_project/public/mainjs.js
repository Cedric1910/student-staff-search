"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

module.factory('staffRegisterDAO', function ($resource) {
    return $resource('/api/staff/register');
});

module.factory('staffSignInDAO', function ($resource) {
    return $resource('/api/staff/:username');
});

module.factory('studentRegisterDAO', function ($resource) {
    return $resource('/api/student/register');
});

module.factory('studentSignInDAO', function ($resource) {
    return $resource('/api/student/:username');
});

module.controller('StaffController', function (staffRegisterDAO, signInDAO, $sessionStorage, $window) {
    this.registerCustomer = function (staff) {
        staffRegisterDAO.save(null, staff,
            // success callback
            function () {
                $window.location = 'signin.html';
            },
            // error callback
            function (error) {
                console.log(error);
            }
        );
    };
    this.signInMessage = "Please sign in to continue.";
    
    // alias 'this' so that we can access it inside callback functions
    let ctrl = this;
  
    this.signIn = function (username, passWord) {
        // get customer from web service
        signInDAO.get({'username': username},
        // success
            function (staff) {
            // also store the retrieved customer
                $sessionStorage.staff = staff;
            // redirect to home
                $window.location = 'index.html';
            },
            // fail
            function () {
                ctrl.signInMessage = 'Sign in failed. Please try again.';
            }
        );
    };
    this.checkSignIn = function () {
        // has the customer been added to the session?
        if ($sessionStorage.staff) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.staff.firstName;
        } else {
            this.signedIn = false;
        }
    };
    
    this.signOut = function () {
        delete $sessionStorage.staff;
        this.signedIn = false;
    };
});
