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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
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

    private Timer t;
    
    // inicializando iconos (imagenes)
    final ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/1.png"));
    
    private Juego juego;
    
    public VentanaJuego() {
        
        juego = new Juego();
        
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        this.setVisible(true);
    }
    
    public void initComponents() {
        
        // panel
        panel = new JPanel();
        panel.setBackground(Color.decode("#023047"));
        panel.setLayout(null);
        
        
        // Puntuación
        lblPuntuacion = new JLabel("Puntuacion 0000");
        lblPuntuacion.setBounds(30, 30, 255, 39);
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
        
        
        lblCubos = new ArrayList<>();
        renderCubos(juego.getCubos());
        
        this.add(panel);
        
        // eventos
        btnElegir.addMouseListener(new ManejadorEventos());
        btnElegir.addKeyListener(new ManejadorEventos());
        
        // configuración del timer
        t = new Timer(juego.getDificultad(), new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setMomentoCorrecto(false);
                cambiarImagenCubo();
                verificarIgualdad();
                
                if (juego.isClickCorrecto()== true) {
                    
                    // AQUÍ VA CÓDIGO PARA AUMENTAR UN CUBO
                    
                    juego.setClickCorrecto(false);
                }
            }
            
        });
        
        // iniciar tiempo
        t.start();
    }
    
    public JLabel renderCubo(JLabel cubo, int index) {
        cubo = new JLabel();
        cubo.setBounds(
                juego.getCubos().get(index).getCoordenada().getX(),
                juego.getCubos().get(index).getCoordenada().getY(),
                110,
                110
        );
        cubo.setIcon(new ImageIcon(juego.getCubos().get(index).getIcono().getImage().getScaledInstance(cubo.getWidth(), cubo.getHeight(), Image.SCALE_SMOOTH)));
        
        
        System.out.println(juego.getCubos().get(index).getCoordenada());
        System.out.println(juego.getCubos().get(index).getIcono());
        
        return cubo;
        
    }
    
    public void renderCubos(ArrayList<Cubo> cubos) {
        
        for (int i=0; i<juego.getCubos().size(); i++) {
            lblCubos.add(renderCubo(new JLabel(), i));
            panel.add(lblCubos.get(i));
        }
    }
    
    public void cambiarImagenCubo()
    {
        Random random = new Random();
        int cuboCambiar = random.nextInt(juego.getCubos().size());
        juego.getCubos().get(cuboCambiar).setIcono();
        lblCubos.get(cuboCambiar).setIcon(new ImageIcon(juego.getCubos().get(cuboCambiar).getIcono().getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        System.out.println("paso el tiempo");
        refrescarCubos();
        // cambio color borde
        juego.getCubos().get(cuboCambiar).setBorde(1);
        lblCubos.get(cuboCambiar).setBorder(BorderFactory.createLineBorder(Color.CYAN, 4, true));
        
        
    }
    
    public void refrescarCubos() {
        for (int i=0; i<lblCubos.size(); i++) {
            juego.getCubos().get(i).setBorde(0);
            lblCubos.get(i).setBorder(null);
        }
    }
    
    public boolean verificarIgualdad()
    {
        boolean aux = false;
        
        for(int i=0; i<juego.getCubos().size()-1 ; i++)
        {
            for(int j=i+1; j<juego.getCubos().size(); j++)
            {
                if (juego.getCubos().get(i).getImg() == juego.getCubos().get(j).getImg()) {
                    System.out.println("Imagen repetida");
                    juego.setMomentoCorrecto(true);
                    aux = true;
                } 
            }
        }
        return aux;
    }
    
    
    public void ganarRonda() {
        for (int i=0; i < juego.getCubos().size() ; i++) {
                juego.getCubos().get(i).setBorde(2);
                lblCubos.get(i).setBorder(BorderFactory.createLineBorder(Color.GREEN, 4, true));
        }
        
    }
    public void perderRonda() {
        for (int i=0; i < juego.getCubos().size() ; i++) {
                juego.getCubos().get(i).setBorde(3);
                lblCubos.get(i).setBorder(BorderFactory.createLineBorder(Color.RED, 4, true));
            }
        t.setDelay(5000);
    }
    
    public void detenerEjecucion(int tiempoDelay) {
        
    }
    
    class ManejadorEventos implements KeyListener, MouseListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 32) {
                auxEvento();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnElegir) {
                auxEvento();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
        public void auxEvento() {
            if (juego.isMomentoCorrecto()) {
                    System.out.println("ACERTASTE");
                    ganarRonda();
                    juego.setClickCorrecto(true);
                    juego.setMomentoCorrecto(false);
                    
                } else {
                    System.out.println("FALLASTE");
                }
        }
        
    }
    
    
    
}
