package com.tuorjp.login_jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {
    public String login;
    public String password;
}
