/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.border.Border;
import logica.Cubo;
import logica.Juego;

/**
 *
 * @author Santiago
 */
public class VentanaJuego extends JFrame{
    // declaracion componentes
    private JLabel lblPuntuacion;
    private JLabel lblVidas;
    private JLabel vida1;
    private JLabel vida2;
    private JLabel vida3;
    private JButton btnElegir;
    private JPanel panel;
    private ArrayList<JLabel> lblCubos;

    private ArrayList<Timer> timers;
    
    private Juego juego;
    
    public VentanaJuego() {
        
        juego = new Juego();
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        this.setVisible(true);
    }
    
    private void initComponents() {
        
        // panel
        panel = new JPanel();
        panel.setBackground(Color.decode("#023047"));
        panel.setLayout(null);
        
        
        // Puntuación
        lblPuntuacion = new JLabel("Puntuacion: "+ String.format(
                String.format("%%0%dd", 4),juego.getPuntuacion()));
        lblPuntuacion.setBounds(30, 30, 300, 39);
        lblPuntuacion.setFont(new Font("Arial", 1, 32));
        lblPuntuacion.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblPuntuacion);
        
        // Vidas
        vida1 = new JLabel();
        vida1.setBounds(612, 30, 40, 40);
        vida1.setOpaque(true);
        vida1.setBackground(Color.decode("#52FF00"));
        panel.add(vida1);
        
        vida2 = new JLabel();
        vida2.setBounds(671, 30, 40, 40);
        vida2.setOpaque(true);
        vida2.setBackground(Color.decode("#52FF00"));
        panel.add(vida2);
        
        vida3 = new JLabel();
        vida3.setBounds(730, 30, 40, 40);
        vida3.setOpaque(true);
        vida3.setBackground(Color.decode("#52FF00"));
        panel.add(vida3);
        
        lblVidas = new JLabel("Vidas");
        lblVidas.setBounds(702, 81, 68, 29);
        lblVidas.setFont(new Font("Arial", 1, 24));
        lblVidas.setForeground(Color.decode("#8ECAE6"));
        panel.add(lblVidas);
        
        // Botón elegir
        btnElegir = new JButton("Click Aqui");
        btnElegir.setBounds(660, 440, 100, 100);
        btnElegir.setBackground(Color.decode("#FFB703"));
        btnElegir.setFont(new Font("Arial", 1, 13));
        btnElegir.setForeground(Color.decode("#023047"));
        panel.add(btnElegir);
        
        
//      // creando y añadiendo al panel todos los labels
        lblCubos = new ArrayList<>();
        for(int i=0 ; i<8 ; i++){
            lblCubos.add(new JLabel());
            panel.add(lblCubos.get(i));
        }
        
        btnElegir.addKeyListener(new ManejadorEventos());
        btnElegir.addMouseListener(new ManejadorEventos());
        
        // creando el timer
        timers = new ArrayList<>();
        timers.add(new Timer());
        iniciarRonda();
        
        add(panel);
    }
    
    public void iniciarRonda(){
        juego.nuevaRonda();
        limpiearLabelCubos();
        renderImagen();
        reiniciarTiempo();
    }
    
    public void reiniciarTiempo(){
        timers.get(0).cancel();
        timers.remove(0);
        timers.add(new Timer());
        timers.get(0).schedule(new TimerTask(){
                @Override
                public void run() {
                    if(juego.isRondaAnteriorIguales()){
                        juego.perderRonda();
                        lblCubos.get(0).setIcon(null);
                        renderCubos();
                        pausarTiempoAntesDeNuevaRonda();
                    } else {
                        juego.cambiarImagenCuboAleatorio();
                        renderCubos();
                        
                        if(juego.imagenesIguales()){
                            juego.setRondaAnteriorIguales(true);
                        }
                    }
                }

            }, 1500, 1500);
    }
    
    public void pausarTiempoAntesDeNuevaRonda(){
        timers.get(0).cancel();
        timers.remove(0);
        timers.add(new Timer());
        timers.get(0).schedule(new TimerTask(){
                @Override
                public void run() {
                    iniciarRonda();
                }

            }, 2000, 1);
    }

    public void renderCubo(int index) {
        // le asigna la posicion del cubo al jlabel
        lblCubos.get(index).setBounds(
                juego.getCubos().get(index).getCoordenada().getX(),
                juego.getCubos().get(index).getCoordenada().getY(),
                110,
                110
        );
        
        // le asigna el borde del cubo al jlabel
        lblCubos.get(index).setBorder((Border) juego.getCubos().get(index).getBorde());
        
        // le asina el icono del cubo al jlabel
        lblCubos.get(index).setIcon(new ImageIcon(juego.getCubos().get(index).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
    }
    
    public void renderCubos() {
        
        for (int i=0; i<juego.getCubos().size(); i++) {
            renderCubo(i);
        }  
    }
    
    public void renderVidas(){
        int vidas = juego.getVidas();
        switch(vidas)
        {
            case 2 -> {
                vida1.setBackground(Color.RED);
            }
            case 1 ->{
                vida2.setBackground(Color.RED);
            }
            case 0 ->{
                vida3.setBackground(Color.RED);
            }
                
        }
        
    }
    
    public void renderImagen(){
        lblPuntuacion.setText(("Puntuacion: "+ String.format(
                String.format("%%0%dd", 4),juego.getPuntuacion())));
        
        renderVidas();
        
        renderCubos();
        
    }
    
    public void ComparacionBotonPresionado(){
        
        if(juego.imagenesIguales()){
            juego.ganarRonda();
        } 
        else{
            juego.perderRonda();
        }
        
        renderCubos();
        pausarTiempoAntesDeNuevaRonda();
    }
    
    public void limpiearLabelCubos(){
        for(int i=0 ; i<lblCubos.size() ; i++){
            lblCubos.get(i).setIcon(new ImageIcon(""));
            lblCubos.get(i).setBorder(null);
        }
    }
    
    
    private class ManejadorEventos implements KeyListener, MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        ComparacionBotonPresionado();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
        ComparacionBotonPresionado();
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
    
}
}// fin de la clase VentanaJuego


