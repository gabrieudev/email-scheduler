package com.api.email_scheduler.service;

import com.api.email_scheduler.controller.dto.ScheduledEmailDTO;
import com.api.email_scheduler.model.ScheduledEmail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    @Autowired
    private ModelMapper modelMapper;

    public ScheduledEmail toModel(ScheduledEmailDTO scheduledEmailDTO) {
        return modelMapper.map(scheduledEmailDTO, ScheduledEmail.class);
    }

    public ScheduledEmailDTO toDto(ScheduledEmail scheduledEmail) {
        return modelMapper.map(scheduledEmail, ScheduledEmailDTO.class);
    }

    public void toModel(ScheduledEmailDTO scheduledEmailDTO, ScheduledEmail scheduledEmail) {
        modelMapper.map(scheduledEmailDTO, scheduledEmail);
    }

}
