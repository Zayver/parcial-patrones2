package com.zayver.parcial.adapter.postgresOutputAdapter.repository;

import com.zayver.parcial.adapter.postgresOutputAdapter.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
