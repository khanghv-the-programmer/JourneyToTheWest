/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.dtos;

/**
 *
 * @author USER
 */
public class ErrorObj {
    String usernameError, passwordError, fullNameError, confError, desError, phoneError, emailError, imgError;

    public String getImgError() {
        return imgError;
    }

    public void setImgError(String imgError) {
        this.imgError = imgError;
    }

    public ErrorObj() {
    }

    public ErrorObj(String usernameError, String passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getConfError() {
        return confError;
    }

    public void setConfError(String confError) {
        this.confError = confError;
    }

    public String getDesError() {
        return desError;
    }

    public void setDesError(String desError) {
        this.desError = desError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }
    
    
}
