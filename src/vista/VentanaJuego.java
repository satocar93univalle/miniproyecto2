/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Santiago
 */
public class VentanaJuego extends JFrame{
    private JPanel panel;
    private JLabel cubo1;
    private JLabel cubo2;
    private JLabel cubo3;
    private JLabel cubo4;
    private JLabel cubo5;
    private JLabel cubo6;
    private JLabel cubo7;
    private JLabel cubo8;
    
    public VentanaJuego() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        this.setVisible(true);
    }
    
    public void initComponents() {
        panel = new JPanel();
        panel.setLayout(null);
        
        cubo1 = new JLabel("Cubo 1", SwingConstants.CENTER);
        cubo1.setBounds(101, 245, 110, 110);
        cubo1.setOpaque(true);
        cubo1.setBackground(Color.MAGENTA);
        panel.add(cubo1);
        
        cubo2 = new JLabel("Cubo 2", SwingConstants.CENTER);
        cubo2.setBounds(223, 245, 110, 110);
        cubo2.setOpaque(true);
        cubo2.setBackground(Color.MAGENTA);
        panel.add(cubo2);
        
        cubo3 = new JLabel("Cubo 3", SwingConstants.CENTER);
        cubo3.setBounds(467, 245, 110, 110);
        cubo3.setOpaque(true);
        cubo3.setBackground(Color.MAGENTA);
        panel.add(cubo3);
        
        cubo4 = new JLabel("Cubo 4", SwingConstants.CENTER);
        cubo4.setBounds(589, 245, 110, 110);
        cubo4.setOpaque(true);
        cubo4.setBackground(Color.MAGENTA);
        panel.add(cubo4);
        
        cubo5 = new JLabel("Cubo 5", SwingConstants.CENTER);
        cubo5.setBounds(345, 62, 110, 110);
        cubo5.setOpaque(true);
        cubo5.setBackground(Color.MAGENTA);
        panel.add(cubo5);
        
        cubo6 = new JLabel("Cubo 6", SwingConstants.CENTER);
        cubo6.setBounds(345, 184, 110, 110);
        cubo6.setOpaque(true);
        cubo6.setBackground(Color.MAGENTA);
        panel.add(cubo6);
        
        cubo7 = new JLabel("Cubo 7", SwingConstants.CENTER);
        cubo7.setBounds(345, 306, 110, 110);
        cubo7.setOpaque(true);
        cubo7.setBackground(Color.MAGENTA);
        panel.add(cubo7);
        
        cubo8 = new JLabel("Cubo 8", SwingConstants.CENTER);
        cubo8.setBounds(345, 428, 110, 110);
        cubo8.setOpaque(true);
        cubo8.setBackground(Color.MAGENTA);
        panel.add(cubo8);
        
        this.add(panel);
    }
    
}
