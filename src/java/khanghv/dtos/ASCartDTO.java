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
public class ASCartDTO implements Serializable{
    String id, idScene, username, desc, editor, status, time, acting;

    public ASCartDTO() {
    }

    public ASCartDTO(String id, String idScene, String username, String desc, String editor, String status, String acting) {
        this.id = id;
        this.idScene = idScene;
        this.username = username;
        this.desc = desc;
        this.editor = editor;
        this.status = status;
        this.acting = acting;
    }

    public ASCartDTO(String id, String idScene, String username, String desc, String editor, String status, String time, String acting) {
        this.id = id;
        this.idScene = idScene;
        this.username = username;
        this.desc = desc;
        this.editor = editor;
        this.status = status;
        this.time = time;
        this.acting = acting;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    public ASCartDTO(String idScene, String username) {
        this.idScene = idScene;
        this.username = username;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdScene() {
        return idScene;
    }

    public void setIdScene(String idScene) {
        this.idScene = idScene;
    }

    public String getUsername() {
        return username;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    
    
    
}
