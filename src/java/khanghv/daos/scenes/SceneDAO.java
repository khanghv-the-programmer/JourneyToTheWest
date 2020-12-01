/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.scenes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.SceneDTO;

/**
 *
 * @author USER
 */
public class SceneDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public SceneDAO() {
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

    public Vector<SceneDTO> findByName(String name) throws Exception {
        Vector<SceneDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select idScene, sceneName, descriptionn, location, startTime, endTime, timeTake From Scene Where sceneName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            list = new Vector<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("idScene").trim();
                String sName = rs.getString("sceneName").trim();
                String desc = rs.getString("descriptionn").trim();
                String loc = rs.getString("location").trim();
                String st = rs.getString("startTime").trim();
                String et = rs.getString("endTime").trim();
                int take = Integer.parseInt(rs.getString("timeTake").trim());
                SceneDTO dto = new SceneDTO(id, sName, desc, loc, st, et, take);
                list.add(dto);

            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean deleteById(String id) throws Exception {
        boolean isSuccess = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From Scene Where idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            isSuccess = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return isSuccess;
    }

    public boolean deleteSceneFromActor(String id) throws Exception {
        boolean isOk = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "  Delete From SceneActorCart WHere idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            isOk = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return isOk;
    }
    
    public boolean deleteSceneFromTool(String id) throws Exception {
        boolean isOk = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "  Delete From SceneToolCart WHere idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            isOk = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return isOk;
    }

    public SceneDTO getInfo(String name) throws Exception {
        SceneDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select idScene, descriptionn, location, startTime, endTime, timeTake From Scene Where sceneName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String id = rs.getString("idScene").trim();
                String desc = rs.getString("descriptionn").trim();
                String loc = rs.getString("location").trim();
                String st = rs.getString("startTime").trim();
                String et = rs.getString("endTime").trim();
                int take = Integer.parseInt(rs.getString("timeTake").trim());
                dto = new SceneDTO(id, name, desc, loc, st, et, take);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateScene(SceneDTO dto) throws Exception {
        boolean isSuccess = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update Scene Set sceneName = ?, descriptionn = ?, location = ?, startTime = ?, endTime = ?, timeTake = ? Where idScene = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDesc());
            preStm.setString(3, dto.getLocation());
            preStm.setString(4, dto.getStart());
            preStm.setString(5, dto.getEnd());
            preStm.setString(6, Integer.toString(dto.getTake()));
            preStm.setString(7, dto.getId());
            isSuccess = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return isSuccess;
    }

    public boolean createScene(SceneDTO dto) throws Exception {
        boolean isSuccess = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert Into Scene (idScene, sceneName, descriptionn, location, startTime,endTime,timeTake)"
                    + "Values(  ?,  ?, ?, ?, ?, ?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDesc());
            preStm.setString(4, dto.getLocation());
            preStm.setString(5, dto.getStart());
            preStm.setString(6, dto.getEnd());
            preStm.setString(7, Integer.toString(dto.getTake()));

            isSuccess = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return isSuccess;
    }

    public Vector<String> getIdScene() throws Exception {
        Vector<String> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select idScene From Scene";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String id = rs.getString("idScene").trim();
                list.add(id);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public Vector<SceneDTO> getList() throws Exception {
        Vector<SceneDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select idScene, sceneName From Scene";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String id = rs.getString("idScene").trim();
                String name = rs.getString("sceneName").trim();
                SceneDTO dto = new SceneDTO(id, name);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

}
