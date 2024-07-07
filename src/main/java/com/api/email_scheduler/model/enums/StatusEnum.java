package com.api.email_scheduler.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    SENT(1L, "sent"),
    PENDING(2L, "pending"),
    FAILED(3L, "failed");

    private Long id;
    private String status;
}
