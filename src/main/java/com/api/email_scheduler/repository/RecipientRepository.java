package com.api.email_scheduler.repository;

import com.api.email_scheduler.model.Recipient;
import com.api.email_scheduler.model.ScheduledEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
    List<Recipient> findByScheduledEmail(ScheduledEmail scheduledEmail);
}
