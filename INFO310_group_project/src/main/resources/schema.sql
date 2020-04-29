/* Run this command if you still have a research project table in your db*/
DROP TABLE RESEARCHPROJECT;

DROP TABLE CONTACTREQUEST;
DROP TABLE STAFF;
DROP TABLE STUDENT;



create table Staff(
       staffID bigint auto_increment(0),
       firstname varchar(20) not null,
       surname varchar(20) not null,
       dateOfBirth varchar(10) not null, 
       gender varchar(10) not null, 
       username varchar(15) not null,
       password varchar(20) not null,
       email varchar(30) not null, 
       phoneNumber varchar(12) not null,
       description varchar(500) not null,
       address varchar(50) not null,
       category varchar(30) not null,
       searching boolean,
       constraint staff_PK primary key (staffID)
);

create table Student(
       studentID integer not null,
       firstname varchar(20) not null,
       surname varchar(20) not null,
       dateOfBirth varchar(10) not null, 
       gender varchar(10) not null, 
       username varchar(15) not null,
       password varchar(20) not null,
       email varchar(30) not null,
       phoneNumber varchar(12) not null,
       description varchar(500) not null,
       address varchar(50) not null, 
       category varchar(30) not null,
       searching boolean,
       constraint student_PK primary key (studentID)
);

create table ContactRequest(
    studentID integer not null,
    staffID integer not null,
    message varchar(500) not null,
    studenttoprofessor boolean not null,
    constraint CR_PK primary key (studentID, staffID),
    constraint CR_FK_Student foreign key (studentID) references student,
    constraint CR_FK_Staff foreign key (staffID) references staff
);

insert into Student (studentID, firstname, surname, dateOfBirth, gender, username, password, email,phoneNumber,description,address, category, searching) 
values (1143134, 'Leon', 'Hoogenraad','20/05/1998','male', 'lhoogenraad', 'password', 'le.o.n@outlook.com','021026111321','some description','16 some street dunedin','Computer Science', false);
insert into Student (studentID, firstname, surname, dateOfBirth, gender, username, password, email,phoneNumber,description,address, category, searching)  
values (2423423, 'Hugo', 'Baird','15/03/1999','male', 'hbaird', 'password','hugo@outlook.com','02102788182','some description','153 park street dunedin','Computer Science', false);
insert into Student (studentID, firstname, surname, dateOfBirth, gender, username, password, email,phoneNumber,description,address, category, searching)  
values (3345345, 'Julia', 'McDowell','17/05/1999','female', 'jmcdowell', 'password', 'julia@outlook.com','02102788182','some description','13 north street dunedin', 'Information Science', false);
insert into Student (studentID, firstname, surname, dateOfBirth, gender, username, password, email,phoneNumber,description,address, category, searching)  
values (4866788, 'Cedric', 'Stephani','19/10/1998','male', 'cstephani', 'password', 'cedric@outlook.com','02102789143','some description','44 forth street dunedin', 'Computer Science', false);
insert into Student (studentID, firstname, surname, dateOfBirth, gender, username, password, email,phoneNumber,description,address, category, searching)  
values (2422335, 'Carly', 'Ryan','7/09/1998','female', 'cryan', 'password', 'cryin@outlook.com','021027156881','some description','134 south street dunedin', 'Information Science', false);

insert into Staff (firstname, surname,dateOfBirth,gender, username, password, email,phoneNumber,description,address, category, searching) 
values ('Daniel', 'De La Costa','20/03/1990','male', 'Dannyboy', 'password', 'dcosta@outlook.com','02102614628','some description','31 grove street dunedin', 'Information Science', false);
insert into Staff (firstname, surname,dateOfBirth,gender, username, password, email,phoneNumber,description,address, category, searching)
values ('Biology', 'Teacher','10/09/1970','male', 'Bioguy69420', 'password', 'PetriDish@outlook.com','02102790163','some description','130 smith street dunedin', 'Biology', false);
insert into Staff (firstname, surname,dateOfBirth,gender, username, password, email,phoneNumber,description,address, category, searching)
values ('Mark', 'Eting','09/12/1980','male', 'Xx_mark-et_xX', 'password', 'mark@outlook.com','021026143761','some description','100 smooth street dunedin', 'Marketing', false);
insert into Staff (firstname, surname,dateOfBirth,gender, username, password, email,phoneNumber,description,address, category, searching)
values ('Sanjay', 'Gupta','01/01/1978','male', 'imsanjaygupta', 'password', 'sajay@gmail.com','02102563721','some description','60 baldwin street dunedin', 'Medical Studies', false);
insert into Staff (firstname, surname,dateOfBirth,gender, username, password, email,phoneNumber,description,address, category, searching)
values ('Jacinda', 'Ardern','12/07/1988','female', 'primeminister', 'password', 'jacinda@minister.com','02102272431','some description','17 park street dunedin', 'Politics', false);