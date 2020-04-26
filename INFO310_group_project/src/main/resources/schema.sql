create table ResearchProject (
       projectID bigint auto_increment(0),
       studentID bigint auto_increment(0),
       staffID bigint auto_increment(0),
       projectname varchar(30) not null,
       description varchar(200) not null,
       category varchar(30) not null,
       status varchar(30) not null,
       constraint project_PK primary key (projectID),
       constraint Student_FK foreign key (studentID) references Student,
       constraint Staff_FK foreign key (staffID) references Staff
);

create table Staff(
       staffID bigint auto_increment(0),
       firstname varchar(20) not null,
       surname varchar(20) not null,
       username varchar(15) not null,
       password varchar(20) not null,
       email varchar(30) not null,
       category varchar(30) not null,
       searching boolean,
       constraint staff_PK primary key (staffID)
);

create table Student(
       studentID integer not null,
       firstname varchar(20) not null,
       surname varchar(20) not null,
       username varchar(15) not null,
       password varchar(20) not null,
       email varchar(30) not null,
       category varchar(30) not null,
       searching boolean,
       constraint student_PK primary key (studentID)
);

insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (1, 'Leon', 'Hoogenraad', 'lhoogenraad', 'password', 'le.o.n@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (2, 'Hugo', 'Baird', 'hbaird', 'password', 'hugo@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (3, 'Julia', 'McDowell', 'jmcdowell', 'password', 'julia@outlook.com', 'Information Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (4, 'Cedric', 'Stephani', 'cstephani', 'password', 'cedric@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (5, 'Carly', 'Ryan', 'cryan', 'password', 'cryin@outlook.com', 'Information Science', false);

insert into Staff values (1, 'Daniel', 'De La Costa', 'Dannyboy', 'password', 'dcosta@outlook.com', 'Information Science', false);
insert into Staff values (2, 'Biology', 'Teacher', 'Bioguy69420', 'password', 'PetriDish@outlook.com', 'Biology', false);
insert into Staff values (3, 'Mark', 'eting', 'Xx_mark-et_xX', 'password', 'mark@outlook.com', 'Marketing', false);