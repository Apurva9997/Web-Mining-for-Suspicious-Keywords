/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoorv;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Apoorv
 */
@Entity
@Table(name = "results", catalog = "mining_data", schema = "")
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r"),
    @NamedQuery(name = "Results.findById", query = "SELECT r FROM Results r WHERE r.id = :id"),
    @NamedQuery(name = "Results.findByWebsite", query = "SELECT r FROM Results r WHERE r.website = :website"),
    @NamedQuery(name = "Results.findByTotalWords", query = "SELECT r FROM Results r WHERE r.totalWords = :totalWords"),
    @NamedQuery(name = "Results.findBySuspiciousWords", query = "SELECT r FROM Results r WHERE r.suspiciousWords = :suspiciousWords"),
    @NamedQuery(name = "Results.findByAverage", query = "SELECT r FROM Results r WHERE r.average = :average")})
public class Results implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Column(name = "total_words")
    private int totalWords;
    @Basic(optional = false)
    @Column(name = "suspicious_words")
    private int suspiciousWords;
    @Basic(optional = false)
    @Column(name = "average")
    private double average;

    public Results() {
    }

    public Results(Integer id) {
        this.id = id;
    }

    public Results(Integer id, String website, int totalWords, int suspiciousWords, double average) {
        this.id = id;
        this.website = website;
        this.totalWords = totalWords;
        this.suspiciousWords = suspiciousWords;
        this.average = average;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        String oldWebsite = this.website;
        this.website = website;
        changeSupport.firePropertyChange("website", oldWebsite, website);
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        int oldTotalWords = this.totalWords;
        this.totalWords = totalWords;
        changeSupport.firePropertyChange("totalWords", oldTotalWords, totalWords);
    }

    public int getSuspiciousWords() {
        return suspiciousWords;
    }

    public void setSuspiciousWords(int suspiciousWords) {
        int oldSuspiciousWords = this.suspiciousWords;
        this.suspiciousWords = suspiciousWords;
        changeSupport.firePropertyChange("suspiciousWords", oldSuspiciousWords, suspiciousWords);
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        double oldAverage = this.average;
        this.average = average;
        changeSupport.firePropertyChange("average", oldAverage, average);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apoorv.Results[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
