package com.zayver.parcial.adapter.postgresOutputAdapter.repository;

import com.zayver.parcial.adapter.postgresOutputAdapter.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {
}
