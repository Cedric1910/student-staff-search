/*
  Can easily alter the varchar sizes if need be.
*/

create table ResearchProject(
       projectID varchar(15) not null,
       studentID varchar(15) not null,
       staffID varchar(15), not null,
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
       staffID varchar(15) not null,
       firstname varchar(30) not null,
       surname varchar(40) not null,
       username varchar(40) not null,
       password varchar(40) not null,
       email varchar(60) not null,
       availability boolean, /* Pretty sure that boolean is a thing in h2, will have to see */
       constraint staff_PK primary key (id)
);

create table Student(
       studentID varchar(15) not null,
       firstname varchar(30) not null,
       surname varchar(40) not null,
       username varchar(40) not null,
       password varchar(40) not null,
       email varchar(60) not null,
       searching boolean,
       constraint student_PK primary key (id)
);
