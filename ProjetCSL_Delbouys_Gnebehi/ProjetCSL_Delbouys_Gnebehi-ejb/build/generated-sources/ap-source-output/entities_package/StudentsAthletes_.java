package entities_package;

import entities_package.StudentsInEvents;
import entities_package.StudentsLetters;
import entities_package.Teams;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T18:46:27")
@StaticMetamodel(StudentsAthletes.class)
public class StudentsAthletes_ { 

    public static volatile SingularAttribute<StudentsAthletes, String> studentId;
    public static volatile SingularAttribute<StudentsAthletes, String> lastName;
    public static volatile SingularAttribute<StudentsAthletes, String> firstName;
    public static volatile SingularAttribute<StudentsAthletes, Character> gender;
    public static volatile SingularAttribute<StudentsAthletes, String> studentsAddress;
    public static volatile CollectionAttribute<StudentsAthletes, StudentsLetters> studentsLettersCollection;
    public static volatile SingularAttribute<StudentsAthletes, String> otherDetails;
    public static volatile SingularAttribute<StudentsAthletes, Date> dateOfBirth;
    public static volatile SingularAttribute<StudentsAthletes, String> middleName;
    public static volatile CollectionAttribute<StudentsAthletes, StudentsInEvents> studentsInEventsCollection;
    public static volatile CollectionAttribute<StudentsAthletes, Teams> teamsCollection;
    public static volatile SingularAttribute<StudentsAthletes, Integer> pointsAwardedToDate;

}