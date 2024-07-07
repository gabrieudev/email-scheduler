package com.api.email_scheduler.service;

import com.api.email_scheduler.controller.dto.Email;
import com.api.email_scheduler.controller.dto.ScheduledEmailDTO;
import com.api.email_scheduler.exception.BusinessRuleException;
import com.api.email_scheduler.exception.EntityNotFoundException;
import com.api.email_scheduler.model.Recipient;
import com.api.email_scheduler.model.ScheduledEmail;
import com.api.email_scheduler.model.Status;
import com.api.email_scheduler.repository.RecipientRepository;
import com.api.email_scheduler.repository.ScheduledEmailRepository;
import com.api.email_scheduler.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class ScheduledEmailService {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ScheduledEmailRepository scheduledEmailRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    public void send(LocalDateTime sendTime) {
        Status pendingStatus = statusRepository.findByStatus("pending").orElseThrow();
        List<ScheduledEmail> pendingScheduledEmails = scheduledEmailRepository.findByStatusAndSendTimeBefore(pendingStatus, sendTime);
        pendingScheduledEmails.forEach(sendEmail());
    }

    private Consumer<ScheduledEmail> sendEmail() {
        Status sentStatus = statusRepository.findByStatus("sent").orElseThrow();
        return scheduledEmail -> {
            List<Recipient> recipients = recipientRepository.findByScheduledEmail(scheduledEmail);
            recipients.forEach(
                    recipient -> {
                        Email email = new Email(
                                scheduledEmail.getSenderEmail(),
                                recipient.getEmail(),
                                scheduledEmail.getSubject(),
                                scheduledEmail.getBody()
                        );
                        emailService.send(email);
                    }
            );
            log.info("emails sent from {}", scheduledEmail.getSenderEmail());
            scheduledEmail.setStatus(sentStatus);
            scheduledEmailRepository.save(scheduledEmail);
        };
    }

    public void save(ScheduledEmailDTO scheduledEmailDTO) {
        Status pendingStatus = statusRepository.findByStatus("pending").orElseThrow();
        scheduledEmailDTO.setStatus(pendingStatus);
        ScheduledEmail scheduledEmail = mappingService.toModel(scheduledEmailDTO);
        if (scheduledEmail.hasDuplicate()) {
            throw new BusinessRuleException("Contains duplicate emails");
        }
        scheduledEmailRepository.save(scheduledEmail);
    }

    public ScheduledEmailDTO getById(Long id) {
        ScheduledEmail scheduledEmail = scheduledEmailRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Scheduled email not found with this id: " + id)
        );
        return mappingService.toDto(scheduledEmail);
    }

    public ScheduledEmailDTO update(Long id, ScheduledEmailDTO scheduledEmailDTO) {
        ScheduledEmail scheduledEmail = scheduledEmailRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Scheduled email not found with this id: " + id)
        );
        mappingService.toModel(scheduledEmailDTO, scheduledEmail);
        ScheduledEmail updatedScheduledEmail = scheduledEmailRepository.save(mappingService.toModel(scheduledEmailDTO));
        return mappingService.toDto(updatedScheduledEmail);
    }

    public void delete(Long id) {
        ScheduledEmail scheduledEmail = scheduledEmailRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Scheduled email not found with this id: " + id)
        );
        scheduledEmailRepository.delete(scheduledEmail);
    }

    public Page<ScheduledEmailDTO> getAll(Pageable pageable) {
        return scheduledEmailRepository.findAll(pageable).map(
                scheduledEmail -> mappingService.toDto(scheduledEmail)
        );
    }

}
