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
	division_description varchar(20)
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
	constraint  pk_TEAMS primary key(team_id),
	constraint fk_TEAMS_SPORTS foreign key(sport_code) references SPORTS
	constraint fk_TEAMS_DIVISIONS foreign key(division_code) references DIVISIONS
);

CREATE TABLE STUDENTS_IN_TEAMS(
	team_id char(4),
	student_id char(4),
	constraint fk_STUDENTS_IN_TEAMS_TEAMS foreign key(team_id,student_id) references TEAMS,
	constraint fk_STUDENTS_IN_TEAMS_STUDENTS_ATHLETES foreign key(student_id) references STUDENTS_ATHLETES
	/*constraint ck_PERSONNES_datInscript check(dNaiss < datInscript)*/
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