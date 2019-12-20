/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Sports.findAll", query = "SELECT s FROM Sports s")
    , @NamedQuery(name = "Sports.findBySportCode", query = "SELECT s FROM Sports s WHERE s.sportCode = :sportCode")
    , @NamedQuery(name = "Sports.findBySportDescription", query = "SELECT s FROM Sports s WHERE s.sportDescription = :sportDescription")})
public class Sports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SPORT_CODE", nullable = false, length = 4)
    private String sportCode;
    @Size(max = 20)
    @Column(name = "SPORT_DESCRIPTION", length = 20)
    private String sportDescription;
    @OneToMany(mappedBy = "sportCode")
    private Collection<Events> eventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sports")
    private Collection<StudentsLetters> studentsLettersCollection;
    @OneToMany(mappedBy = "sportCode")
    private Collection<Teams> teamsCollection;

    public Sports() {
    }

    public Sports(String sportCode) {
        this.sportCode = sportCode;
    }

    public String getSportCode() {
        return sportCode;
    }

    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }

    @XmlTransient
    public Collection<Events> getEventsCollection() {
        return eventsCollection;
    }

    public void setEventsCollection(Collection<Events> eventsCollection) {
        this.eventsCollection = eventsCollection;
    }

    @XmlTransient
    public Collection<StudentsLetters> getStudentsLettersCollection() {
        return studentsLettersCollection;
    }

    public void setStudentsLettersCollection(Collection<StudentsLetters> studentsLettersCollection) {
        this.studentsLettersCollection = studentsLettersCollection;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sportCode != null ? sportCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sports)) {
            return false;
        }
        Sports other = (Sports) object;
        if ((this.sportCode == null && other.sportCode != null) || (this.sportCode != null && !this.sportCode.equals(other.sportCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.Sports[ sportCode=" + sportCode + " ]";
    }
    
}
