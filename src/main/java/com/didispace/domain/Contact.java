package com.didispace.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contact")
public class Contact {
    @Id
    private Integer id;

    private String fixedLinePhone;

    private String address;

    private String mobilePhone;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFixedLinePhone() {
        return fixedLinePhone;
    }

    public void setFixedLinePhone(String fixedLinePhone) {
        this.fixedLinePhone = fixedLinePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}