/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.dtos;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ToolSceneDTO;

/**
 *
 * @author USER
 */
public class ToolSceneCart implements Serializable{
    Vector<ToolSceneDTO> cart;
    Vector<String> idList;
    public ToolSceneCart() {
        cart = new Vector<>();
        idList = new Vector<>();
    }
    public Vector<ToolSceneDTO> getCart()
    {
        return cart;
    }
    
    public String getLastId()
    {
        return cart.get(cart.size() - 1).getcId();
    }
    public ToolSceneDTO getCartNum(int i )
    {
        return cart.get(i);
    }
    
    public void deleteCartNum(int i)
    {
        cart.remove(i);
    }
    
    public void setQuantity(int i, int quantity)
    {
        cart.get(i).setQuantity(quantity);
    }
    
    public void addToCart(ToolSceneDTO dto)
    {
        cart.add(dto);
    }
    
    
    
}
