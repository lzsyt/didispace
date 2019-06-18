package com.didispace.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "customer")
public class Customer {
  @Id
  private Integer customerId;

  private String mobile;

  private String name;

  private String realName;

  private Integer idCode;

  private String address;

  private Integer sex;

  private Integer age;

  private Date registerTime;

  private String message;

  private String password;

  private String ip;

  private String website;

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile == null ? null : mobile.trim();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName == null ? null : realName.trim();
  }

  public Integer getIdCode() {
    return idCode;
  }

  public void setIdCode(Integer idCode) {
    this.idCode = idCode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address == null ? null : address.trim();
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message == null ? null : message.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip == null ? null : ip.trim();
  }

  public String getWebsite() {
    return website;
  }
  public void setWebsite(String website) {
    this.website = website;
  }

}
