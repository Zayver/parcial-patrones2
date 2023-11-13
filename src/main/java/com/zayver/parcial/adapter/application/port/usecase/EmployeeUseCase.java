package com.zayver.parcial.adapter.application.port.usecase;

import com.zayver.parcial.adapter.application.port.in.EmployeeInputPort;
import com.zayver.parcial.adapter.application.port.out.EmployeeOutputPort;
import com.zayver.parcial.adapter.domain.Employee;

public class EmployeeUseCase implements EmployeeInputPort {

    private EmployeeOutputPort employeePersistence;

    @Override
    public Employee create(Employee employe) {
        return employeePersistence.save(employe);
    }

    @Override
    public Iterable<Employee> getAll() {
        return employeePersistence.findAll();
    }
}
