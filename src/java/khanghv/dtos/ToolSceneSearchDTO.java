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
public class ToolSceneSearchDTO implements Serializable{
    private String cartid, sid, scenename, tid, toolname, starttime, endtime, time;
    private int quantityhad, quantityget;

    public ToolSceneSearchDTO() {
    }

    public ToolSceneSearchDTO(String cartid, String sid, String scenename, String tid, String toolname, String starttime, String endtime, int quantityhad, int quantityget, String time) {
        this.cartid = cartid;
        this.sid = sid;
        this.scenename = scenename;
        this.tid = tid;
        this.toolname = toolname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.quantityhad = quantityhad;
        this.quantityget = quantityget;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getScenename() {
        return scenename;
    }

    public void setScenename(String scenename) {
        this.scenename = scenename;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getQuantityhad() {
        return quantityhad;
    }

    public void setQuantityhad(int quantityhad) {
        this.quantityhad = quantityhad;
    }

    public int getQuantityget() {
        return quantityget;
    }

    public void setQuantityget(int quantityget) {
        this.quantityget = quantityget;
    }
    
    
    
}
