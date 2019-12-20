/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
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
@Table(name = "STUDENTS_IN_TEAMS", catalog = "", schema = "BDELBOUYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentsInTeams.findAll", query = "SELECT s FROM StudentsInTeams s")
    , @NamedQuery(name = "StudentsInTeams.findByTeamId", query = "SELECT s FROM StudentsInTeams s WHERE s.studentsInTeamsPK.teamId = :teamId")
    , @NamedQuery(name = "StudentsInTeams.findByStudentId", query = "SELECT s FROM StudentsInTeams s WHERE s.studentsInTeamsPK.studentId = :studentId")})
public class StudentsInTeams implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentsInTeamsPK studentsInTeamsPK;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentsAthletes studentsAthletes;
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teams teams;

    public StudentsInTeams() {
    }

    public StudentsInTeams(StudentsInTeamsPK studentsInTeamsPK) {
        this.studentsInTeamsPK = studentsInTeamsPK;
    }

    public StudentsInTeams(String teamId, String studentId) {
        this.studentsInTeamsPK = new StudentsInTeamsPK(teamId, studentId);
    }

    public StudentsInTeamsPK getStudentsInTeamsPK() {
        return studentsInTeamsPK;
    }

    public void setStudentsInTeamsPK(StudentsInTeamsPK studentsInTeamsPK) {
        this.studentsInTeamsPK = studentsInTeamsPK;
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
        hash += (studentsInTeamsPK != null ? studentsInTeamsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsInTeams)) {
            return false;
        }
        StudentsInTeams other = (StudentsInTeams) object;
        if ((this.studentsInTeamsPK == null && other.studentsInTeamsPK != null) || (this.studentsInTeamsPK != null && !this.studentsInTeamsPK.equals(other.studentsInTeamsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.StudentsInTeams[ studentsInTeamsPK=" + studentsInTeamsPK + " ]";
    }
    
}
