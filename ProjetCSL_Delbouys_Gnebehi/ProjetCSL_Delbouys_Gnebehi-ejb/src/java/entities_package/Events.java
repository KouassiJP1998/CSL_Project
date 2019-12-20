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
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")
    , @NamedQuery(name = "Events.findByEventId", query = "SELECT e FROM Events e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Events.findByEventName", query = "SELECT e FROM Events e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Events.findByEventLocation", query = "SELECT e FROM Events e WHERE e.eventLocation = :eventLocation")
    , @NamedQuery(name = "Events.findByStartDate", query = "SELECT e FROM Events e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "Events.findByEndDate", query = "SELECT e FROM Events e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "Events.findByOtherDetails", query = "SELECT e FROM Events e WHERE e.otherDetails = :otherDetails")})
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EVENT_ID", nullable = false, length = 4)
    private String eventId;
    @Size(max = 20)
    @Column(name = "EVENT_NAME", length = 20)
    private String eventName;
    @Size(max = 20)
    @Column(name = "EVENT_LOCATION", length = 20)
    private String eventLocation;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 20)
    @Column(name = "OTHER_DETAILS", length = 20)
    private String otherDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private Collection<StudentsInEvents> studentsInEventsCollection;
    @JoinColumn(name = "SPORT_CODE", referencedColumnName = "SPORT_CODE")
    @ManyToOne
    private Sports sportCode;

    public Events() {
    }

    public Events(String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @XmlTransient
    public Collection<StudentsInEvents> getStudentsInEventsCollection() {
        return studentsInEventsCollection;
    }

    public void setStudentsInEventsCollection(Collection<StudentsInEvents> studentsInEventsCollection) {
        this.studentsInEventsCollection = studentsInEventsCollection;
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
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.Events[ eventId=" + eventId + " ]";
    }
    
}
