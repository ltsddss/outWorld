package com.lts.outworld_auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInfo {
    public String userName;
    public String userPassword;
}
