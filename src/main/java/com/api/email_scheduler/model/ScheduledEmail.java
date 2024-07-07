package com.api.email_scheduler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_scheduled_emails")
public class ScheduledEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_email", nullable = false)
    private String senderEmail;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private LocalDateTime sendTime;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(
            mappedBy = "scheduledEmail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Recipient> recipients = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void associate() {
        this.recipients.forEach(
                recipient -> recipient.setScheduledEmail(this)
        );
    }

    public boolean hasDuplicate() {
        List<String> emails = new ArrayList<>();
        this.recipients.forEach(
                recipient -> {
                    emails.add(recipient.getEmail());
                }
        );
        return emails.size() != emails.stream().distinct().count();
    }

}
