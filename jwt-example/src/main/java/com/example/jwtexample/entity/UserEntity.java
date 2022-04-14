package com.example.jwtexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserEntity {
    // private Integer 2fa;
    private String accessToken;
    // private BoviaGroup group;

    // private Integer lifetime;
    // private String refreshToken;
    // private Integer rent;

    // private String site;
    // private BoviaSiteList siteList;
    // private BoviaUser user;
    // private String version;
}
