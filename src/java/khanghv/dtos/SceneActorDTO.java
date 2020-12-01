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
public class SceneActorDTO implements Serializable{
    
    private String idsc, scname, username, fullname, loc, desc, role, img, time, acting, start, end;
    private int takes;

    public SceneActorDTO() {
    }

    public SceneActorDTO(String idsc, String scname, String username, String fullname, String loc, String desc, String role) {
        this.idsc = idsc;
        this.scname = scname;
        this.username = username;
        this.fullname = fullname;
        this.loc = loc;
        this.desc = desc;
        this.role = role;
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

    public SceneActorDTO(String idsc, String scname, String username, String fullname, String loc, String desc, String role, String img, String time, String acting) {
        this.idsc = idsc;
        this.scname = scname;
        this.username = username;
        this.fullname = fullname;
        this.loc = loc;
        this.desc = desc;
        this.role = role;
        this.img = img;
        this.time = time;
        this.acting = acting;
        
    }

    public SceneActorDTO(String idsc, String scname, String username, String fullname, String loc, String desc, String role, String img, String time, String acting, int takes, String start, String end) {
        this.idsc = idsc;
        this.scname = scname;
        this.username = username;
        this.fullname = fullname;
        this.loc = loc;
        this.desc = desc;
        this.role = role;
        this.img = img;
        this.time = time;
        this.acting = acting;
        this.takes = takes;
        this.start = start;
        this.end = end;
    }

    public int getTakes() {
        return takes;
    }

    public void setTakes(int takes) {
        this.takes = takes;
    }
    
    public String getTime() {
        return time;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIdsc() {
        return idsc;
    }

    public void setIdsc(String idsc) {
        this.idsc = idsc;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
