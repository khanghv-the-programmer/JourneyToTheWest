/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.dtos;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class LookUpDTO implements Serializable{
    private String sid, sname, start, end, username, fullname, email, phone, aimg, role, tname, timg, acting;
    private int takes, qhad, qneed;

    public LookUpDTO() {
    }

    public LookUpDTO(String sid, String sname, String start, String end, String username, String fullname, String email, String phone, String aimg, String role, String tname, String timg, int takes, int qhad, int qneed, String acting) {
        this.sid = sid;
        this.sname = sname;
        this.start = start;
        this.end = end;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.aimg = aimg;
        this.role = role;
        this.tname = tname;
        this.timg = timg;
        this.takes = takes;
        this.qhad = qhad;
        this.qneed = qneed;
        this.acting = acting;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTimg() {
        return timg;
    }

    public void setTimg(String timg) {
        this.timg = timg;
    }

    public int getTakes() {
        return takes;
    }

    public void setTakes(int takes) {
        this.takes = takes;
    }

    public int getQhad() {
        return qhad;
    }

    public void setQhad(int qhad) {
        this.qhad = qhad;
    }

    public int getQneed() {
        return qneed;
    }

    public void setQneed(int qneed) {
        this.qneed = qneed;
    }
    
    
}
