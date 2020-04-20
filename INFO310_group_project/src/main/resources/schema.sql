/*
  Can easily alter the varchar sizes if need be.
*/

create table ResearchProject (
       projectID varchar(15) not null,
       studentID varchar(15) not null,
       staffID varchar(15) not null,
       projectname varchar(50) not null,
       description varchar(200) not null,
       category varchar(50) not null,
       subcategory varchar(75),
       status varchar(35) not null,
       constraint project_PK primary key (projectID)
       constraint Student_FK foreign key (studentID) references Student
       constraint Staff_FK foreign key (staffID) references Staff
);

create table Staff(
       staffID varchar(10) not null,
       firstname varchar(15) not null,
       surname varchar(15) not null,
       username varchar(10) not null,
       password varchar(20) not null,
       email varchar(20) not null,
       category varchar(10) not null,
       searching boolean,
       constraint staff_PK primary key (staffID)
);

create table Student(
       studentID varchar(10) not null,
       firstname varchar(15) not null,
       surname varchar(15) not null,
       username varchar(10) not null,
       password varchar(20) not null,
       email varchar(20) not null,
       category varchar(10) not null,
       searching boolean,
       constraint student_PK primary key (studentID)
);
