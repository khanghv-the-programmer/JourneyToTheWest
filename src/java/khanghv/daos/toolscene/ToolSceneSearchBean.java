/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.toolscene;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ToolSceneSearchDTO;

/**
 *
 * @author USER
 */
public class ToolSceneSearchBean implements Serializable{
    private String search;
    private ToolSceneSearchDAO dao;
    private ToolSceneSearchDTO dto;
    public ToolSceneSearchBean() {
        dao = new ToolSceneSearchDAO();
        dto = new ToolSceneSearchDTO();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public Vector<ToolSceneSearchDTO> searchByScene() throws Exception
    {
        return dao.searchByScene(search);
    }
    
    public Vector<ToolSceneSearchDTO> searchByTool() throws Exception
    {
        return dao.searchByTool(search);
    }
    
}
