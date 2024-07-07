package com.api.email_scheduler.controller;

import com.api.email_scheduler.controller.dto.ScheduledEmailDTO;
import com.api.email_scheduler.service.ScheduledEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/scheduled-emails")
public class ScheduledEmailController {

    @Autowired
    private ScheduledEmailService scheduledEmailService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ScheduledEmailDTO scheduledEmailDTO) {
        scheduledEmailService.save(scheduledEmailDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{scheduledEmailId}")
    public ResponseEntity<ScheduledEmailDTO> getById(@PathVariable("scheduledEmailId") Long scheduledEmailId) {
        return ResponseEntity.ok(scheduledEmailService.getById(scheduledEmailId));
    }

    @GetMapping
    public ResponseEntity<List<ScheduledEmailDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(scheduledEmailService.getAll(pageable).getContent());
    }

    @PutMapping("/{scheduledEmailId}")
    public ResponseEntity<ScheduledEmailDTO> update(
        @PathVariable("/{scheduledEmailId}") Long scheduledEmailId,
        @RequestBody ScheduledEmailDTO scheduledEmailDTO
    ) {
        return ResponseEntity.ok(scheduledEmailService.update(scheduledEmailId, scheduledEmailDTO));
    }

    @DeleteMapping("/{scheduledEmailId}")
    public ResponseEntity<Void> delete(@PathVariable("/{scheduledEmailId}") Long scheduledEmailId) {
        scheduledEmailService.delete(scheduledEmailId);
        return ResponseEntity.ok().build();
    }

}
