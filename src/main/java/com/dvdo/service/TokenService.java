package com.dvdo.service;

import com.dvdo.model.request.JwtRequest;
import com.dvdo.model.response.JwtResponse;

public interface TokenService {
    String getRefreshTokenById(Long id);

    JwtResponse generateToken(JwtRequest authenticationRequest);
}
