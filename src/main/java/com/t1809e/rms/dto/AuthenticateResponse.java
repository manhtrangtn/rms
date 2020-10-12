package com.t1809e.rms.dto;

import java.time.LocalDate;

public class AuthenticateResponse {

    private String token;
    private LocalDate createdDate = LocalDate.now();

    public AuthenticateResponse() {
    }

    public AuthenticateResponse(String token, LocalDate createdDate) {
        this.token = token;
        this.createdDate = createdDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
