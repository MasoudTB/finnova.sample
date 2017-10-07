package com.alibaba.finnova.sample.Models.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String fullName;
    private String email;
}
