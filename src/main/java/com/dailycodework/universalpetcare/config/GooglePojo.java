package com.dailycodework.universalpetcare.config;

import com.dailycodework.universalpetcare.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GooglePojo {
    @JsonProperty("id")
    private String social_user_id;
    private String email;
    private boolean verified_email;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String locale;
    private String phone_number;  // Số điện thoại
    private Gender gender;        // Giới tính
    private String userType;
}
