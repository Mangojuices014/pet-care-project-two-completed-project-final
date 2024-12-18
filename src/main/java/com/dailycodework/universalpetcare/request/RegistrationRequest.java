package com.dailycodework.universalpetcare.request;

import com.dailycodework.universalpetcare.enums.ETypeAccount;
import com.dailycodework.universalpetcare.enums.Gender;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegistrationRequest {
    private  Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}
