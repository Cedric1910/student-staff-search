/*
  Can easily alter the varchar sizes if need be.
*/

create table ResearchProject(
       projectID varchar(15),
       studentID varchar(15),
       projectname varchar(50),
       description varchar(200),
       category varchar(50),
       subcategory varchar(75),
       status varchar(35),
       constraint project_PK primary key (projectID)
);

create table Staff(
       id varchar(15),
       firstname varchar(30),
       surname varchar(40),
       username varchar(40),
       password varchar(40),
       email varchar(60),
       availability boolean, /* Pretty sure that boolean is a thing in h2, will have to see */
       constraint staff_PK primary key (id)
);

create table Student(
       id varchar(15),
       firstname varchar(30),
       surname varchar(40),
       username varchar(40),
       password varchar(40),
       email varchar(60),
       searching boolean,
       constraint student_PK primary key (id)
);
