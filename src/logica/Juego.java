/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Santiago
 */
public class Juego {
    private int dificultad;
    private Ronda ronda;
    ArrayList<Cubo> cubos;
    ArrayList<Coordenada> coordenadas;
    
    public Juego() {
        for (int i=0; i<3; i++) {
            cubos.add(new Cubo());
        }
        
        coordenadas.add(new Coordenada(101, 245, 110, 110, 1));
        coordenadas.add(new Coordenada(223, 245, 110, 110, 2));
        coordenadas.add(new Coordenada(467, 245, 110, 110, 3));
        coordenadas.add(new Coordenada(589, 245, 110, 110, 4));
        coordenadas.add(new Coordenada(345, 62, 110, 110, 5));
        coordenadas.add(new Coordenada(345, 184, 110, 110, 6));
        coordenadas.add(new Coordenada(345, 306, 110, 110, 7));
        coordenadas.add(new Coordenada(345, 428, 110, 110, 8));
    }
}