/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author saifalkayali
 */
public class Disc implements Serializable{
    
    private Color color  ;

    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public Color getColor() {
        return color;
    }

    public Disc(Color color) {
        this.color = color;
    }

    public Disc() {
        this.color = Color.BLACK;
    }
    public void flipDisc(){
  
       this.color= this.color == Color.BLACK ? Color.WHITE : Color.BLACK;
        
   
    }
}