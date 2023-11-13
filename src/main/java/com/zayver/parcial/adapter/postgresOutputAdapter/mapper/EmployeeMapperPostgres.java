package com.zayver.parcial.adapter.postgresOutputAdapter.mapper;

import com.zayver.parcial.adapter.domain.Employee;
import com.zayver.parcial.adapter.postgresOutputAdapter.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapperPostgres {
    Employee fromAdapterToDomain(EmployeeEntity employee);
    EmployeeEntity fromDomainToAdapter(Employee employee);
}
