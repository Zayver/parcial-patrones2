package com.zayver.parcial.adapter.restOutputAdapter.adapter;

import com.zayver.parcial.adapter.application.port.out.EmployeeOutputPort;
import com.zayver.parcial.adapter.application.port.out.JobOutputPort;
import com.zayver.parcial.adapter.restOutputAdapter.mapper.EmployeeMapperRest;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.EmployeeRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.EmployeeResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class EmployeeInputAdapter {
    @Autowired
    private EmployeeOutputPort employeeOutputPort;

    @Autowired
    private JobOutputPort jobOutputPort;

    @Autowired
    private EmployeeMapperRest mapper;

    public EmployeeResponse create(EmployeeRequest request){
        try{
            val employee = mapper.fromAdapterToDomain(request);
            val job = jobOutputPort.findById(request.getIdJob());
            employee.setJob(job);
            val res = employeeOutputPort.save(employee);
            return mapper.fromDomainToAdapter(res);
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e){
            log.error("Error",e.getCause());
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
        }
    }

    public Iterable<EmployeeResponse> getAll(){
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
