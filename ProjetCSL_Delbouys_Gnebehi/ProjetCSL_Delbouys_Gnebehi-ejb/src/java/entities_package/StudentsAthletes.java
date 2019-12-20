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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "STUDENTS_ATHLETES", catalog = "", schema = "BDELBOUYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentsAthletes.findAll", query = "SELECT s FROM StudentsAthletes s")
    , @NamedQuery(name = "StudentsAthletes.findByStudentId", query = "SELECT s FROM StudentsAthletes s WHERE s.studentId = :studentId")
    , @NamedQuery(name = "StudentsAthletes.findByPointsAwardedToDate", query = "SELECT s FROM StudentsAthletes s WHERE s.pointsAwardedToDate = :pointsAwardedToDate")
    , @NamedQuery(name = "StudentsAthletes.findByFirstName", query = "SELECT s FROM StudentsAthletes s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "StudentsAthletes.findByMiddleName", query = "SELECT s FROM StudentsAthletes s WHERE s.middleName = :middleName")
    , @NamedQuery(name = "StudentsAthletes.findByLastName", query = "SELECT s FROM StudentsAthletes s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "StudentsAthletes.findByDateOfBirth", query = "SELECT s FROM StudentsAthletes s WHERE s.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "StudentsAthletes.findByGender", query = "SELECT s FROM StudentsAthletes s WHERE s.gender = :gender")
    , @NamedQuery(name = "StudentsAthletes.findByStudentsAddress", query = "SELECT s FROM StudentsAthletes s WHERE s.studentsAddress = :studentsAddress")
    , @NamedQuery(name = "StudentsAthletes.findByOtherDetails", query = "SELECT s FROM StudentsAthletes s WHERE s.otherDetails = :otherDetails")})
public class StudentsAthletes implements Serializable {

    @Column(name = "GENDER")
    private Character gender;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STUDENT_ID", nullable = false, length = 4)
    private String studentId;
    @Column(name = "POINTS_AWARDED_TO_DATE")
    private Integer pointsAwardedToDate;
    @Size(max = 20)
    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;
    @Size(max = 20)
    @Column(name = "MIDDLE_NAME", length = 20)
    private String middleName;
    @Size(max = 20)
    @Column(name = "LAST_NAME", length = 20)
    private String lastName;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 50)
    @Column(name = "STUDENTS_ADDRESS", length = 50)
    private String studentsAddress;
    @Size(max = 20)
    @Column(name = "OTHER_DETAILS", length = 20)
    private String otherDetails;
    @JoinTable(name = "STUDENTS_IN_TEAMS", joinColumns = {
        @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false)})
    @ManyToMany
    private Collection<Teams> teamsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentsAthletes")
    private Collection<StudentsInEvents> studentsInEventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentsAthletes")
    private Collection<StudentsLetters> studentsLettersCollection;

    public StudentsAthletes() {
    }

    public StudentsAthletes(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getPointsAwardedToDate() {
        return pointsAwardedToDate;
    }

    public void setPointsAwardedToDate(Integer pointsAwardedToDate) {
        this.pointsAwardedToDate = pointsAwardedToDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getStudentsAddress() {
        return studentsAddress;
    }

    public void setStudentsAddress(String studentsAddress) {
        this.studentsAddress = studentsAddress;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @XmlTransient
    public Collection<StudentsInEvents> getStudentsInEventsCollection() {
        return studentsInEventsCollection;
    }

    public void setStudentsInEventsCollection(Collection<StudentsInEvents> studentsInEventsCollection) {
        this.studentsInEventsCollection = studentsInEventsCollection;
    }

    @XmlTransient
    public Collection<StudentsLetters> getStudentsLettersCollection() {
        return studentsLettersCollection;
    }

    public void setStudentsLettersCollection(Collection<StudentsLetters> studentsLettersCollection) {
        this.studentsLettersCollection = studentsLettersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsAthletes)) {
            return false;
        }
        StudentsAthletes other = (StudentsAthletes) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.StudentsAthletes[ studentId=" + studentId + " ]";
    }
    
}
