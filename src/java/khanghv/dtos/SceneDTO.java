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
public class SceneDTO implements Serializable{
    private String id, name, desc, location, start, end;
    int take;

    public SceneDTO(String id, String name, String desc, String location, String start, String end, int take) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.start = start;
        this.end = end;
        this.take = take;
    }

    public SceneDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public SceneDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }
    
}
