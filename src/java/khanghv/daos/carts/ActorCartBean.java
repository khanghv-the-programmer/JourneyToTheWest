/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.carts;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ASCartDTO;
import khanghv.dtos.SceneActorDTO;

/**
 *
 * @author USER
 */
public class ActorCartBean implements Serializable{
    String id, desc, editor, username, isScene, status, fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    ActorCartDAO dao;
    ASCartDTO dto; 

    public ActorCartBean() {
        dao = new ActorCartDAO();
        dto = new ASCartDTO();
    }
    
    public boolean deleteActorInScene() throws Exception
    {
        return dao.deleteActorFromScene(id, username);
    }
    public Vector<String> getIdList() throws Exception
    {   
        return dao.listIdAcCart();
    }
    public Vector<SceneActorDTO> findByScene() throws Exception
    {
        return dao.findByScene(username);
    }
    public Vector<SceneActorDTO> findByActor() throws Exception
    {
        return dao.findByActor(username);
    }
    public Vector<SceneActorDTO> findAll() throws Exception
    {
        return dao.findAll();
    }
    public Vector<SceneActorDTO> findOfActor() throws Exception
    {
        return dao.findOfActor(fullname);
    }
    
    
    public boolean add() throws Exception
    {
        return dao.addCartActor(dto);
    }
    public Vector<ASCartDTO> getUsernameScene() throws Exception
    {
        return dao.listUsernameScene();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsScene() {
        return isScene;
    }

    public void setIsScene(String isScene) {
        this.isScene = isScene;
    }

    public ActorCartDAO getDao() {
        return dao;
    }

    public void setDao(ActorCartDAO dao) {
        this.dao = dao;
    }

    public ASCartDTO getDto() {
        return dto;
    }

    public void setDto(ASCartDTO dto) {
        this.dto = dto;
    }
    
    
    
}
