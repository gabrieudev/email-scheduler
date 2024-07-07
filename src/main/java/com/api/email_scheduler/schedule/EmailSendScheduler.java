package com.api.email_scheduler.schedule;

import com.api.email_scheduler.service.ScheduledEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EmailSendScheduler {

    @Autowired
    private ScheduledEmailService scheduledEmailService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void send() {
        LocalDateTime now = LocalDateTime.now();
        scheduledEmailService.send(now);
        log.info("running at {}", now);
    }

}
