package org.example.entity;


import lombok.Data;

/**
 * @author yukangming
 */
@Data
public class User
{
    public User() {
    }

    private Long id;

    private String userName;

    private String password;
}
