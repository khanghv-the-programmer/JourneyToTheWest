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
public class ToolSceneDTO implements Serializable{
    private String cId, editor, tid, sid, status, time;
    private int quantity;

    public ToolSceneDTO(String cId, String editor, String tid, String sid, String status, int quantity) {
        this.cId = cId;
        this.editor = editor;
        this.tid = tid;
        this.sid = sid;
        this.status = status;
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ToolSceneDTO(String cId, String editor, String tid, String sid, String status, int quantity, String time) {
        this.cId = cId;
        this.editor = editor;
        this.tid = tid;
        this.sid = sid;
        this.status = status;
        this.quantity = quantity;
        this.time = time;
    }

    public ToolSceneDTO(String tid, String sid) {
        this.tid = tid;
        this.sid = sid;
    }
    
    

    public ToolSceneDTO() {
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
