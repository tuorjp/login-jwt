package com.tuorjp.login_jwt.dto;

import com.tuorjp.login_jwt.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    public String login;
    public String password;
    public UserRole role;
}
