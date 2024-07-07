package com.api.email_scheduler.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipientDTO {
    private Long id;

    private String email;

}
