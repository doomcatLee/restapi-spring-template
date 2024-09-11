package com.doomcat.restapitemplate.service;

import com.doomcat.restapitemplate.impl.JobService;
import com.doomcat.restapitemplate.model.Job;
import com.doomcat.restapitemplate.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(@RequestBody Job job) {
        jobRepository.save(job);
    }

    @Override
    public Optional<Job> findJob(@RequestBody Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public boolean updateJob(@PathVariable Long id, @RequestBody Job requestJob) {
        Optional<Job> foundJob = jobRepository.findById(id);
        if (foundJob.isPresent()) {
            Job job = foundJob.get();
            job.setLocation(requestJob.getLocation());
            job.setTitle(requestJob.getTitle());
            job.setMinSalary(requestJob.getMinSalary());
            job.setMaxSalary(requestJob.getMaxSalary());
            job.setDescription(requestJob.getDescription());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob(@PathVariable Long id) {
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
