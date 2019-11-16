-- Création des tables --
CREATE TABLE STUDENTS_ATHLETES(
	student_id char(4) not null,
	points_awarded_to_date number(4),
	first_name varchar(20),
	middle_name varchar(20),
	last_name varchar(20),
	date_of_birth date,
	gender char(1),
	students_address varchar(50),
	other_details varchar(20),
	constraint pk_OUVRAGES primary key(student_id),
	constraint ck_STUDENTS_ATHLETES_gender check(gender in('H','F'))
);

CREATE TABLE SPORTS(
	sport_code char(4) not null,
	sport_description varchar(20),
	eg_Westling varchar(20),
	constraint pk_SPORTS primary key(sport_code)
);

CREATE TABLE STUDENTS_LETTERS(
	student_id char(4),
	sport_code char(4),
	date_awarded date not null,
	constraint pk_STUDENTS_LETTERS primary key(student_id,sport_code,date_awarded),
	constraint fk_STUDENTS_LETTERS_STUDENTS_ATHLETES foreign key(student_id) references STUDENTS_ATHLETES,
	constraint fk_STUDENTS_LETTERS_SPORTS foreign key(sport_code) references SPORTS
);

CREATE TABLE DIVISIONS (
	division_code char(4) not null,
	division_description varchar(20),
	constraint  pk_DIVISIONS primary key(division_code)
);

CREATE TABLE TEAMS(
	team_id char(4) not null,
	gender char(1),
	division_code char(4),
	sport_code char(4),
	team_date date,
	team_name varchar(20),
	team_description varchar(20),
	coach_name varchar(20),
	other_details varchar(20),
	constraint pk_TEAMS primary key(team_id),
	constraint fk_TEAMS_SPORTS foreign key(sport_code) references SPORTS,
	constraint fk_TEAMS_DIVISIONS foreign key(division_code) references DIVISIONS
);

CREATE TABLE STUDENTS_IN_TEAMS(
	team_id char(4),
	student_id char(4),
	constraint pk_STUDENTS_IN_TEAMS primary key(team_id,student_id),
	constraint fk_STUDENTS_IN_TEAMS_TEAMS foreign key(team_id) references TEAMS,
	constraint fk_STUDENTS_IN_TEAMS_STUDENTS_ATHLETES foreign key(student_id) references STUDENTS_ATHLETES
);

CREATE TABLE EVENTS(
	event_id char(4) not null,
	sport_code char(4),
	event_name varchar(20),
	event_location varchar(20),
	start_date date,
	end_date date,
	other_details varchar(20),
	constraint pk_EVENTS primary key(event_id),
	constraint fk_EVENTS_SPORTS foreign key(sport_code) references SPORTS
);

CREATE TABLE STUDENTS_IN_EVENTS(
	team_id char(4),
	student_id char(4),
	event_id char(4),
	student_result varchar(20),
	student_points_awarded number(4),
	constraint pk_STUDENTS_IN_EVENTS primary key(team_id,student_id,event_id),
	constraint fk_STUDENTS_IN_EVENTS_STUDENTS_ATHLETES foreign key(student_id) references STUDENTS_ATHLETES,
	constraint fk_STUDENTS_IN_EVENTS_TEAMS foreign key(team_id) references TEAMS,
	constraint fk_STUDENTS_IN_EVENTS_EVENTS foreign key(event_id) references EVENTS
);

-- INSERTION DANS LES TABLES ---
INSERT INTO STUDENTS_ATHLETES(student_id,points_awarded_to_date,first_name,middle_name,last_name,date_of_birth,gender,students_address,other_details) VALUES ('1234', '1000', 'PIRLO','ANDRE','CHACALO',date'1990-12-12','H','5 Avenue SERVE','happy');
INSERT INTO STUDENTS_ATHLETES(student_id,points_awarded_to_date,first_name,middle_name,last_name,date_of_birth,gender,students_address,other_details) VALUES ('1235', '1001', 'CAMOUANESI','ANDRES','RENARDO',date'1991-12-12','H','5 Avenue ERSAE','happy');
INSERT INTO STUDENTS_ATHLETES(student_id,points_awarded_to_date,first_name,middle_name,last_name,date_of_birth,gender,students_address,other_details) VALUES ('1236', '1002', 'MOTTA','THIAGO','SOURISS',date'1992-12-12','H','5 Avenue FRETER','happy');
INSERT INTO STUDENTS_ATHLETES(student_id,points_awarded_to_date,first_name,middle_name,last_name,date_of_birth,gender,students_address,other_details) VALUES ('1237', '1003', 'GATTUSO','ERWAN','FOUTOU',date'1993-12-12','H','5 Avenue DERTER','happy');

INSERT INTO SPORTS(sport_code,sport_description,eg_Westling) VALUES ('0000','FOOTBALL','W');
INSERT INTO SPORTS(sport_code,sport_description,eg_Westling) VALUES ('0001','BASKETBALL','X');
INSERT INTO SPORTS(sport_code,sport_description,eg_Westling) VALUES ('0002','TENNIS','Y');
INSERT INTO SPORTS(sport_code,sport_description,eg_Westling) VALUES ('0003','HANDBALL','Z');

INSERT INTO STUDENTS_LETTERS(student_id,sport_code,date_awarded) VALUES ('1234','0000',date'2005-12-12');
INSERT INTO STUDENTS_LETTERS(student_id,sport_code,date_awarded) VALUES ('1235','0001',date'2005-12-12');
INSERT INTO STUDENTS_LETTERS(student_id,sport_code,date_awarded) VALUES ('1236','0002',date'2006-12-12');
INSERT INTO STUDENTS_LETTERS(student_id,sport_code,date_awarded) VALUES ('1237','0003',date'2007-12-12');

INSERT INTO DIVISIONS(division_code,division_description) VALUES ('2222','A');
INSERT INTO DIVISIONS(division_code,division_description) VALUES ('2223','B');
INSERT INTO DIVISIONS(division_code,division_description) VALUES ('2224','C');
INSERT INTO DIVISIONS(division_code,division_description) VALUES ('2225','D');

INSERT INTO TEAMS(team_id,gender,division_code,sport_code,team_date,team_description,coach_name,other_details) VALUES ('3333','H','2222','0000',DATE'2000-12-12','ITALIE','LILIANO','NONO');

INSERT INTO STUDENTS_IN_TEAMS(team_id,student_id) VALUES ('3333','1234');

INSERT INTO EVENTS(event_id,sport_code,event_name,event_location,start_date,end_date,other_details) VALUES ('5555','0000','GADJI CELI','ABIDJAN',DATE'2015-12-12',DATE'2016-03-12','HYDRO');

CREATE TABLE STUDENTS_IN_EVENTS(
	team_id char(4),
	student_id char(4),
	event_id char(4),
	student_result varchar(20),
	student_points_awarded number(4),
	constraint pk_STUDENTS_IN_EVENTS primary key(team_id,student_id,event_id),
	constraint fk_STUDENTS_IN_EVENTS_STUDENTS_ATHLETES foreign key(student_id) references STUDENTS_ATHLETES,
	constraint fk_STUDENTS_IN_EVENTS_TEAMS foreign key(team_id) references TEAMS,
	constraint fk_STUDENTS_IN_EVENTS_EVENTS foreign key(event_id) references EVENTS
);

INSERT INTO STUDENTS_IN_EVENTS(team_id,student_id,event_id,student_result,student_points_awarded) VALUES ('3333','1234','5555','FIRST',5000);