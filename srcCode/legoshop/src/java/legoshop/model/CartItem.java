/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legoshop.model;

import legoshop.model.ProductDTO;
import java.io.Serializable;

public class CartItem extends ProductDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int quantity;

    public CartItem() {    
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
