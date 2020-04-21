"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('ConnectionApp', ['ngResource', 'ngStorage']);

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

module.controller('StaffController', function (staffRegisterDAO, staffSignInDAO, $sessionStorage, $window) {
    this.registerStaff = function (staff) { 
        staffRegisterDAO.save(null, staff,
            // success callback
            function () {
                $window.location = 'loginpage.html';
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
  
    this.signIn = function (username, password) {
        staffSignInDAO.get({'username': username},
        // success
            function (staff) {
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

module.controller('StudentController', function (studentRegisterDAO, studentSignInDAO, $sessionStorage, $window) {
    this.registerStudent = function (student) {
        studentRegisterDAO.save(null, student,
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
  
    this.signIn = function (username, password) {
        studentSignInDAO.get({'username': username},
        // success
            function (student) {
                $sessionStorage.student = student;
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
        if ($sessionStorage.student) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.student.firstName;
        } else {
            this.signedIn = false;
        }
    };
    this.signOut = function () {
        delete $sessionStorage.student;
        this.signedIn = false;
    };
});
