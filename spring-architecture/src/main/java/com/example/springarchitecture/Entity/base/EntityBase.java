package com.example.springarchitecture.entity.base;

import java.time.OffsetDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class EntityBase {    
    private String name;

    private String createdUser;
    private String lastMedifiedUser;

    @CreatedDate
    private OffsetDateTime creaDate;
    @LastModifiedDate
    private OffsetDateTime lastModifiedDate;
}
