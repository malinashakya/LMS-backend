package com.example.hrms.service;

import com.example.hrms.DTO.UserDTO;
import com.example.hrms.model.User;



public interface UserService {
    User save(UserDTO userDTO);
}
