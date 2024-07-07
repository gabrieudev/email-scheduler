package com.api.email_scheduler.repository;

import com.api.email_scheduler.model.ScheduledEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledEmailRepository extends JpaRepository<ScheduledEmail, Long> {
}
