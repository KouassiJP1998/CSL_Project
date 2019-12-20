package entities_package;

import entities_package.Divisions;
import entities_package.Sports;
import entities_package.StudentsAthletes;
import entities_package.StudentsInEvents;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T18:46:27")
@StaticMetamodel(Teams.class)
public class Teams_ { 

    public static volatile SingularAttribute<Teams, String> teamName;
    public static volatile SingularAttribute<Teams, String> coachName;
    public static volatile SingularAttribute<Teams, Divisions> divisionCode;
    public static volatile SingularAttribute<Teams, Sports> sportCode;
    public static volatile SingularAttribute<Teams, Character> gender;
    public static volatile SingularAttribute<Teams, String> otherDetails;
    public static volatile SingularAttribute<Teams, String> teamId;
    public static volatile SingularAttribute<Teams, String> teamDescription;
    public static volatile CollectionAttribute<Teams, StudentsInEvents> studentsInEventsCollection;
    public static volatile CollectionAttribute<Teams, StudentsAthletes> studentsAthletesCollection;
    public static volatile SingularAttribute<Teams, Date> teamDate;

}