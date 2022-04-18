package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * like vo for output to transmit the user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessage {
    private String name;
}
