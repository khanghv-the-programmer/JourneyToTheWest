/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.tools;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ToolDTO;

/**
 *
 * @author USER
 */
public class ToolBeans implements Serializable{
    private String id, name;
    private ToolDAO dao;
    private ToolDTO dto;
    public ToolBeans() {
        dao = new ToolDAO();
        dto = new ToolDTO();
    }
    
    public Vector<ToolDTO> findTools(String search) throws Exception
    {
        return dao.findToolsByName(search);
    }
    public boolean deleteTool() throws Exception
    {
        return dao.deleteTool(id);
    }
    public boolean deleteToolAssigned() throws Exception
    {
        return dao.deleteToolAssined(id);
    }
    public ToolDTO getInfo() throws Exception
    {
        return dao.findToolById(id);
    }
    
    public String getId() {
        return id;
    }
    
    public boolean update(ToolDTO dto) throws Exception
    {
        return dao.updateTool(dto);
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

    public ToolDAO getDao() {
        return dao;
    }

    public void setDao(ToolDAO dao) {
        this.dao = dao;
    }

    public ToolDTO getDto() {
        return dto;
    }

    public void setDto(ToolDTO dto) {
        this.dto = dto;
    }
    
    public String getLastId() throws Exception
    {
        return dao.getID().get(dao.getID().size()-1);
    }
    
    public boolean create () throws Exception
    {
        return dao.createTools(dto);
    }
    
    
    public Vector<ToolDTO> getToolsList() throws Exception
    {
        return dao.getToolList();
    }
}
