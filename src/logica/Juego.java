/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author Santiago
 */
public class Juego {
    // variables de instancia del juego
    private int puntuacion;
    private int vidas;
    private int aciertos;
    private int errores;
    private int dificultad;
    private boolean rondaGanada;
    ArrayList<Cubo> cubos;
    ArrayList<Coordenada> coordenadas;
    ArrayList<ImageIcon> imagenes;
    
    // Constructor
    
    public Juego() {
        puntuacion = 0;
        vidas = 3;
        aciertos = 0;
        errores = 0;
        dificultad = 2000;
        rondaGanada = false;
        cubos = new ArrayList<>();
        coordenadas = new ArrayList<>();
        imagenes = new ArrayList<>();
        
        // inicializando los tres primeros cubos
        for (int i=0; i<3; i++) {
            cubos.add(new Cubo());
        }
    }
    
    // Métodos
    public void nuevaRonda() {
        if(rondaGanada && cubos.size() < 8)
            agregarCubo();
        
        if(!rondaGanada && cubos.size() > 3)
            eliminarCubo();

        cambiarBordeTodosCubos(null);
        initCoordenadas();
        initImagenes();
        asignarPosicionCubo();
        asignarImagenCubo();
        
    }
    
    public void initCoordenadas() {
        coordenadas.add(new Coordenada(101, 245, 110, 110, 1));
        coordenadas.add(new Coordenada(223, 245, 110, 110, 2));
        coordenadas.add(new Coordenada(467, 245, 110, 110, 3));
        coordenadas.add(new Coordenada(589, 245, 110, 110, 4));
        coordenadas.add(new Coordenada(345, 62, 110, 110, 5));
        coordenadas.add(new Coordenada(345, 184, 110, 110, 6));
        coordenadas.add(new Coordenada(345, 306, 110, 110, 7));
        coordenadas.add(new Coordenada(345, 428, 110, 110, 8));
    }
    
    public void initImagenes(){
        for(int i=1; i<=12; i++){
            imagenes.add(new ImageIcon("src/imagenes/"+i+".png"));
        }
    }
    
    public void asignarPosicionCubo() {
        // array para almacenar 8 numeros que representan los índices de arr coordenadas
        ArrayList<Integer> asignador = new ArrayList<>();
        for (int i=0; i<8; i++) {
            asignador.add(i);
        }
        // alternar posiciones de asignador.
        Collections.shuffle(asignador);
        
        // asignar coordenadas a los cubos de manera alternada sin repetir coords.
        for (int i=0; i<cubos.size(); i++) {
            cubos.get(i).setCoordenada(coordenadas.get(asignador.get(i)));
        }
        
    }
    
    public void asignarImagenCubo(){
        // array para almacenar 8 numeros que representan los índices de arr coordenadas
        ArrayList<Integer> asignador = new ArrayList<>();
        for (int i=0; i<12; i++) {
            asignador.add(i);
        }
        // alternar posiciones de asignador.
        Collections.shuffle(asignador);
        
        // asignar coordenadas a los cubos de manera alternada sin repetir coords.
        for (int i=0; i<cubos.size(); i++) {
            cubos.get(i).setIcono(imagenes.get(asignador.get(i)));
        }
    }
    
    public void agregarCubo(){
        cubos.add(new Cubo());
    }
    
    public void eliminarCubo(){
        cubos.remove(cubos.size()-1);
    }
    
    public void cambiarImagenCuboAleatorio(){
        // cambia el icono del cubo
        Random random = new Random();
        int posicion = random.nextInt(cubos.size());
        cubos.get(posicion).setIcono();
        
        // cambia el color de todos los bordes a null
        cambiarBordeTodosCubos(null);
        
        // cambia el borde del cubo
        cubos.get(posicion).setBorde(BorderFactory.
                createLineBorder(Color.CYAN, 4, true));
    }
    
    public void cambiarBordeTodosCubos(Border borde){
        for(int i=0 ; i<cubos.size() ; i++){
            cubos.get(i).setBorde(borde);
        }
    }
    
    public void ganarRonda(){
        puntuacion += 5;
        aciertos++;
        cambiarBordeTodosCubos( BorderFactory.
                createLineBorder(Color.GREEN, 4, true));
        rondaGanada = true;
    }
    
    public void perderRonda(){
        errores--;
        vidas--;
        cambiarBordeTodosCubos(BorderFactory.
                createLineBorder(Color.RED, 4, true));
        rondaGanada = false;
    }
    
    public boolean imagenesIguales(){
        boolean aux = false;
        
        for(int i=0; i<cubos.size() ; i++)
        {
            for(int j=i+1; j<cubos.size(); j++)
            {
                if (cubos.get(i).getNumImg() == cubos.get(j).getNumImg()) {
                    aux = true;
                    break;
                } 
            }
        }
        return aux;
    }
    
    // Getters y Setters
    
    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

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

    public ArrayList<Cubo> getCubos() {
        return cubos;
    }

    public void setCubos(ArrayList<Cubo> cubos) {
        this.cubos = cubos;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean isRondaGanada() {
        return rondaGanada;
    }

    public void setRondaGanada(boolean rondaGanada) {
        this.rondaGanada = rondaGanada;
    }
    
}   