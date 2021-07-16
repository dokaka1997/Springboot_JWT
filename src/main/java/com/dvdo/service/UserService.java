package com.dvdo.service;

import com.dvdo.model.request.UserRequest;
import com.dvdo.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    boolean login(UserRequest userRequest);
}
