package com.josemeurer.api.valida.usuario.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email should be valid")
    private String email;
    private String code;
    private Instant createAt;

    public User(String email, String code) {
        this.email = email;
        this.code = code;
        this.createAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public Instant getCreateAt() {
        return createAt;
    }
}
