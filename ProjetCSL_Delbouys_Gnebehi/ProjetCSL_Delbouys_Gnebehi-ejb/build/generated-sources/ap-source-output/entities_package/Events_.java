package entities_package;

import entities_package.Sports;
import entities_package.StudentsInEvents;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-19T10:25:08")
@StaticMetamodel(Events.class)
public class Events_ { 

    public static volatile SingularAttribute<Events, String> eventId;
    public static volatile SingularAttribute<Events, Sports> sportCode;
    public static volatile SingularAttribute<Events, Date> endDate;
    public static volatile SingularAttribute<Events, String> eventLocation;
    public static volatile SingularAttribute<Events, String> otherDetails;
    public static volatile SingularAttribute<Events, String> eventName;
    public static volatile CollectionAttribute<Events, StudentsInEvents> studentsInEventsCollection;
    public static volatile SingularAttribute<Events, Date> startDate;

}