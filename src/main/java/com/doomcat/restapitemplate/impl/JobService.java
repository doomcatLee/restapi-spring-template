package com.doomcat.restapitemplate.impl;

import com.doomcat.restapitemplate.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    Optional<Job> findJob(Long id);
    void createJob(Job job);
    boolean updateJob(Long id, Job job);
    boolean deleteJob(Long id);
}
