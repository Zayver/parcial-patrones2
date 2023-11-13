package com.zayver.parcial.controller;

import com.zayver.parcial.adapter.restOutputAdapter.adapter.JobInputAdapter;
import com.zayver.parcial.adapter.restOutputAdapter.model.request.JobRequest;
import com.zayver.parcial.adapter.restOutputAdapter.model.response.JobResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adapter/job")
public class JobController {
    @Autowired
    private JobInputAdapter jobInputAdapter;

    @PostMapping
    public JobResponse createJob(@RequestBody JobRequest request){
        return jobInputAdapter.create(request);
    }

    @GetMapping
    public Iterable<JobResponse> getAll(){
        return jobInputAdapter.getAll();
    }
}
