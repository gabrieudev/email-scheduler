package com.api.email_scheduler.config.database;

import com.api.email_scheduler.model.Status;
import com.api.email_scheduler.model.enums.StatusEnum;
import com.api.email_scheduler.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(StatusEnum.values())
                .map(statusEnum -> new Status(statusEnum.getId(), statusEnum.getStatus()))
                .forEach(statusRepository::save);
    }
}
