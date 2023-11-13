package com.zayver.parcial.adapter.postgresOutputAdapter.adapter;

import com.zayver.parcial.adapter.application.port.out.EmployeeOutputPort;
import com.zayver.parcial.adapter.domain.Employee;
import com.zayver.parcial.adapter.postgresOutputAdapter.mapper.EmployeeMapperPostgres;
import com.zayver.parcial.adapter.postgresOutputAdapter.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class EmployeeOutputAdapter implements EmployeeOutputPort {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapperPostgres employeeMapperPostgres;

    @Override
    public Employee save(Employee employee) {
        val entity = employeeMapperPostgres.fromDomainToAdapter(employee);
        val res = employeeRepository.save(entity);
        return employeeMapperPostgres.fromAdapterToDomain(res);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll().stream().map(employeeMapperPostgres::fromAdapterToDomain).collect(Collectors.toSet());
    }
}
