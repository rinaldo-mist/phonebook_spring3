package com.assessment.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assessment.demo.model.Status;

public interface StatusRepository extends JpaRepository<Status, UUID> {
    @Query(value = " SELECT * FROM status WHERE status = ?1 LIMIT 1 ", nativeQuery = true)
    public Status getStatus(String status);

}
