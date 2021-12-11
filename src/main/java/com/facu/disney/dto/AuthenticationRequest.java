package com.facu.disney.dto;

import lombok.*;

@Getter
@Setter
public class AuthenticationRequest {

    private String username;
    private String password;
}
