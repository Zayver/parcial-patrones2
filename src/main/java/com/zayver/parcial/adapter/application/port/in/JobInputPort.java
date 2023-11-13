package com.zayver.parcial.adapter.application.port.in;

import com.zayver.parcial.adapter.domain.Job;

import java.util.Optional;

public interface JobInputPort {
    Job create(Job job);
    Iterable<Job> getAll();

    Optional<Job> getById(Integer id);

}
