package com.facu.disney.auth.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
}
