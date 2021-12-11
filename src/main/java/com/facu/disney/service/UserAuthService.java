package com.facu.disney.service;

import com.facu.disney.dto.AuthenticationRequest;

public interface UserAuthService {

    public void singIn(AuthenticationRequest authRequest);
    
}
