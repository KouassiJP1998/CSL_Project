/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_package;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Divisions.findAll", query = "SELECT d FROM Divisions d")
    , @NamedQuery(name = "Divisions.findByDivisionCode", query = "SELECT d FROM Divisions d WHERE d.divisionCode = :divisionCode")
    , @NamedQuery(name = "Divisions.findByDivisionDescription", query = "SELECT d FROM Divisions d WHERE d.divisionDescription = :divisionDescription")})
public class Divisions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "DIVISION_CODE", nullable = false, length = 4)
    private String divisionCode;
    @Size(max = 20)
    @Column(name = "DIVISION_DESCRIPTION", length = 20)
    private String divisionDescription;
    @OneToMany(mappedBy = "divisionCode")
    private Collection<Teams> teamsCollection;

    public Divisions() {
    }

    public Divisions(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionDescription() {
        return divisionDescription;
    }

    public void setDivisionDescription(String divisionDescription) {
        this.divisionDescription = divisionDescription;
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
        hash += (divisionCode != null ? divisionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisions)) {
            return false;
        }
        Divisions other = (Divisions) object;
        if ((this.divisionCode == null && other.divisionCode != null) || (this.divisionCode != null && !this.divisionCode.equals(other.divisionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities_package.Divisions[ divisionCode=" + divisionCode + " ]";
    }
    
}
