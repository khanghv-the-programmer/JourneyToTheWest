/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.toolscene;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.ToolSceneDTO;

/**
 *
 * @author USER
 */
public class GetToolSceneDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public GetToolSceneDAO() {
    }

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean addToolScene(ToolSceneDTO dto) throws Exception
    {
        boolean status = false;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Insert Into SceneToolCart (cTId, quantity, editor, idTool, idScene, Statuss, updateTime ) Values (?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getcId());
            preStm.setString(2, Integer.toString(dto.getQuantity()));
            preStm.setString(3, dto.getEditor());
            preStm.setString(4, dto.getTid());
            preStm.setString(5, dto.getSid());
            preStm.setString(6, dto.getStatus());
            preStm.setString(7, dto.getTime());
            status = preStm.executeUpdate() > 0;
            
        }
        finally
        {
            closeConnection();
        }
        return status;
    }
    
    public Vector<String> getToolSceneId() throws Exception
    {   
        Vector<String> idList = null;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Select cTid From SceneToolCart";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            idList = new Vector<>();
            while(rs.next())
            {
                String id = rs.getString("cTid").trim();
                idList.add(id);
            }
        }
        finally
        {
            closeConnection();
        }
        return idList;
    }
    
    public Vector<ToolSceneDTO> getTwoIds() throws Exception
    {   
        Vector<ToolSceneDTO> list = null;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Select idTool, idScene From SceneToolCart";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String tid = rs.getString("idTool").trim();
                String sid = rs.getString("idScene").trim();
                ToolSceneDTO dto = new ToolSceneDTO(tid, sid);
                list.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return list;
    }
    
    public int getQuantity(String idTool, String idScene) throws Exception
    {
        int quantity = 0;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Select quantity From SceneToolCart Where idTool = ? And idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idTool);
            preStm.setString(2, idScene);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                quantity = Integer.parseInt(rs.getString("quantity"));
            }
        }
        finally
        {
            closeConnection();
        }
        return quantity;
    }
    
    public boolean updateQuantity(String idTool, String idScene, int quantity, String time) throws Exception
    {
        boolean isOk = false;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Update SceneToolCart Set quantity = ?, updateTime = ? Where idTool = ? And idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Integer.toString(quantity));
            preStm.setString(2, time);
            preStm.setString(3, idTool);
            preStm.setString(4, idScene);
            isOk = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return isOk;
    }
    
    public boolean deleteToolAssigned(String id, String toolid) throws Exception
    {
        boolean status = false;
        try{
            conn = MyConnection.getConnection();
            String sql = "Delete From SceneToolCart Where idScene = ? And idTool = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, toolid);
            status = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return status;
            
    }

}
