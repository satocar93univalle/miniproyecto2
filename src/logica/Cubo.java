/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author Santiago
 */
public class Cubo {
    private int numImg;
    private Border borde;
    private Coordenada coordenada;
    private ImageIcon icono;
    
    // COnstructor
    public Cubo() {
        this.icono = new ImageIcon(imgRandom());
    }
      
    // métodos
    
    // asigna numero random de imagen
    private String imgRandom() {
        Random random = new Random();
        int number = random.nextInt(12) + 1;
        numImg = number;
        return "src/imagenes/"+number+".png";
    }
    
    @Override
    public String toString() {
        return "{"+this.getCoordenada()+", borde:";
    }
    
    
    // Getters y Setters
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon img) {
        this.icono = img;
    }
    
    public void setIcono() {
        this.icono = new ImageIcon(imgRandom());
    }

    public Border getBorde() {
        return borde;
    }

    public void setBorde(Border borde) {
        this.borde = borde;
    }

    public int getNumImg() {
        return numImg;
    }

    public void setNumImg(int numImg) {
        this.numImg = numImg;
    }

}
