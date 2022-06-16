/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Santiago
 */
public class Juego {
    // variables de estadisticas de juego
    private int puntuacion = 0;
    private int vidas = 3;
    private int aciertos = 0;
    private int errores = 0;
    private int numeroDeRonda;
    
    // variables de logica de juego
    private int dificultad;
    ArrayList<Cubo> cubos;
    ArrayList<Coordenada> coordenadas;
    
    // Constructor
    
    public Juego() {
        numeroDeRonda = 0;
        cubos = new ArrayList<>();
        coordenadas = new ArrayList<>();
        // inicializando los tres primeros cubos
        for (int i=0; i<3; i++) {
            cubos.add(new Cubo());
        }
        // inicializando coordenadas
        initCoordenadas();
        
        asignarPosicionCubo();
        
        // verificando por consola que no se repinen las posiciones asignadas a cada cubo
        // esto para evitar que se superponga uno sobre otro en la ventana de juego
        for (int i=0; i<cubos.size(); i++) {
            System.out.println(cubos.get(i));
        }
        
    }
    
    // Métodos
    
    public void jugarRonda() {
        asignarPosicionCubo();
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
    
    public void asignarPosicionCubo() {
        
        ArrayList<Integer> asignador = new ArrayList<>();
        for (int i=0; i<8; i++) {
            asignador.add(i);
        }
        System.out.println("asignador original: "+asignador);
        Collections.shuffle(asignador);
        System.out.println("asignador alternado: "+asignador);
        
        for (int i=0; i<cubos.size(); i++) {
            cubos.get(i).setCoordenada(coordenadas.get(asignador.get(i)));
        }
        
    }
    
    
    
    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }
    
    
}   