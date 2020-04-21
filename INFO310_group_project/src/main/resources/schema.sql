/*
  Can easily alter the varchar sizes if need be.
*/

create table ResearchProject (
       projectID bigint auto_increment(0),
       studentID bigint auto_increment(0),
       staffID bigint auto_increment(0),
       projectname varchar(50) not null,
       description varchar(200) not null,
       category varchar(30) not null,
       status varchar(35) not null,
       constraint project_PK primary key (projectID),
       constraint Student_FK foreign key (studentID) references Student,
       constraint Staff_FK foreign key (staffID) references Staff
);

create table Staff(
       staffID bigint auto_increment(0),
       firstname varchar(15) not null,
       surname varchar(15) not null,
       username varchar(10) not null,
       password varchar(20) not null,
       email varchar(20) not null,
       category varchar(30) not null,
       searching boolean,
       constraint staff_PK primary key (staffID)
);

create table Student(
       studentID bigint auto_increment(0),
       firstname varchar(15) not null,
       surname varchar(15) not null,
       username varchar(10) not null,
       password varchar(20) not null,
       email varchar(20) not null,
       category varchar(30) not null,
       searching boolean,
       constraint student_PK primary key (studentID)
);
