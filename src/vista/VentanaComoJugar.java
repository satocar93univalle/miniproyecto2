/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import logica.Instrucciones;

/**
 *
 * @author Santiago
 */
public class VentanaComoJugar extends JFrame {
    
    private Instrucciones instruccion;
    
    private JPanel panel;
    private JLabel lblTitulo;
    private JLabel lblIndiceInstruccion;
    private JLabel lblImagenInstruccion;
    private JLabel lblFlechaDer;
    private JLabel lblFlechaIzq;
    private JTextArea lblInstruccion;
    private JLabel lblRegresar;
    private ImageIcon flechaIzq = new ImageIcon("src/imagenes/flechaIzq.png");
    private ImageIcon flechaDer = new ImageIcon("src/imagenes/flechaDer.png");
    
    
    public VentanaComoJugar() {
        instruccion = new Instrucciones();
        instruccion.gestionarInstruccion();
        
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
        lblTitulo = new JLabel("¿Cómo Jugar?");
        lblTitulo.setBounds(30, 30, 224, 39);
        lblTitulo.setFont(new Font("Arial", 1, 32));
        lblTitulo.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblTitulo);
        
        // Indice Instrucciones
        lblIndiceInstruccion = new JLabel(instruccion.getIndiceInstruccion());
        lblIndiceInstruccion.setBounds(714, 30, 56, 39);
        lblIndiceInstruccion.setFont(new Font("Arial", 1, 32));
        lblIndiceInstruccion.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblIndiceInstruccion);
        
        // Imagen
        lblImagenInstruccion = new JLabel();
        lblImagenInstruccion.setBounds(258, 106, 283, 202);
        lblImagenInstruccion.setIcon(new ImageIcon(instruccion.getIconoActual().getImage().getScaledInstance(283, 202, Image.SCALE_SMOOTH)));
        lblImagenInstruccion.setBorder(BorderFactory.createLineBorder(Color.decode("#FFB703"), 3, true));
        panel.add(lblImagenInstruccion);
        
        // Flecha Izquierda
        lblFlechaIzq = new JLabel();
        lblFlechaIzq.setBounds(30, 207, 64, 64);
        lblFlechaIzq.setIcon(new ImageIcon(flechaIzq.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        lblFlechaIzq.setVisible(false);
        panel.add(lblFlechaIzq);
        
        // Flecha derecha
        lblFlechaDer = new JLabel();
        lblFlechaDer.setBounds(690, 207, 64, 64);
        lblFlechaDer.setIcon(new ImageIcon(flechaDer.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        panel.add(lblFlechaDer);
        
        // Texto de instrucciones
        lblInstruccion = new JTextArea(instruccion.getInstruccion());
        lblInstruccion.setBounds(52, 330, 695, 145);
        lblInstruccion.setFont(new Font("Arial", 0, 24));
        lblInstruccion.setForeground(Color.WHITE);
        lblInstruccion.setOpaque(false);
        lblInstruccion.setEnabled(false);
        panel.add(lblInstruccion);
        
        // Regresar
        lblRegresar = new JLabel("Regresar");
        lblRegresar.setBounds(30, 505, 142, 39);
        lblRegresar.setFont(new Font("Arial", 1, 32));
        lblRegresar.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblRegresar);
        
        this.add(panel);
        
        // ------------- Eventos -------------
        lblFlechaIzq.addKeyListener(new ManejadorEventos());
        lblFlechaIzq.addMouseListener(new ManejadorEventos());
        
        lblFlechaDer.addKeyListener(new ManejadorEventos());
        lblFlechaDer.addMouseListener(new ManejadorEventos());
        
        lblRegresar.addMouseListener(new ManejadorEventos());
        
        
        
    }
    
    private class ManejadorEventos implements KeyListener, MouseListener {
        // ---------------------- KeyListener ----------------------
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 27) {
                // PENDIENTE: escribir código en funcion regresar();
                regresar();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
        // ---------------------- MouseListener ----------------------
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#52FF00"));
                // PENDIENTE: escribir código en funcion regresar();
                regresar();
            }
            
            // evento para flechas
            if (e.getSource() == lblFlechaDer) {
                manejoFlechaDer();
            }
            if (e.getSource() == lblFlechaIzq) {
                manejoFlechaIzq();
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
            // Flechas izquierda y derecha cambian cursor y se muestra borde
            if (e.getSource() == lblFlechaDer) {
                lblFlechaDer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lblFlechaDer.setBorder(BorderFactory.createLineBorder(Color.decode("#8ECAE6"), 1, true));
            }    
            if (e.getSource() == lblFlechaIzq) {
                lblFlechaIzq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lblFlechaIzq.setBorder(BorderFactory.createLineBorder(Color.decode("#8ECAE6"), 1, true));
            }

            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Botón regresar vuelve a color original
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#8ECAE6"));
            }
            // Flechas izquierda y derecha dejan de tener borde
            if (e.getSource() == lblFlechaDer) {
                lblFlechaDer.setBorder(null);
            }
            if (e.getSource() == lblFlechaIzq) {
                lblFlechaIzq.setBorder(null);
            }
            
        }
        
        
    }
    public void regresar() {
            VentanaInicio ventanaInicio = new VentanaInicio();
            this.dispose();
        }
        
        public void refrescar() {
            lblIndiceInstruccion.setText(instruccion.getIndiceInstruccion());
            lblImagenInstruccion.setIcon(new ImageIcon(instruccion.getIconoActual().getImage().getScaledInstance(283, 202, Image.SCALE_SMOOTH)));
            lblInstruccion.setText(instruccion.getInstruccion());
        }
        
        public void manejoFlechaDer() {
            
            lblFlechaIzq.setVisible(true);
            
            if (instruccion.getNumeroInstruccion() < 3) {
                
                if(instruccion.getNumeroInstruccion() >= 2) {
                    lblFlechaDer.setVisible(false);
                }
                
                instruccion.setNumeroInstruccion(instruccion.getNumeroInstruccion()+1);
                instruccion.gestionarInstruccion();
            }
            refrescar();
            System.out.println("Numero de instrucción: "+instruccion.getNumeroInstruccion());
            
        }
        
        public void manejoFlechaIzq() {
            
            lblFlechaDer.setVisible(true);
            if (instruccion.getNumeroInstruccion() > 0) {
                
                instruccion.setNumeroInstruccion(instruccion.getNumeroInstruccion()-1);
                instruccion.gestionarInstruccion();
                
                if (instruccion.getNumeroInstruccion() < 1) {
                    lblFlechaIzq.setVisible(false);
                }
            } 
            
            refrescar();
            System.out.println("Numero de instrucción: "+instruccion.getNumeroInstruccion());
        }
}
