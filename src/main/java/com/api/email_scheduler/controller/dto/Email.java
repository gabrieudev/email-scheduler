package com.api.email_scheduler.controller.dto;

public record Email(
        String to,
        String subject,
        String body
) {
}
