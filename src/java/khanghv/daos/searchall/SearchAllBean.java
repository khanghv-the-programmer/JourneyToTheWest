/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.searchall;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.LookUpDTO;

/**
 *
 * @author USER
 */
public class SearchAllBean implements Serializable{
    String search;
    SearchAllDAO dao;
    LookUpDTO dto;
    public SearchAllBean() {
        dao = new SearchAllDAO();
        dto = new LookUpDTO();
    }
    
    public Vector<LookUpDTO> searchByScene() throws Exception
    {
        return dao.findAllByScene(search);
    }
    
    public Vector<LookUpDTO> searchByName() throws Exception
    {
        return dao.findAllByName(search);
    }
    
    public Vector<LookUpDTO> searchByTool() throws Exception
    {
        return dao.findAllByTool(search);
    }
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SearchAllDAO getDao() {
        return dao;
    }

    public void setDao(SearchAllDAO dao) {
        this.dao = dao;
    }

    public LookUpDTO getDto() {
        return dto;
    }

    public void setDto(LookUpDTO dto) {
        this.dto = dto;
    }
    
    
}
