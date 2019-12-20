/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Falkke
 */
@Embeddable
public class StudentsLettersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "STUDENT_ID", nullable = false, length = 4)
    private String studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SPORT_CODE", nullable = false, length = 4)
    private String sportCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_AWARDED", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateAwarded;

    public StudentsLettersPK() {
    }

    public StudentsLettersPK(String studentId, String sportCode, Date dateAwarded) {
        this.studentId = studentId;
        this.sportCode = sportCode;
        this.dateAwarded = dateAwarded;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSportCode() {
        return sportCode;
    }

    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }

    public Date getDateAwarded() {
        return dateAwarded;
    }

    public void setDateAwarded(Date dateAwarded) {
        this.dateAwarded = dateAwarded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        hash += (sportCode != null ? sportCode.hashCode() : 0);
        hash += (dateAwarded != null ? dateAwarded.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsLettersPK)) {
            return false;
        }
        StudentsLettersPK other = (StudentsLettersPK) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        if ((this.sportCode == null && other.sportCode != null) || (this.sportCode != null && !this.sportCode.equals(other.sportCode))) {
            return false;
        }
        if ((this.dateAwarded == null && other.dateAwarded != null) || (this.dateAwarded != null && !this.dateAwarded.equals(other.dateAwarded))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.StudentsLettersPK[ studentId=" + studentId + ", sportCode=" + sportCode + ", dateAwarded=" + dateAwarded + " ]";
    }
    
}
