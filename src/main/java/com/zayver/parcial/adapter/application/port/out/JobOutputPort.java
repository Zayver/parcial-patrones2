package com.zayver.parcial.adapter.application.port.out;

import com.zayver.parcial.adapter.domain.Job;

public interface JobOutputPort {
    Job save(Job job);
    Iterable<Job> findAll();

    Job findById(Integer id);
}
