package com.zayver.parcial.adapter.restOutputAdapter.adapter;

import com.zayver.parcial.adapter.application.port.out.JobOutputPort;
import com.zayver.parcial.adapter.restOutputAdapter.mapper.JobMapperRest;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.JobRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.JobResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class JobInputAdapter {
    @Autowired
    private JobOutputPort employeeOutputPort;

    @Autowired
    private JobMapperRest mapper;

    public JobResponse create(JobRequest request){
        try{
            val res = employeeOutputPort.save(mapper.fromAdapterToDomain(request));
            return mapper.fromDomainToAdapter(res);
        }catch (Exception e){
            log.error("Error",e.getCause());
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
        }
    }

    public Iterable<JobResponse> getAll(){
        try{
            return Stream.of(employeeOutputPort.findAll())
                    .flatMap(iterableElement -> StreamSupport.stream(iterableElement.spliterator(), false))
                    .map(mapper::fromDomainToAdapter)
                    .collect(Collectors.toSet());
        }catch (Exception e){
            log.error("Error",e.getCause());
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
        }
    }
}
