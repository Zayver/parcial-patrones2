package com.zayver.parcial.adapter.application.port.in;

import com.zayver.parcial.adapter.domain.Employee;

public interface EmployeeInputPort {
    Employee create(Employee employe);
    Iterable<Employee> getAll();
}
