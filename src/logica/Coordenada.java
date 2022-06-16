/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Santiago
 */
public class Coordenada {
    private int x;
    private int y;
    private int width;
    private int height;
    private int id;
    
    // Dos constructores, el primero recibe solo coordenadas y id.
    // el segundo coordenadas, dimensiones y id.
    public Coordenada(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public Coordenada(int x, int y, int width, int height, int id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }
    
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Coordenada posicion "+this.getId();
    }
    
}
