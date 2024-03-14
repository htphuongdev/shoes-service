package com.htp.service.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {
    private String code;
    private String password;
    private String firstName;
    private String lastName;
}
