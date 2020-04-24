"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('ConnectionApp', ['ngResource', 'ngStorage']);

module.factory('staffRegisterDAO', function ($resource) {
    return $resource('/api/staff/register');
});

module.factory('staffSignInDAO', function ($resource) {
    return $resource('/api/staff/:username');
});

module.factory('staffDAO', function ($resource) {
    return $resource('/api/staff/:username');
});

module.factory('studentDAO', function ($resource) {
    return $resource('/api/student/:username');
});

module.factory('studentRegisterDAO', function ($resource) {
    return $resource('/api/student/register');
});

module.factory('studentSignInDAO', function ($resource) {
    return $resource('/api/student/:username');
});

module.controller('allStaffController', function (staffDAO, $sessionStorage) {
    this.staff = staffDAO.query();
    this.returnStaff = function (){
        this.staff = staffDAO.query();
    };
    this.selectedStaff = $sessionStorage.selectedStaff;
});

module.controller('allStudentController', function (studentDAO, $sessionStorage) {
    this.student = studentDAO.query();
    this.returnStudent = function (){
        this.student = studentDAO.query();
    };
    this.selectedStudent = $sessionStorage.selectedStudent;
});

module.controller('StaffController', function (staffRegisterDAO, staffSignInDAO, $sessionStorage, $window) {
    this.registerStaff = function (staff) { 
        staffRegisterDAO.save(null, staff,
            function () {
                $window.location = 'staffloginpage.html';
            },
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
            function (staff) {
                if (staff.password === (password)) {
                    $sessionStorage.staff = staff;
                    $window.location = 'stafflookup.html';
                } else {
                    ctrl.signInMessage = 'Sign in details incorrect. Please try again';
                }
            },
            // Can't find staff
            function () {
                ctrl.signInMessage = 'Sign in details incorrect. Please try again.';
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
            function () {
                $window.location = 'studentloginpage.html';
            },
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
            function (student) {
                if (student.password === (password)) {
                    $sessionStorage.staff = student;
                    $window.location = 'index.html';
                } else {
                    ctrl.signInMessage = 'Sign in details incorrect. Please try again';
                }
            },
            // Can't find student
            function () {
                ctrl.signInMessage = 'Sign in details incorrect. Please try again.';
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