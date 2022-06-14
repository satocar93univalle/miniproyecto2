/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Random;

/**
 *
 * @author Santiago
 */
public class Cubo {
    private String img;
    private int borde;

    public Cubo() {
        this.img = imgRandom();
        this.borde = 0;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getBorde() {
        return borde;
    }

    public void setBorde(int borde) {
        this.borde = borde;
    }
    
    public String imgRandom() {
        Random random = new Random();
        int number = random.nextInt(12) + 1;
        return number+"";
    }
    
    
}
