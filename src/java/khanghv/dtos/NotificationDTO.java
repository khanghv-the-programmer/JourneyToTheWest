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
public class NotificationDTO implements Serializable{
    private String editor, receiver, content;

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationDTO() {
    }

    public NotificationDTO(String editor, String receiver, String content) {
        this.editor = editor;
        this.receiver = receiver;
        this.content = content;
    }
    
}
