package com.assessment.demo.model;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// id, role, date_created, created_by, date_updated, updated_by, status

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String role;
    private Timestamp date_created;
    private UUID created_by;
    private Timestamp date_updated;
    private UUID updated_by;
    private UUID status;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Timestamp getDate_created() {
        return date_created;
    }
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }
    public UUID getCreated_by() {
        return created_by;
    }
    public void setCreated_by(UUID created_by) {
        this.created_by = created_by;
    }
    public Timestamp getDate_updated() {
        return date_updated;
    }
    public void setDate_updated(Timestamp date_updated) {
        this.date_updated = date_updated;
    }
    public UUID getUpdated_by() {
        return updated_by;
    }
    public void setUpdated_by(UUID updated_by) {
        this.updated_by = updated_by;
    }
    public UUID getStatus() {
        return status;
    }
    public void setStatus(UUID status) {
        this.status = status;
    }
}