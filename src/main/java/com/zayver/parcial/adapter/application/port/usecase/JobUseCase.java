package com.zayver.parcial.adapter.application.port.usecase;

import com.zayver.parcial.adapter.application.port.in.JobInputPort;
import com.zayver.parcial.adapter.domain.Job;
import lombok.val;

import java.util.Optional;

public class JobUseCase implements JobInputPort {

    private JobInputPort jobPersistence;

    @Override
    public Job create(Job job) {
        return jobPersistence.create(job);
    }

    @Override
    public Iterable<Job> getAll() {
        return jobPersistence.getAll();
    }

    @Override
    public Optional<Job> getById(Integer id) {
        return jobPersistence.getById(id);
    }
}
