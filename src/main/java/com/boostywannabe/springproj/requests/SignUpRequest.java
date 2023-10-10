package com.boostywannabe.springproj.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {
    String username;
    String password;
}
