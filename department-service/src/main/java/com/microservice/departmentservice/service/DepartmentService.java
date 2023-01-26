package com.microservice.departmentservice.service;

import com.microservice.departmentservice.entity.Departments;
import com.microservice.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
@EnableSwagger2
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Departments saveDepartment(Departments department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Departments findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
