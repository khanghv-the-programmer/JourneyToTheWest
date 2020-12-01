/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.daos.carts;

import java.io.Serializable;
import java.util.Vector;
import khanghv.dtos.ASCartDTO;

/**
 *
 * @author USER
 */
public class ActorCrart implements Serializable{
    Vector<ASCartDTO> cart;

    public ActorCrart() {
        cart = new Vector<>();
    }
    
    public void addtoCart(ASCartDTO dto)
    {
        cart.add(dto);
    }

    public Vector<ASCartDTO> getCart() {
        return cart;
    }

    public void setCart(Vector<ASCartDTO> cart) {
        this.cart = cart;
    }
    
    
}
