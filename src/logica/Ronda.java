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
    private static int numeroDeRonda = 0;
    private static int puntuacion = 0;
    private static int vidas = 3;
    private static int aciertos = 0;
    private static int errores = 0;
    
    //constructor
    public Ronda() {
        
    }
    
    // metodos
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        Ronda.puntuacion = puntuacion;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        Ronda.vidas = vidas;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        Ronda.aciertos = aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        Ronda.errores = errores;
    }

    public static int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public static void setNumeroDeRonda(int numeroDeRonda) {
        Ronda.numeroDeRonda = numeroDeRonda;
    }
    
    
    
 
    public void reiniciarEstadisticas() {
        setPuntuacion(0);
        setVidas(3);
        setAciertos(0);
        setErrores(0);
    }
}
