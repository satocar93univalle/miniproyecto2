/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Santiago
 */
public class Instrucciones {
    private ArrayList<ImageIcon> imagenes = new ArrayList<>();
    private int numeroInstruccion;
    private String indiceInstruccion;
    private ImageIcon iconoActual;
    private String instruccion;

    public Instrucciones() {
        for (int i=0; i<4; i++) {
            imagenes.add(new ImageIcon("src/imagenes/instruccion"+(i+1)+".png"));
        }
        numeroInstruccion = 0;
        indiceInstruccion = "";
        instruccion = "";
        
    }
    
    public void gestionarInstruccion() {
        switch(numeroInstruccion) {
            case 0 : instruccion = "En el juego aparecen en pantalla una serie de cuadros con\n"
                    + "imágenes. Estos cuadros van cambiando de 1 en 1\n"
                    + "mostrando distintos diseños.\n"
                    + "Podrás saber qué cuadro cambia en cada momento gracias a\n"
                    + "un reborde de color azul.";
                    indiceInstruccion = "1/4";
                    iconoActual = imagenes.get(0);
                    break;
            case 1 : instruccion = "En el momento en el que veas en pantalla dos cuadros\n"
                    + "idénticos, debes presionar rápidamente el botón naranja que\n"
                    + "aparece en la zona inferior derecha.";
                    indiceInstruccion = "2/4";
                    iconoActual = imagenes.get(1);
                    break;
            case 2 : instruccion = "Hay dos formas de presionar el pulsador:\n"
                    + "- Pulsar directamente el botón naranja en la pantalla.\n"
                    + "- Pulsar la barra de espacio del teclado.";
                    indiceInstruccion = "3/4";
                    iconoActual = imagenes.get(2);
                    break;
            case 3 : instruccion = "¡OJO! Si no pulsas a tiempo perderás vidas. A medida que el\n"
                    + "juego avanza, el ritmo al que cambian los cuadros es mayor y\n"
                    + "tu tiempo de reacción es menor.\n\n"
                    + "¡Buena suerte!";
                    indiceInstruccion = "4/4";
                    iconoActual = imagenes.get(3);
                    break;
        }
    }

    public ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ImageIcon> imagenes) {
        this.imagenes = imagenes;
    }

    public int getNumeroInstruccion() {
        return numeroInstruccion;
    }

    public void setNumeroInstruccion(int numeroInstruccion) {
        this.numeroInstruccion = numeroInstruccion;
    }

    public String getIndiceInstruccion() {
        return indiceInstruccion;
    }

    public void setIndiceInstruccion(String indiceInstruccion) {
        this.indiceInstruccion = indiceInstruccion;
    }

    public ImageIcon getIconoActual() {
        return iconoActual;
    }

    public void setIconoActual(ImageIcon iconoActual) {
        this.iconoActual = iconoActual;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }
    
    @Override
    public String toString() {
        return "Instruccion: "+instruccion+"\n"
                + "Indice de Instrucciones: "+indiceInstruccion+"\n"
                + "Icono actual: "+iconoActual;
    }
}
