/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falkke
 */
@Entity
@Table(name = "STUDENTS_LETTERS", catalog = "", schema = "BDELBOUYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentsLetters.findAll", query = "SELECT s FROM StudentsLetters s")
    , @NamedQuery(name = "StudentsLetters.findByStudentId", query = "SELECT s FROM StudentsLetters s WHERE s.studentsLettersPK.studentId = :studentId")
    , @NamedQuery(name = "StudentsLetters.findBySportCode", query = "SELECT s FROM StudentsLetters s WHERE s.studentsLettersPK.sportCode = :sportCode")
    , @NamedQuery(name = "StudentsLetters.findByDateAwarded", query = "SELECT s FROM StudentsLetters s WHERE s.studentsLettersPK.dateAwarded = :dateAwarded")})
public class StudentsLetters implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentsLettersPK studentsLettersPK;
    @JoinColumn(name = "SPORT_CODE", referencedColumnName = "SPORT_CODE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sports sports;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentsAthletes studentsAthletes;

    public StudentsLetters() {
    }

    public StudentsLetters(StudentsLettersPK studentsLettersPK) {
        this.studentsLettersPK = studentsLettersPK;
    }

    public StudentsLetters(String studentId, String sportCode, Date dateAwarded) {
        this.studentsLettersPK = new StudentsLettersPK(studentId, sportCode, dateAwarded);
    }

    public StudentsLettersPK getStudentsLettersPK() {
        return studentsLettersPK;
    }

    public void setStudentsLettersPK(StudentsLettersPK studentsLettersPK) {
        this.studentsLettersPK = studentsLettersPK;
    }

    public Sports getSports() {
        return sports;
    }

    public void setSports(Sports sports) {
        this.sports = sports;
    }

    public StudentsAthletes getStudentsAthletes() {
        return studentsAthletes;
    }

    public void setStudentsAthletes(StudentsAthletes studentsAthletes) {
        this.studentsAthletes = studentsAthletes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentsLettersPK != null ? studentsLettersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsLetters)) {
            return false;
        }
        StudentsLetters other = (StudentsLetters) object;
        if ((this.studentsLettersPK == null && other.studentsLettersPK != null) || (this.studentsLettersPK != null && !this.studentsLettersPK.equals(other.studentsLettersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.StudentsLetters[ studentsLettersPK=" + studentsLettersPK + " ]";
    }
    
}
