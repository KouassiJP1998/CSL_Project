package entities_package;

import entities_package.Teams;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-19T10:25:08")
@StaticMetamodel(Divisions.class)
public class Divisions_ { 

    public static volatile SingularAttribute<Divisions, String> divisionCode;
    public static volatile CollectionAttribute<Divisions, Teams> teamsCollection;
    public static volatile SingularAttribute<Divisions, String> divisionDescription;

}