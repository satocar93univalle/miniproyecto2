/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.Juego;

/**
 *
 * @author Santiago
 */
public class VentanaEstadisticas extends JFrame {
    private Juego juego;
    private JPanel panel;
    private JLabel lblFin;
    private JLabel lblAciertos;
    private JLabel lblErrores;
    private JLabel lblPuntaje;
    private JLabel lblRegresar;
    private JLabel lblJugarDeNuevo;
    
    public VentanaEstadisticas(Juego juego) {
        this.juego = juego;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
        
    }
    
    public void initComponents() {
        // panel
        panel = new JPanel();
        panel.setBackground(Color.decode("#023047"));
        panel.setLayout(null);
        
        // Tiítulo ventana
        lblFin = new JLabel("Fin del Juego");
        lblFin.setBounds(89, 30, 623, 116);
        lblFin.setFont(new Font("Arial", 1, 96));
        lblFin.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblFin);
        
        // Aciertos
        lblAciertos = new JLabel("<html>Aciertos: <b>"+juego.getAciertos()+"</b></html>");
        lblAciertos.setBounds(285, 265, 194, 39);
        lblAciertos.setFont(new Font("Arial", 0, 32));
        lblAciertos.setForeground(Color.WHITE);
        panel.add(lblAciertos);
        
        // Errores
        lblErrores = new JLabel("<html>Errores: <b>"+juego.getErrores()+"</b></html>");
        lblErrores.setBounds(299, 310, 180, 39);
        lblErrores.setFont(new Font("Arial", 0, 32));
        lblErrores.setForeground(Color.WHITE);
        panel.add(lblErrores);
        
        // Puntej
        lblPuntaje = new JLabel("<html>Puntaje: <b>"+juego.getPuntuacion()+"</b></html>");
        lblPuntaje.setBounds(295, 355, 226, 39);
        lblPuntaje.setFont(new Font("Arial", 0, 32));
        lblPuntaje.setForeground(Color.WHITE);
        panel.add(lblPuntaje);
        
        // Regresar
        lblRegresar = new JLabel("Regresar");
        lblRegresar.setBounds(30, 505, 142, 39);
        lblRegresar.setFont(new Font("Arial", 1, 32));
        lblRegresar.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblRegresar);
        
        // Jugar de nuevo
        lblJugarDeNuevo = new JLabel("Jugar de nuevo");
        lblJugarDeNuevo.setBounds(529, 505, 241, 39);
        lblJugarDeNuevo.setFont(new Font("Arial", 1, 32));
        lblJugarDeNuevo.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblJugarDeNuevo);
        
        this.add(panel);
        
        // ------------- Eventos -------------
        lblRegresar.addMouseListener(new Manejador());
        lblJugarDeNuevo.addMouseListener(new Manejador());
    }
    
    private class Manejador implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#52FF00"));
                regresar();
            }
            
            if (e.getSource() == lblJugarDeNuevo) {
                lblJugarDeNuevo.setForeground(Color.decode("#52FF00"));
                jugar();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Botón regresar cambia color
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#FFB703"));
                lblRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            // Botón jugar de nuevo cambia color
            if (e.getSource() == lblJugarDeNuevo) {
                lblJugarDeNuevo.setForeground(Color.decode("#FFB703"));
                lblJugarDeNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Botón regresar vuelve a color original
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#8ECAE6"));
            }
            // Botón jugar de nuevo vuelve a color original
            if (e.getSource() == lblJugarDeNuevo) {
                lblJugarDeNuevo.setForeground(Color.decode("#8ECAE6"));
            }
        }
        
    }
    
    public void regresar() {
        VentanaInicio ventanaInicio = new VentanaInicio();
        this.dispose();
    }
    
    public void jugar() {
        VentanaJuego ventanaJuego = new VentanaJuego();
        this.dispose();
    }
    
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    
}
