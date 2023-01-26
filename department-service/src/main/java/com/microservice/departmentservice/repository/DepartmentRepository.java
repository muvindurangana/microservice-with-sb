package com.microservice.departmentservice.repository;

import com.microservice.departmentservice.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long> {

    Departments findByDepartmentId(Long departmentId);
}
