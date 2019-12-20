/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Falkke
 */
@Entity
@Table(name = "STUDENTS_IN_EVENTS", catalog = "", schema = "BDELBOUYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentsInEvents.findAll", query = "SELECT s FROM StudentsInEvents s")
    , @NamedQuery(name = "StudentsInEvents.findByTeamId", query = "SELECT s FROM StudentsInEvents s WHERE s.studentsInEventsPK.teamId = :teamId")
    , @NamedQuery(name = "StudentsInEvents.findByStudentId", query = "SELECT s FROM StudentsInEvents s WHERE s.studentsInEventsPK.studentId = :studentId")
    , @NamedQuery(name = "StudentsInEvents.findByEventId", query = "SELECT s FROM StudentsInEvents s WHERE s.studentsInEventsPK.eventId = :eventId")
    , @NamedQuery(name = "StudentsInEvents.findByStudentResult", query = "SELECT s FROM StudentsInEvents s WHERE s.studentResult = :studentResult")
    , @NamedQuery(name = "StudentsInEvents.findByStudentPointsAwarded", query = "SELECT s FROM StudentsInEvents s WHERE s.studentPointsAwarded = :studentPointsAwarded")})
public class StudentsInEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentsInEventsPK studentsInEventsPK;
    @Size(max = 20)
    @Column(name = "STUDENT_RESULT", length = 20)
    private String studentResult;
    @Column(name = "STUDENT_POINTS_AWARDED")
    private Integer studentPointsAwarded;
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Events events;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentsAthletes studentsAthletes;
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teams teams;

    public StudentsInEvents() {
    }

    public StudentsInEvents(StudentsInEventsPK studentsInEventsPK) {
        this.studentsInEventsPK = studentsInEventsPK;
    }

    public StudentsInEvents(String teamId, String studentId, String eventId) {
        this.studentsInEventsPK = new StudentsInEventsPK(teamId, studentId, eventId);
    }

    public StudentsInEventsPK getStudentsInEventsPK() {
        return studentsInEventsPK;
    }

    public void setStudentsInEventsPK(StudentsInEventsPK studentsInEventsPK) {
        this.studentsInEventsPK = studentsInEventsPK;
    }

    public String getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(String studentResult) {
        this.studentResult = studentResult;
    }

    public Integer getStudentPointsAwarded() {
        return studentPointsAwarded;
    }

    public void setStudentPointsAwarded(Integer studentPointsAwarded) {
        this.studentPointsAwarded = studentPointsAwarded;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public StudentsAthletes getStudentsAthletes() {
        return studentsAthletes;
    }

    public void setStudentsAthletes(StudentsAthletes studentsAthletes) {
        this.studentsAthletes = studentsAthletes;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentsInEventsPK != null ? studentsInEventsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsInEvents)) {
            return false;
        }
        StudentsInEvents other = (StudentsInEvents) object;
        if ((this.studentsInEventsPK == null && other.studentsInEventsPK != null) || (this.studentsInEventsPK != null && !this.studentsInEventsPK.equals(other.studentsInEventsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.StudentsInEvents[ studentsInEventsPK=" + studentsInEventsPK + " ]";
    }
    
}
