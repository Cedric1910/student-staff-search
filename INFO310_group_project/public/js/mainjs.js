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
    return $resource('/api/staff/');
});

module.factory('staffDAOsurname', function ($resource) {
    return $resource('/api/staff/surnames/:surname');
});

module.factory('staffCategoryDAO', function ($resource) {
    return $resource('/api/staff/categories/:category');
});

module.factory('staffRequestDAO', function ($resource) {
    return $resource('/api/staff/contactrequest/:staffID');
});

module.factory('studentRegisterDAO', function ($resource) {
    return $resource('/api/student/register');
});

module.factory('studentSignInDAO', function ($resource) {
    return $resource('/api/student/:username');
});

module.factory('studentDAO', function ($resource) {
    return $resource('/api/student/:username');
});

module.factory('studentDAOsurname', function ($resource) {
    return $resource('/api/student/surnames/:surname');
});

module.factory('studentCategoryDAO', function ($resource) {
    return $resource('/api/student/categories/:category');
});

module.factory('studentRequestDAO', function ($resource) {
    return $resource('/api/student/contactrequest/:studentID');
});

module.factory('contactRequestDAO', function ($resource) {
    return $resource('/api/contactrequest/newrequest');
});

module.factory('removeRequestDAO', function ($resource) {
    return $resource('/api/requests/remove/:requestID');
});

module.controller('allStaffController', function (staffDAO, staffRequestDAO, staffDAOsurname, staffCategoryDAO, $sessionStorage, $window) {
    this.staff = staffDAO.query();
    this.categories = staffCategoryDAO.query();
    this.getStaffRequests = function() {
        this.requests = staffRequestDAO.query({"staffID": $sessionStorage.staff.staffID});
    };
    this.selectSurname = function (surname) {
        this.staff = staffDAOsurname.query({"surname": surname});
    };  
    this.selectCategory = function (selectedCat) {
        if (selectedCat === "All"){
            this.staff = staffDAO.query();
        } else {
            this.staff = staffCategoryDAO.query({"category": selectedCat});
        }
    };  
    
    this.selectStaff = function (staff) {          
        $sessionStorage.selectedStaff = staff;
        $window.location = 'viewselectedstaff.html';               
    };  
    this.returnStaff = function (){
        this.staff = staffDAO.query();
    };
    this.selectedStaff = $sessionStorage.selectedStaff;
});

module.controller('allStudentController', function (studentDAO, studentRequestDAO, studentDAOsurname, studentCategoryDAO, $sessionStorage, $window) {
    this.student = studentDAO.query();
    this.categories = studentCategoryDAO.query();
    this.getStudentRequests = function() {
        this.requests = studentRequestDAO.query({"studentID": $sessionStorage.student.studentID});
    };
    this.selectSurname = function (surname) {
        this.student = studentDAOsurname.query({"surname": surname});
    };  
    this.selectCategory = function (selectedCat) {
        if (selectedCat === "All"){
            this.student = studentDAO.query();
        } else {
            this.student = studentCategoryDAO.query({"category": selectedCat});
        }
    };  
    this.selectStudent = function (student) {          
        $sessionStorage.selectedStudent = student;
        $window.location = 'viewselectedstudent.html';               
    };  
    this.returnStudent = function (){
        this.student = studentDAO.query();
    };
    this.selectedStudent = $sessionStorage.selectedStudent;
});

module.controller('StaffController', function (contactRequestDAO, staffRegisterDAO, removeRequestDAO, staffSignInDAO, $sessionStorage, $window) {
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
                    $window.location = 'studentlookup.html';
                    alert("Welcome " + $sessionStorage.staff.firstname + " " + $sessionStorage.staff.surname);
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
    this.signOut = function () {
        delete $sessionStorage.staff;
        this.signedIn = false;
    };
    this.deleteRequest = function (requestID) {
        alert("Deleted");
        this.message = removeRequestDAO.query({"requestID": requestID});
    };
    this.saveRequest = function (cr) { 
        contactRequestDAO.save(null, cr,
            function () {
                $window.location = 'studentlookup.html';
                alert("Contact Request Sent Successfully");
            },
            function (error) {
                console.log(error);
            }
        );
    };
    this.staffloggedin = $sessionStorage.staff;    
});

module.controller('StudentController', function (contactRequestDAO, studentRegisterDAO, studentSignInDAO, $sessionStorage, $window) {
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
                    $sessionStorage.student = student;
                    $window.location = 'stafflookup.html';
                    alert("Welcome " + $sessionStorage.student.firstname + " " + $sessionStorage.student.surname)
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
    this.signOut = function () {
        delete $sessionStorage.student;
        this.signedIn = false;
    };
     this.saveRequest = function (cr) { 
        contactRequestDAO.save(null, cr,
            function () {
                $window.location = 'stafflookup.html';
                alert("Contact Request Sent Successfully");
            },
            function (error) {
                console.log(error);
            }
        );
    };
    this.studentloggedin = $sessionStorage.student; 
});