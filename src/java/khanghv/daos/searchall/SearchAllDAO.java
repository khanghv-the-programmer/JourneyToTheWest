/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.searchall;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.LookUpDTO;

/**
 *
 * @author USER
 */
public class SearchAllDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public SearchAllDAO() {
    }

    public Vector<LookUpDTO> findAllByScene(String search) throws Exception {
        Vector<LookUpDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT S.idScene, S.sceneName, S.startTime, S.endTime, S.timeTake, A.Username, A.Fullname, A.Email,A.Phone, A.Imagee, A.Rolee, SA.Castt, T.toolName, T.quantity AS 'Available', ST.quantity, T.imagee From Account A, SceneActorCart SA, Scene S, SceneToolCart ST, Tools T Where A.Username = SA.Username AND SA.idScene = S.idScene And S.idScene = ST.idScene And ST.idTool = T.idTool And A.Rolee <> 'admin' AND S.sceneName LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String sid = rs.getString("idScene").trim();
                String sname = rs.getString("sceneName").trim();
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTime").trim();
                int takes = Integer.parseInt(rs.getString("timeTake").trim());
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String email = rs.getString("Email").trim();
                String phone = rs.getString("Phone").trim();
                String aimg = rs.getString("Imagee").trim();
                String role = rs.getString("Rolee").trim();
                String acting = rs.getString("Castt").trim();
                String tname = rs.getString("toolName").trim();
                int had = Integer.parseInt(rs.getString("Available").trim());
                int need = Integer.parseInt(rs.getString("quantity").trim());
                String timg = rs.getString("imagee").trim();
                LookUpDTO dto = new LookUpDTO(sid, sname, start, end, username, fullname, email, phone, aimg, role, tname, timg, takes, had, need, acting);
                list.add(dto);
            }
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    public Vector<LookUpDTO> findAllByName(String search) throws Exception {
        Vector<LookUpDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT S.idScene, S.sceneName, S.startTime, S.endTime, S.timeTake, A.Username, A.Fullname, A.Email,A.Phone, A.Imagee, A.Rolee, SA.Castt, T.toolName, T.quantity AS 'Available', ST.quantity, T.imagee From Account A, SceneActorCart SA, Scene S, SceneToolCart ST, Tools T Where A.Username = SA.Username AND SA.idScene = S.idScene And S.idScene = ST.idScene And ST.idTool = T.idTool And A.Rolee <> 'admin' AND A.Fullname LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String sid = rs.getString("idScene").trim();
                String sname = rs.getString("sceneName").trim();
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTime").trim();
                int takes = Integer.parseInt(rs.getString("timeTake").trim());
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String email = rs.getString("Email").trim();
                String phone = rs.getString("Phone").trim();
                String aimg = rs.getString("Imagee").trim();
                String role = rs.getString("Rolee").trim();
                String acting = rs.getString("Castt").trim();
                String tname = rs.getString("toolName").trim();
                int had = Integer.parseInt(rs.getString("Available").trim());
                int need = Integer.parseInt(rs.getString("quantity").trim());
                String timg = rs.getString("imagee").trim();
                LookUpDTO dto = new LookUpDTO(sid, sname, start, end, username, fullname, email, phone, aimg, role, tname, timg, takes, had, need, acting);
                list.add(dto);
            }
        } finally {
            CloseConnection();
        }
        return list;
    }
    
    public Vector<LookUpDTO> findAllByTool(String search) throws Exception {
        Vector<LookUpDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT S.idScene, S.sceneName, S.startTime, S.endTime, S.timeTake, A.Username, A.Fullname, A.Email,A.Phone, A.Imagee, A.Rolee, AC.Castt, T.toolName, T.quantity AS 'Available', ST.quantity, T.imagee From Account A, SceneActorCart SA, Scene S, SceneToolCart ST, Tools T Where A.Username = SA.Username AND SA.idScene = S.idScene And S.idScene = ST.idScene And ST.idTool = T.idTool And A.Rolee <> 'admin' AND T.toolName LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String sid = rs.getString("idScene").trim();
                String sname = rs.getString("sceneName").trim();
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTime").trim();
                int takes = Integer.parseInt(rs.getString("timeTake").trim());
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String email = rs.getString("Email").trim();
                String phone = rs.getString("Phone").trim();
                String aimg = rs.getString("Imagee").trim();
                String role = rs.getString("Rolee").trim();
                String acting = rs.getString("Castt").trim();
                String tname = rs.getString("toolName").trim();
                int had = Integer.parseInt(rs.getString("Available").trim());
                int need = Integer.parseInt(rs.getString("quantity").trim());
                String timg = rs.getString("imagee").trim();
                LookUpDTO dto = new LookUpDTO(sid, sname, start, end, username, fullname, email, phone, aimg, role, tname, timg, takes, had, need, acting);
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
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
