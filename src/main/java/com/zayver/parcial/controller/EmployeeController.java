package com.zayver.parcial.controller;

import com.zayver.parcial.adapter.restOutputAdapter.adapter.EmployeeInputAdapter;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.EmployeeRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adapter/employee")
public class EmployeeController {
    @Autowired
    private EmployeeInputAdapter employeeInputAdapter;

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request){
        return employeeInputAdapter.create(request);
    }

    @GetMapping
    public Iterable<EmployeeResponse> getAll(){
        return employeeInputAdapter.getAll();
    }

}
