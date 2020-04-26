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
values (1143134, 'Leon', 'Hoogenraad', 'lhoogenraad', 'password', 'le.o.n@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (2423423, 'Hugo', 'Baird', 'hbaird', 'password', 'hugo@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (3345345, 'Julia', 'McDowell', 'jmcdowell', 'password', 'julia@outlook.com', 'Information Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (4866788, 'Cedric', 'Stephani', 'cstephani', 'password', 'cedric@outlook.com', 'Computer Science', false);
insert into Student (studentID, firstname, surname, username, password, email, category, searching) 
values (2422335, 'Carly', 'Ryan', 'cryan', 'password', 'cryin@outlook.com', 'Information Science', false);

insert into Staff (firstname, surname, username, password, email, category, searching) 
values ('Daniel', 'De La Costa', 'Dannyboy', 'password', 'dcosta@outlook.com', 'Information Science', false);
insert into Staff (firstname, surname, username, password, email, category, searching)
values ('Biology', 'Teacher', 'Bioguy69420', 'password', 'PetriDish@outlook.com', 'Biology', false);
insert into Staff (firstname, surname, username, password, email, category, searching)
values ('Mark', 'Eting', 'Xx_mark-et_xX', 'password', 'mark@outlook.com', 'Marketing', false);
insert into Staff (firstname, surname, username, password, email, category, searching)
values ('Sanjay', 'Gupta', 'imsanjaygupta', 'password', 'sajay@gmail.com', 'Medical Studies', false);
insert into Staff (firstname, surname, username, password, email, category, searching)
values ('Jacinda', 'Ardern', 'primeminister', 'password', 'jacinda@minister.com', 'Politics', false);