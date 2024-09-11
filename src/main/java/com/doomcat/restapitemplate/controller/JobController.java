package com.doomcat.restapitemplate.controller;

import com.doomcat.restapitemplate.impl.JobService;
import com.doomcat.restapitemplate.model.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJob(@PathVariable Long id) {
        Optional<Job> searchedJob = jobService.findJob(id);
        if (searchedJob.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchedJob.get(), HttpStatus.OK);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
        boolean updated = jobService.updateJob(id, job);
        if (updated) {
            return new ResponseEntity<>("Job updated sucessfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJob(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }
}
