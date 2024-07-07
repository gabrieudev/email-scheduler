package com.api.email_scheduler.controller.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipientDTO {
    private Long id;

    @Email
    private String email;

}
