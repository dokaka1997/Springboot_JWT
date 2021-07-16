package com.dvdo.service.impl;

import com.dvdo.model.entity.UserEntity;
import com.dvdo.model.request.UserRequest;
import com.dvdo.model.response.UserResponse;
import com.dvdo.repository.UserRepository;
import com.dvdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        if (userRepository.getByUsername(userRequest.getUsername()).isPresent()){
            throw new RuntimeException("Username existed");
        }
        userRepository.save(userEntity);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setUsername(userEntity.getUsername());
        return userResponse;
    }

    @Override
    public boolean login(UserRequest userRequest) {
        Optional<UserEntity> userEntity = userRepository.getByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());
        return userEntity.isPresent();
    }
}
