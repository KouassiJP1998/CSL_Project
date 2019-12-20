package entities_package;

import entities_package.Events;
import entities_package.StudentsLetters;
import entities_package.Teams;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T19:05:53")
@StaticMetamodel(Sports.class)
public class Sports_ { 

    public static volatile SingularAttribute<Sports, String> sportCode;
    public static volatile CollectionAttribute<Sports, StudentsLetters> studentsLettersCollection;
    public static volatile CollectionAttribute<Sports, Events> eventsCollection;
    public static volatile CollectionAttribute<Sports, Teams> teamsCollection;
    public static volatile SingularAttribute<Sports, String> sportDescription;

}