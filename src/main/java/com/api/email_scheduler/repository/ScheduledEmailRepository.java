package com.api.email_scheduler.repository;

import com.api.email_scheduler.model.ScheduledEmail;
import com.api.email_scheduler.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ScheduledEmailRepository extends JpaRepository<ScheduledEmail, Long> {

    List<ScheduledEmail> findByStatusAndSendTimeBefore(Status status, Instant sendTime);
}
