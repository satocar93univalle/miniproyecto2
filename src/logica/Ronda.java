/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Santiago
 */
public class Ronda 
{
    // atributos
    private int puntuacion;
    private int vidas;
    private int aciertos;
    private int errores;
    
    //constructor
    public Ronda() {
        this.puntuacion = 0;
        this.vidas = 3;
        this.aciertos = 0;
        this.errores = 0;
        
    }
    
    // metodos
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
    
    public void reiniciarRonda() {
        setPuntuacion(0);
        setVidas(3);
        setAciertos(0);
        setErrores(0);
    }
}
