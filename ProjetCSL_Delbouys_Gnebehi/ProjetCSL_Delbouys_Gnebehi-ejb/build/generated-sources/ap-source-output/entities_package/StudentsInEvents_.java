package entities_package;

import entities_package.Events;
import entities_package.StudentsAthletes;
import entities_package.StudentsInEventsPK;
import entities_package.Teams;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-19T10:25:08")
@StaticMetamodel(StudentsInEvents.class)
public class StudentsInEvents_ { 

    public static volatile SingularAttribute<StudentsInEvents, StudentsInEventsPK> studentsInEventsPK;
    public static volatile SingularAttribute<StudentsInEvents, Teams> teams;
    public static volatile SingularAttribute<StudentsInEvents, StudentsAthletes> studentsAthletes;
    public static volatile SingularAttribute<StudentsInEvents, Integer> studentPointsAwarded;
    public static volatile SingularAttribute<StudentsInEvents, Events> events;
    public static volatile SingularAttribute<StudentsInEvents, String> studentResult;

}