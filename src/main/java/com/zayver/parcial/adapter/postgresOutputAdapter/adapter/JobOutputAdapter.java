package com.zayver.parcial.adapter.postgresOutputAdapter.adapter;

import com.zayver.parcial.adapter.application.port.out.JobOutputPort;
import com.zayver.parcial.adapter.domain.Job;
import com.zayver.parcial.adapter.postgresOutputAdapter.mapper.JobMapperPostgres;
import com.zayver.parcial.adapter.postgresOutputAdapter.repository.JobRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Transactional
public class JobOutputAdapter implements JobOutputPort {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapperPostgres jobMapperPostgres;

    @Override
    public Job save(Job job) {
        val res = jobRepository.save(jobMapperPostgres.fromDomainToAdapter(job));
        return jobMapperPostgres.fromAdapterToDomain(res);
    }

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll().stream().map(jobMapperPostgres::fromAdapterToDomain).collect(Collectors.toSet());
    }

    @Override
    public Job findById(Integer id) {
        val res = jobRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return jobMapperPostgres.fromAdapterToDomain(res);
    }
}
