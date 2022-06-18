/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago
 */
public class Cubo {
    private int borde;
    private Coordenada coordenada;
    private ImageIcon icono;
    
    // COnstructor
    public Cubo() {
        this.icono = new ImageIcon(imgRandom());
        this.borde = 0;
        this.coordenada = null;
    }
      
    // métodos
    
    // asigna numero random de imagen
    private String imgRandom() {
        Random random = new Random();
        int number = random.nextInt(12) + 1;
        return "src/imagenes/"+number+".png";
    }
    
    @Override
    public String toString() {
        return "{"+this.getCoordenada()+", borde:"+getColorBorde();
    }
    
    
    // Getters y Setters
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    
    public int getBorde() {
        return borde;
    }

    public void setBorde(int borde) {
        this.borde = borde;
    }
    
    public String getColorBorde() {
        String color = "";
        switch(this.borde) {
            case 0: color = "no"; break;
            case 1: color =  "azul"; break;
            case 2: color = "verde"; break;
            case 3: color = "rojo"; break;
            
        }
        return color;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(String img) {
        this.icono = new ImageIcon(getClass().getResource("/img/"+img+".png"));
    }
    
    public void setIcono() {
        this.icono = new ImageIcon(imgRandom());
    }
      
}
