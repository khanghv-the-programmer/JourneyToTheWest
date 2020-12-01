/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.scenes;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.SceneDTO;

/**
 *
 * @author USER
 */
public class SceneBean implements Serializable {

    private String name, id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private SceneDAO dao;
    private SceneDTO dto;

    public SceneBean() {
        dao = new SceneDAO();
        dto = new SceneDTO();
    }

    public Vector<SceneDTO> findByName() throws Exception {
        return dao.findByName(name);
    }

    public SceneDTO getInfo() throws Exception {
        return dao.getInfo(name);
    }

    public Vector<SceneDTO> getListScene() throws Exception {
        return dao.getList();
    }

    public boolean delete() throws Exception {
        return dao.deleteById(id);
    }

    public boolean deleteWithActors() throws Exception {
        return dao.deleteSceneFromActor(id);
    }

    public boolean deleteWithTools() throws Exception {
        return dao.deleteSceneFromTool(id);
    }

    public boolean update() throws Exception {
        return dao.updateScene(dto);
    }

    public Vector<String> getIdList() throws Exception {
        return dao.getIdScene();
    }

    public boolean addScene() throws Exception {
        return dao.createScene(dto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SceneDAO getDao() {
        return dao;
    }

    public void setDao(SceneDAO dao) {
        this.dao = dao;
    }

    public SceneDTO getDto() {
        return dto;
    }

    public void setDto(SceneDTO dto) {
        this.dto = dto;
    }

}
