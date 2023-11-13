package com.zayver.parcial.adapter.restOutputAdapter.mapper;

import com.zayver.parcial.adapter.domain.Employee;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.EmployeeRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.EmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapperRest {

    Employee fromAdapterToDomain(EmployeeRequest request);

    EmployeeResponse fromDomainToAdapter(Employee employee);
}
