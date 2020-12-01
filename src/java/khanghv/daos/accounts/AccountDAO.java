/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.accounts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.AccountDTO;

/**
 *
 * @author USER
 */
public class AccountDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public AccountDAO() {
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

    public AccountDTO checkLogin(String username, String password) throws Exception {
        AccountDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Fullname, Rolee From Account Where Username = ? And Passwordd = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Rolee");
                dto = new AccountDTO(username, fullname, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public Vector<AccountDTO> searchByName(String name) throws Exception {
        AccountDTO dto = null;
        Vector<AccountDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Username, Fullname, Rolee, Descriptionn, Phone, Email, Imagee From Account Where Fullname Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                String role = rs.getString("Rolee").trim();
                String descr = rs.getString("Descriptionn").trim();
                String phone = rs.getString("Phone").trim();
                String email = rs.getString("Email").trim();
                String image = rs.getString("Imagee").trim();
                dto = new AccountDTO(username, fullname, role, image, descr, phone, email);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;

    }

    public boolean deleteByNameAssigned(String id) throws Exception {
        boolean status = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From SceneActorCart Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }

    public boolean deleteByName(String id) throws Exception {
        boolean status = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete From Account Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }

    public boolean createAccount(AccountDTO dto) throws Exception {
        boolean status = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert Into Account (Username, Passwordd, Rolee,Imagee,  Fullname, Descriptionn, Phone,Email) "
                    + "Values (?,?,?,?,?,?,?,?) ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getImg());
            preStm.setString(5, dto.getFullname());
            preStm.setString(6, dto.getDesc());
            preStm.setString(7, dto.getPhone());
            preStm.setString(8, dto.getEmail());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }

    public AccountDTO findInfo(String username) throws Exception {
        AccountDTO dto = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Fullname, Rolee, Descriptionn, Phone, Email, Imagee From Account Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname").trim();
                String role = rs.getString("Rolee").trim();
                String descr = rs.getString("Descriptionn").trim();
                String phone = rs.getString("Phone").trim();
                String email = rs.getString("Email").trim();
                String img = rs.getString("Imagee").trim();
                dto = new AccountDTO(username, fullname, role, img, descr, phone, email);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateInfo(AccountDTO dto) throws Exception {
        boolean status = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update Account Set Passwordd = ?, Fullname = ?, Rolee = ?, Imagee = ?,  Descriptionn =?, Phone = ?, Email = ? Where Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getImg());
            preStm.setString(5, dto.getDesc());
            preStm.setString(6, dto.getPhone());
            preStm.setString(7, dto.getEmail());
            preStm.setString(8, dto.getUsername());
            status = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return status;
    }

    public Vector<AccountDTO> getList() throws Exception {
        Vector<AccountDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select Username, Fullname From Account Where Rolee <> 'admin' And Rolee <> 'director'";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while (rs.next()) {
                String username = rs.getString("Username").trim();
                String fullname = rs.getString("Fullname").trim();
                AccountDTO dto = new AccountDTO(username, fullname);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

}
