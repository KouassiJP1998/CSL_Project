package entities_package;

import entities_package.Sports;
import entities_package.StudentsAthletes;
import entities_package.StudentsLettersPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-19T10:25:08")
@StaticMetamodel(StudentsLetters.class)
public class StudentsLetters_ { 

    public static volatile SingularAttribute<StudentsLetters, Sports> sports;
    public static volatile SingularAttribute<StudentsLetters, StudentsLettersPK> studentsLettersPK;
    public static volatile SingularAttribute<StudentsLetters, StudentsAthletes> studentsAthletes;

}