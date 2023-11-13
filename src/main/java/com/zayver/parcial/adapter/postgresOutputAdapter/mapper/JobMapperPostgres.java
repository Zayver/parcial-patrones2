package com.zayver.parcial.adapter.postgresOutputAdapter.mapper;

import com.zayver.parcial.adapter.domain.Job;
import com.zayver.parcial.adapter.postgresOutputAdapter.entity.JobEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapperPostgres {
    Job fromAdapterToDomain(JobEntity job);
    JobEntity fromDomainToAdapter(Job job);
}
