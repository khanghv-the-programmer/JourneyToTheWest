/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.carts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.ASCartDTO;
import khanghv.dtos.SceneActorDTO;

/**
 *
 * @author USER
 */
public class ActorCartDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public ActorCartDAO() {
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

    public boolean addCartActor(ASCartDTO dto) throws Exception {
        boolean isSuccess = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert Into SceneActorCart (cAId, charDesc, editor, Username, idScene, Statuss, updateTime, Castt)"
                    + " Values (?, ? ,? , ? ,?, ?, ?, ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getDesc());
            preStm.setString(3, dto.getEditor());
            preStm.setString(4, dto.getUsername());
            preStm.setString(5, dto.getIdScene());
            preStm.setString(6, dto.getStatus());
            preStm.setString(7, dto.getTime());
            preStm.setString(8, dto.getActing());
            isSuccess = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return isSuccess;

    }

    public Vector<String> listIdAcCart() throws Exception {
        Vector<String> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select cAId From SceneActorCart";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String id = rs.getString("cAId").trim();
                list.add(id);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public Vector<ASCartDTO> listUsernameScene() throws Exception {
        Vector<ASCartDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Username, idScene From SceneActorCart";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String username = rs.getString("Username").trim();
                String idScene = rs.getString("idScene").trim();
                ASCartDTO dto = new ASCartDTO(idScene, username);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public Vector<SceneActorDTO> findByActor(String fullname) throws Exception {
        Vector<SceneActorDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select S.idScene, S.sceneName,A.Username, A.Fullname, S.location,SC.Castt, SC.charDesc, A.Rolee, A.Imagee, SC.updateTime From Scene S, SceneActorCart SC, Account A Where A.Fullname Like ? AND A.Username = SC.Username AND SC.idScene = S.idScene AND SC.Statuss = 'Accepted'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + fullname + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String idS = rs.getString("idScene").trim();
                String sName = rs.getString("sceneName").trim();
                String username = rs.getString("Username").trim();
                String fname = rs.getString("Fullname").trim();
                String loc = rs.getString("location").trim();
                String desc = rs.getString("charDesc").trim();
                String role = rs.getString("Rolee").trim();
                String img = rs.getString("Imagee").trim();
                String time = rs.getString("updateTime").trim();
                String acting = rs.getString("Castt").trim();
                SceneActorDTO dto = new SceneActorDTO(idS, sName, username, fname, loc, desc, role, img, time, acting);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public Vector<SceneActorDTO> findOfActor(String search) throws Exception {
        Vector<SceneActorDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select S.idScene, S.sceneName,S.timeTake ,A.Username, A.Fullname, S.location,SC.Castt, SC.charDesc, A.Rolee, A.Imagee, SC.updateTime, S.startTime, S.endTime From Scene S, SceneActorCart SC, Account A Where A.Fullname Like ? AND A.Username = SC.Username AND SC.idScene = S.idScene AND SC.Statuss = 'Accepted'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String idS = rs.getString("idScene").trim();
                String sName = rs.getString("sceneName").trim();
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String loc = rs.getString("location").trim();
                String desc = rs.getString("charDesc").trim();
                String role = rs.getString("Rolee").trim();
                String img = rs.getString("Imagee").trim();
                String time = rs.getString("updateTime").trim();
                String acting = rs.getString("Castt").trim();
                int takes = Integer.parseInt(rs.getString("timeTake").trim());
                String start = rs.getString("startTime").trim();
                String end = rs.getString("endTime").trim();
                SceneActorDTO dto = new SceneActorDTO(idS, sName, username, fullname, loc, desc, role, img, time, acting, takes, start, end);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public Vector<SceneActorDTO> findByScene(String search) throws Exception {
        Vector<SceneActorDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select S.idScene, S.sceneName,A.Username, A.Fullname, S.location,SC.Castt, SC.charDesc, A.Rolee, A.Imagee, SC.updateTime From Scene S, SceneActorCart SC, Account A Where S.sceneName Like ? AND A.Username = SC.Username AND SC.idScene = S.idScene AND SC.Statuss = 'Accepted'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String idS = rs.getString("idScene").trim();
                String sName = rs.getString("sceneName").trim();
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String loc = rs.getString("location").trim();
                String desc = rs.getString("charDesc").trim();
                String role = rs.getString("Rolee").trim();
                String img = rs.getString("Imagee").trim();
                String time = rs.getString("updateTime").trim();
                String acting = rs.getString("Castt").trim();
                SceneActorDTO dto = new SceneActorDTO(idS, sName, username, fullname, loc, desc, role, img, time, acting);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean deleteActorFromScene(String id, String us) throws Exception {
        boolean status = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From SceneActorCart Where idScene = ? And Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, us);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }
    
    public Vector<SceneActorDTO> findAll() throws Exception {
        Vector<SceneActorDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select S.idScene, S.sceneName,SC.Username, A.Fullname, S.location, SC.charDesc, A.Rolee From Scene S, SceneActorCart SC, Account A Where A.Username = SC.Username AND S.idScene = SC.idScene AND SC.Statuss = 'Accepted'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String idS = rs.getString("idScene").trim();
                String sName = rs.getString("sceneName").trim();
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String loc = rs.getString("location").trim();
                String desc = rs.getString("charDesc").trim();
                String role = rs.getString("Rolee").trim();
                SceneActorDTO dto = new SceneActorDTO(idS, sName, username, fullname, loc, desc, role);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

}
