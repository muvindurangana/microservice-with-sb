package com.microservice.userservice.service;

import com.microservice.userservice.entity.Users;
import com.microservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {

        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userId);

        Departments department =
                restTemplate.getForObject("http://localhost:8010/departments/" + user.getDepartmentId()
                        ,Departments.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
