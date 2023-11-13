package com.zayver.parcial.adapter.restOutputAdapter.mapper;

import com.zayver.parcial.adapter.domain.Job;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.JobRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.JobResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapperRest {

    Job fromAdapterToDomain(JobRequest request);

    JobResponse fromDomainToAdapter(Job job);
}
