/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Falkke
 */
@Entity
@Table(catalog = "", schema = "BDELBOUYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t")
    , @NamedQuery(name = "Teams.findByTeamId", query = "SELECT t FROM Teams t WHERE t.teamId = :teamId")
    , @NamedQuery(name = "Teams.findByGender", query = "SELECT t FROM Teams t WHERE t.gender = :gender")
    , @NamedQuery(name = "Teams.findByTeamDate", query = "SELECT t FROM Teams t WHERE t.teamDate = :teamDate")
    , @NamedQuery(name = "Teams.findByTeamName", query = "SELECT t FROM Teams t WHERE t.teamName = :teamName")
    , @NamedQuery(name = "Teams.findByTeamDescription", query = "SELECT t FROM Teams t WHERE t.teamDescription = :teamDescription")
    , @NamedQuery(name = "Teams.findByCoachName", query = "SELECT t FROM Teams t WHERE t.coachName = :coachName")
    , @NamedQuery(name = "Teams.findByOtherDetails", query = "SELECT t FROM Teams t WHERE t.otherDetails = :otherDetails")})
public class Teams implements Serializable {

    @Column(name = "GENDER")
    private Character gender;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TEAM_ID", nullable = false, length = 4)
    private String teamId;
    @Column(name = "TEAM_DATE")
    @Temporal(TemporalType.DATE)
    private Date teamDate;
    @Size(max = 20)
    @Column(name = "TEAM_NAME", length = 20)
    private String teamName;
    @Size(max = 20)
    @Column(name = "TEAM_DESCRIPTION", length = 20)
    private String teamDescription;
    @Size(max = 20)
    @Column(name = "COACH_NAME", length = 20)
    private String coachName;
    @Size(max = 20)
    @Column(name = "OTHER_DETAILS", length = 20)
    private String otherDetails;
    @ManyToMany(mappedBy = "teamsCollection")
    private Collection<StudentsAthletes> studentsAthletesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<StudentsInEvents> studentsInEventsCollection;
    @JoinColumn(name = "DIVISION_CODE", referencedColumnName = "DIVISION_CODE")
    @ManyToOne
    private Divisions divisionCode;
    @JoinColumn(name = "SPORT_CODE", referencedColumnName = "SPORT_CODE")
    @ManyToOne
    private Sports sportCode;

    public Teams() {
    }

    public Teams(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getTeamDate() {
        return teamDate;
    }

    public void setTeamDate(Date teamDate) {
        this.teamDate = teamDate;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @XmlTransient
    public Collection<StudentsAthletes> getStudentsAthletesCollection() {
        return studentsAthletesCollection;
    }

    public void setStudentsAthletesCollection(Collection<StudentsAthletes> studentsAthletesCollection) {
        this.studentsAthletesCollection = studentsAthletesCollection;
    }

    @XmlTransient
    public Collection<StudentsInEvents> getStudentsInEventsCollection() {
        return studentsInEventsCollection;
    }

    public void setStudentsInEventsCollection(Collection<StudentsInEvents> studentsInEventsCollection) {
        this.studentsInEventsCollection = studentsInEventsCollection;
    }

    public Divisions getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(Divisions divisionCode) {
        this.divisionCode = divisionCode;
    }

    public Sports getSportCode() {
        return sportCode;
    }

    public void setSportCode(Sports sportCode) {
        this.sportCode = sportCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamId != null ? teamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.teamId == null && other.teamId != null) || (this.teamId != null && !this.teamId.equals(other.teamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.Teams[ teamId=" + teamId + " ]";
    }
    
}
