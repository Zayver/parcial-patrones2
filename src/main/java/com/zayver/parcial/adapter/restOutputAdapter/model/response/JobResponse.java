package com.zayver.parcial.adapter.restOutputAdapter.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    private Integer id;
    private String name;
    private Double salary;
}
