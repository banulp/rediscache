package com.banulp.rediscache.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BanulpUser implements Serializable {

    @Id
    private String uid;
    private String uname;

    public BanulpUser(String uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public BanulpUser() {

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
