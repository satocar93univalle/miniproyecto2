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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import logica.Cubo;

/**
 *
 * @author Santiago
 */
public class VentanaInicio extends JFrame {
    private JPanel panel;
    private JTextArea lblComoJugar;
    private JLabel lblJugar;
    private JTextArea lblParaQueSirve;
    private JLabel lblCredito;
    private JLabel img1;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;
    private JLabel img6;
    private ArrayList<Cubo> cubos;
    
    public VentanaInicio() {
        cubos = new ArrayList<>();
        for (int i=0; i<6; i++) {
            cubos.add(new Cubo());
            System.out.println(cubos.get(i));
        }
        
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
        
        // como jugar
        lblComoJugar = new JTextArea("Cómo\nJugar");
        lblComoJugar.setBounds(67, 430, 93, 78);
        lblComoJugar.setFont(new Font("Arial", 1, 32));
        lblComoJugar.setForeground(Color.decode("#8ECAE6"));
        lblComoJugar.setOpaque(false);
        lblComoJugar.setEditable(false);
        panel.add(lblComoJugar);
        
        // Jugar
        lblJugar = new JLabel("Jugar");
        lblJugar.setBounds(254, 403, 271, 116);
        lblJugar.setFont(new Font("Arial", 1, 96));
        lblJugar.setForeground(Color.decode(("#8ECAE6")));
        panel.add(lblJugar);
        
        // para que sirve
        lblParaQueSirve = new JTextArea("Para\nqué sirve");
        lblParaQueSirve.setBounds(588, 430, 145, 78);
        lblParaQueSirve.setFont(new Font("Arial", 1, 32));
        lblParaQueSirve.setForeground(Color.decode("#8ECAE6"));
        lblParaQueSirve.setOpaque(false);
        lblParaQueSirve.setEditable(false);
        panel.add(lblParaQueSirve);
        
        // cuadros
        img1 = new JLabel();
        img1.setBounds(100, 245, 110, 110);
        img1.setIcon(new ImageIcon(cubos.get(0).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img1);
        img2 = new JLabel();
        img2.setBounds(222, 245, 110, 110);
        img2.setIcon(new ImageIcon(cubos.get(1).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img2);
        img3 = new JLabel();
        img3.setBounds(466, 245, 110, 110);
        img3.setIcon(new ImageIcon(cubos.get(2).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img3);
        img4 = new JLabel();
        img4.setBounds(588, 245, 110, 110);
        img4.setIcon(new ImageIcon(cubos.get(3).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img4);
        img5 = new JLabel();
        img5.setBounds(345, 62, 110, 110);
        img5.setIcon(new ImageIcon(cubos.get(4).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img5);
        img6 = new JLabel();
        img6.setBounds(345, 184, 110, 110);
        img6.setIcon(new ImageIcon(cubos.get(5).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        panel.add(img6);
        
        // Créditos
        lblCredito = new JLabel("Developed by Jhon Suescun & Santiago Torres. © 2022");
        lblCredito.setBounds(244, 537, 380, 15);
        lblCredito.setFont(new Font ("Arial", 0, 12));
        lblCredito.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblCredito);
        
        this.add(panel);
        
        // ------------- Eventos -------------
        lblComoJugar.addMouseListener(new ManejadorEventos());
        lblParaQueSirve.addMouseListener(new ManejadorEventos());
        lblJugar.addKeyListener(new ManejadorEventos());
        lblJugar.addMouseListener(new ManejadorEventos());
    }
    
    class ManejadorEventos implements KeyListener, MouseListener {
        // ---------------------- KeyListener ----------------------
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        // ---------------------- MouseListener ----------------------
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == lblComoJugar) {
                lblComoJugar.setForeground(Color.decode("#52FF00"));
            }
            if (e.getSource() == lblJugar) {
                lblJugar.setForeground(Color.decode("#52FF00"));
            }
            if (e.getSource() == lblParaQueSirve) {
                lblParaQueSirve.setForeground(Color.decode("#52FF00"));
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
            if (e.getSource() == lblComoJugar) {
                lblComoJugar.setForeground(Color.decode("#FFB703"));
                lblComoJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                System.out.println("evento");
            }
            if (e.getSource() == lblParaQueSirve) {
                lblParaQueSirve.setForeground(Color.decode("#FFB703"));
                lblParaQueSirve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                System.out.println("evento");
            }
            if (e.getSource() == lblJugar) {
                lblJugar.setForeground(Color.decode("#FFB703"));
                lblJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == lblComoJugar) {
                lblComoJugar.setForeground(Color.decode("#8ECAE6"));
            }
            if (e.getSource() == lblJugar) {
                lblJugar.setForeground(Color.decode("#8ECAE6"));
            }
            if (e.getSource() == lblParaQueSirve) {
                lblParaQueSirve.setForeground(Color.decode("#8ECAE6"));
            }
        }
    
    }
}
