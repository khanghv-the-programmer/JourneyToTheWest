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
import khanghv.dtos.ToolSceneSearchDTO;

/**
 *
 * @author USER
 */
public class ToolSceneSearchDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public ToolSceneSearchDAO() {
    }

    public Vector<ToolSceneSearchDTO> searchByTool(String search) throws Exception {
        Vector<ToolSceneSearchDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select SC.cTId, S.idScene, S.sceneName, SC.quantity as 'quantityNeed', T.idTool, T.toolName, T.quantity, S.startTime, S.endTime, SC.updateTime From SceneToolCart SC, Scene S, Tools T Where SC.idScene = S.idScene And SC.idTool = T.idTool And SC.Statuss = 'Accepted' And T.toolName LIKE ?";
            preStm =conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String cid = rs.getString("cTId").trim();
                String sid = rs.getString("idScene").trim();
                String sname = rs.getString("sceneName").trim();
                int quantityneed = Integer.parseInt(rs.getString("quantityNeed").trim());
                String tid = rs.getString("idTool").trim();
                String tname = rs.getString("toolName").trim();
                int quantityhad = Integer.parseInt(rs.getString("quantity").trim());
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTIme").trim();
                String time = rs.getString("updateTime").trim();
                ToolSceneSearchDTO dto = new ToolSceneSearchDTO(cid, sid, sname, tid, tname, start, end, quantityhad, quantityneed, time);
                list.add(dto);
                
            }
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    public Vector<ToolSceneSearchDTO> searchByScene(String search) throws Exception {
        Vector<ToolSceneSearchDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select SC.cTId, S.idScene, S.sceneName, SC.quantity as 'quantityNeed', T.idTool, T.toolName, T.quantity, S.startTime, S.endTime, SC.updateTime From SceneToolCart SC, Scene S, Tools T Where SC.idScene = S.idScene And SC.idTool = T.idTool And SC.Statuss = 'Accepted' And S.sceneName LIKE ?";
            preStm =conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String cid = rs.getString("cTId").trim();
                String sid = rs.getString("idScene").trim();
                String sname = rs.getString("sceneName").trim();
                int quantityneed = Integer.parseInt(rs.getString("quantityNeed").trim());
                String tid = rs.getString("idTool").trim();
                String tname = rs.getString("toolName").trim();
                int quantityhad = Integer.parseInt(rs.getString("quantity").trim());
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTIme").trim();
                String time = rs.getString("updateTime").trim();
                ToolSceneSearchDTO dto = new ToolSceneSearchDTO(cid, sid, sname, tid, tname, start, end, quantityhad, quantityneed, time);
                list.add(dto);
                
            }
        } finally {
            CloseConnection();
        }
        return list;
    }

    public void CloseConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                preStm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
