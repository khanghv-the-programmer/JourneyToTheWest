/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.toolscene;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ToolSceneDTO;


/**
 *
 * @author USER
 */
public class GetToolSceneBean implements Serializable{
    private String toolName, sceneName, idTool, idScene, time;
    private int orderQuantity;

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public boolean updateCart() throws Exception
    {
        return dao.updateQuantity(idTool, idScene, orderQuantity, time);
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    
    public String getIdTool() {
        return idTool;
    }

    public void setIdTool(String idTool) {
        this.idTool = idTool;
    }

    public String getIdScene() {
        return idScene;
    }

    public void setIdScene(String idScene) {
        this.idScene = idScene;
    }
    private ToolSceneDTO dto;
    private GetToolSceneDAO dao;

    public GetToolSceneBean() {
        dto = new ToolSceneDTO();
        dao = new GetToolSceneDAO();
    }
    public int getQuantity() throws Exception
    {
        return dao.getQuantity(idTool, idScene);
    }
    public boolean addToolScene() throws Exception
    {
        return dao.addToolScene(dto);
    }
    public String getToolName() {
        return toolName;
    }
    public Vector<String> getIdList() throws Exception
    {
        return  dao.getToolSceneId();
    }
    
    public Vector<ToolSceneDTO> getTwoIds() throws Exception
    {
        return dao.getTwoIds();
    }
    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public ToolSceneDTO getDto() {
        return dto;
    }

    public void setDto(ToolSceneDTO dto) {
        this.dto = dto;
    }

    public GetToolSceneDAO getDao() {
        return dao;
    }

    public void setDao(GetToolSceneDAO dao) {
        this.dao = dao;
    }
    
    public boolean deleteToolAssigned() throws Exception
    {
        return dao.deleteToolAssigned(idScene, idTool);
    }
    
    
    
    
}
