/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.w3c.dom.stylesheets.DocumentStyle;

/**
 *
 * @author Santiago
 */
public class VentanaParaQueSirve extends JFrame {
    private JPanel panel;
    private JLabel lblTitulo;
    private JTextPane lblTexto;
    private JLabel lblRegresar;
    
    public VentanaParaQueSirve() {
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
        lblTitulo = new JLabel("¿Para qué sirve?");
        lblTitulo.setBounds(132, 30, 526, 77);
        lblTitulo.setFont(new Font("Arial", 1, 64));
        lblTitulo.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblTitulo);
        
        // texto
        lblTexto = new JTextPane();
        lblTexto.setText("Este juego pone en acción la habilidad para "
                + "comparar patrones visuales, entrenando "
                + "además la atención a los detalles y la "
                + "velocidad perceptiva. Estas capacidades son "
                + "relevantes cuando hay que decidir entre "
                + "estímulos semejantes y hay que hacerlo de "
                + "forma rápida, por ejemplo, al reconocer "
                + "fotografías, caras, objetos cotidianos o "
                + "palabras escritas.");
        StyledDocument doc = lblTexto.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
        lblTexto.setParagraphAttributes(center, false);
        lblTexto.setBounds(53, 136, 695, 361);
        lblTexto.setFont(new Font("Arial", 0, 32));
        lblTexto.setForeground(Color.WHITE);
        lblTexto.setOpaque(false);
        lblTexto.setEditable(false);
        panel.add(lblTexto);
        
        // Regresar
        lblRegresar = new JLabel("Regresar");
        lblRegresar.setBounds(30, 505, 142, 39);
        lblRegresar.setFont(new Font("Arial", 1, 32));
        lblRegresar.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblRegresar);
        
        this.add(panel);
        
        // ------------- Eventos -------------
        lblRegresar.addMouseListener(new Manejador());
        lblRegresar.addKeyListener(new Manejador());
    }
    
    private class Manejador implements MouseListener, KeyListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#52FF00"));
                regresar();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Botón regresar vuelve a color original
            if (e.getSource() == lblRegresar) {
                lblRegresar.setForeground(Color.decode("#8ECAE6"));
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
    
    public void regresar() {
        VentanaInicio ventanaInicio = new VentanaInicio();
        this.dispose();
    }
}
