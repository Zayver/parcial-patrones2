package com.zayver.parcial.adapter.application.port.out;

import com.zayver.parcial.adapter.domain.Employee;

public interface EmployeeOutputPort {
    Employee save(Employee employee);
    Iterable<Employee> findAll();
}
