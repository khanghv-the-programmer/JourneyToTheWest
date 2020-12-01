/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.tools;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import khanghv.db.MyConnection;
import khanghv.dtos.ToolDTO;

/**
 *
 * @author USER
 */
public class ToolDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public ToolDAO() {
    }

    public Vector<ToolDTO> findToolsByName(String name) throws Exception {
        Vector<ToolDTO> list = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select idTool, toolName, descriptionn, quantity, imagee, statuss From Tools Where toolName Like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + name + "%");
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String id = rs.getString("idTool").trim();
                String tName = rs.getString("toolName").trim();
                String desc = rs.getString("descriptionn").trim();
                int quantity = Integer.parseInt(rs.getString("quantity").trim());
                String img = rs.getString("imagee").trim();
                String status = rs.getString("statuss").trim();
                ToolDTO dto = new ToolDTO(id, tName, desc, img, status, quantity);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
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
    
    public boolean deleteTool(String id) throws Exception
    {
        boolean status = false;
        try{
            conn = MyConnection.getConnection();
            String sql = "Delete From Tools Where idTool = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return status;
            
    }
    
    public boolean deleteToolAssined(String id) throws Exception
    {
        boolean status = false;
        try{
            conn = MyConnection.getConnection();
            String sql = "Delete From SceneToolCart Where idTool = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            status = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return status;
            
    }
    
    public ToolDTO findToolById (String id) throws Exception
    {
        ToolDTO tool = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select toolName, descriptionn, quantity, imagee, statuss From Tools Where idTool = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {   
                String tId = id; 
                String name = rs.getString("toolName").trim();
                String desc = rs.getString("descriptionn").trim();
                int quantity = Integer.parseInt(rs.getString("quantity").trim());
                String img = rs.getString("imagee").trim();
                String stat = rs.getString("statuss").trim();
                tool = new ToolDTO(id, name, desc, img, stat, quantity);
                
            }
        }
        finally
        {
            closeConnection();
        }
        return tool;
        
    }
    
    public boolean updateTool(ToolDTO dto) throws Exception
    {
        boolean test = false;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Update Tools Set toolName = ?, descriptionn = ?, quantity = ?, imagee = ?, statuss = ? Where idTool = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDesc());
            preStm.setString(3, Integer.toString(dto.getQuantity()));
            preStm.setString(4, dto.getImage());
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getId());
            test = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return test;
    }
    
    Vector<String> getID() throws Exception
    {
        Vector<String> list = null;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Select idTool From Tools";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String id = rs.getString("idTool").trim();
                list.add(id);
            }
        }
        finally
        {
            closeConnection();
        }
        return list;
    }
    
    public boolean createTools(ToolDTO dto) throws Exception
    {   
        boolean check = false;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Insert Into Tools (idTool,toolName,descriptionn, quantity, statuss, imagee)"
                    + " VALUES(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDesc());
            preStm.setString(4, Integer.toString(dto.getQuantity()));
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getImage());      
            check = preStm.executeUpdate() > 0;
        }finally
        {
            closeConnection();
        }
        return  check;
    }
    
    
    public Vector<ToolDTO> getToolList() throws Exception
    {   
        Vector<ToolDTO> list = null;
        try
        {
            conn = MyConnection.getConnection();
            String sql = "Select idTool, toolName, quantity From Tools";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new Vector<>();
            while(rs.next())
            {
                String id = rs.getString("idTool").trim();
                String toolName = rs.getString("toolName").trim();
                int quantity = Integer.parseInt(rs.getString("quantity").trim());
                ToolDTO dto = new ToolDTO(id, toolName, quantity);
                list.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return list;
    }
}
