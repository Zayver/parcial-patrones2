package com.zayver.parcial.adapter.restOutputAdapter.model.request;

import com.zayver.parcial.adapter.domain.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String name;
    private String lastname;
    private Integer age;
    private Integer idJob;
}
