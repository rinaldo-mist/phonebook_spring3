package com.assessment.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// id, status, code, date_created , created_by , date_updated, updated_by

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String status;
    private int code;
    private Timestamp date_created;
    private String created_by;
    private Timestamp date_updated;
    private String updated_by;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Timestamp getDate_created() {
        return date_created;
    }
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }
    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
    public Timestamp getDate_updated() {
        return date_updated;
    }
    public void setDate_updated(Timestamp date_updated) {
        this.date_updated = date_updated;
    }
    public String getUpdated_by() {
        return updated_by;
    }
    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
    
}
