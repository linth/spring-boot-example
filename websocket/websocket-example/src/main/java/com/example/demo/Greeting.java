package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * like vo for input data from user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    private String message;
}
