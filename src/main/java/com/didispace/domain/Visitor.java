package com.didispace.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "visitor")
public class Visitor {
    @Id
    private Integer id;

    private String visitorName;

    private String ip;

    private String visitorPage;

    private Date visitorTime;

    private String visitorAddr;

    private Integer visitorType;

    private String visitorPagename;

    private Integer visitorProductid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName == null ? null : visitorName.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getVisitorPage() {
        return visitorPage;
    }

    public void setVisitorPage(String visitorPage) {
        this.visitorPage = visitorPage == null ? null : visitorPage.trim();
    }

    public Date getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
        this.visitorTime = visitorTime;
    }

    public String getVisitorAddr() {
        return visitorAddr;
    }

    public void setVisitorAddr(String visitorAddr) {
        this.visitorAddr = visitorAddr == null ? null : visitorAddr.trim();
    }

    public Integer getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(Integer visitorType) {
        this.visitorType = visitorType;
    }

    public String getVisitorPagename() {
        return visitorPagename;
    }

    public void setVisitorPagename(String visitorPagename) {
        this.visitorPagename = visitorPagename == null ? null : visitorPagename.trim();
    }

    public Integer getVisitorProductid() {
        return visitorProductid;
    }

    public void setVisitorProductid(Integer visitorProductid) {
        this.visitorProductid = visitorProductid;
    }
}