package com.doomcat.restapitemplate.repository;

import com.doomcat.restapitemplate.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
