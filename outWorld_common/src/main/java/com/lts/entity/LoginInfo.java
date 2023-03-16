package com.lts.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    public String userName;
    public String userPassword;
    public String userStatus;
}
