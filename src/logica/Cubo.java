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
    private Coordenada coordenada;

    public Cubo() {
        this.img = imgRandom();
        this.borde = 0;
        this.coordenada = null;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
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
