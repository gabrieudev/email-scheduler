package com.api.email_scheduler.controller.dto;

import com.api.email_scheduler.model.Recipient;
import com.api.email_scheduler.model.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledEmailDTO {

    private Long id;

    @NotBlank
    private String senderEmail;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    @NotNull
    @Future
    private Instant sendTime;

    @NotNull
    private Status status;

    @NotNull
    private List<Recipient> recipients;

}
