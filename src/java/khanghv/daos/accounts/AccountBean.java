/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.accounts;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.AccountDTO;

/**
 *
 * @author USER
 */
public class AccountBean implements Serializable{
    private String username,password , fullname;
    AccountDAO dao;
    AccountDTO dto;
    public AccountBean() {
        dao= new AccountDAO();
        dto= new AccountDTO();
    }
    
    
    public AccountBean(String username, String password) {
        this.username = username;
        this.password = password;
        dao = new AccountDAO();
    }
    
    public AccountDTO checkLogin() throws Exception
    {   
        return dao.checkLogin(username, password);
    }
    public AccountDTO findInfo() throws Exception
    {
        return dao.findInfo(username);
    }
    public Vector<AccountDTO> searchByName() throws Exception
    {
        return dao.searchByName(fullname);
    }
    public boolean update(AccountDTO dto) throws Exception
    {
        return dao.updateInfo(dto);
    }
    public boolean add(AccountDTO dto) throws Exception
    {
        return dao.createAccount(dto);
    }
    public boolean deleteAssigned() throws Exception
    {
        return dao.deleteByNameAssigned(fullname);
    }
    public boolean delete () throws Exception
    {   
        
        return dao.deleteByName(fullname);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public Vector<AccountDTO> getList() throws Exception
    {
        return dao.getList();
    }
}
