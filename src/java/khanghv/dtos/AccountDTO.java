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
public class AccountDTO implements Serializable{
    private String username, password, fullname, role, img;

    public AccountDTO(String username, String fullname, String role, String img, String desc, String phone, String email) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.img = img;
        this.desc = desc;
        this.phone = phone;
        this.email = email;
    }

    public AccountDTO(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }
    
    

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    private String desc, phone, email;

    public AccountDTO(String username, String fullname, String role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

   

    
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountDTO(String username, String fullname, String role, String desc, String phone, String email) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.desc = desc;
        this.phone = phone;
        this.email = email;
    }

    public AccountDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
