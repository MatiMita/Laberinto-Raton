package pages;

import app.MainFrame;
import javax.swing.*;
import java.awt.*;


public class MainMenuPanel extends JPanel {
    
    public MainMenuPanel(MainFrame frame) {
        setName(MainFrame.MENU_SCREEN);
        setLayout(new BorderLayout());
        setupUI(frame);
    }

    public void setupUI(MainFrame frame) {

        //panel principal con fondo de colores
    JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                Color color1 = new Color(255, 204, 153);
                Color color3 = new Color(102, 102, 255);
                GradientPaint gradiente = new GradientPaint(0, 0, color1, 0, height, color3);
                g2d.setPaint(gradiente);
                g2d.fillRect(0, 0, width, height);

             // Dibujar el borde interior en color negro
             g2d.setColor(Color.BLACK);
             int margin = 30; // Distancia del borde al marco
             g2d.drawRect(margin, margin, width - 2 * margin, height - 2 * margin);
            }
    };
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
       // Título
        JLabel titleLabel = new JLabel("Menú Principal");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        panelPrincipal.add(titleLabel);
        panelPrincipal.add(Box.createVerticalStrut(20));
        
        // Botón Iniciar Juego
        JButton startButton = new JButton("Iniciar Juego");
        startButton.addActionListener(e -> frame.showScreen(MainFrame.OPCIONES_SCREEN));
            //startButton.addActionListener(e -> frame.showScreen(MainFrame.OPCIONES_SCREEN));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(startButton);
        panelPrincipal.add(Box.createVerticalStrut(20));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setMaximumSize(new Dimension(250, 40)); //ancho,alto

        // Botón Instrucciones
        JButton instructionsButton = new JButton("Instrucciones");
       // instructionsButton.addActionListener(e -> frame.showScreen(MainFrame.OPCIONES_SCREEN));

        instructionsButton.addActionListener(e -> frame.showScreen(MainFrame.INSTRUCTIONS_SCREEN));

       instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(instructionsButton);
        panelPrincipal.add(Box.createVerticalStrut(10));   
        instructionsButton.setFont(new Font("Arial", Font.BOLD, 20));
        instructionsButton.setMaximumSize(new Dimension(250, 40));

        // Botón Puntuaciones
        JButton scoresButton = new JButton("Puntuaciones");
          //scoresButton.addActionListener(e -> mainFrame.showScreen(MainFrame.SCORES_SCREEN));
        scoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(scoresButton);
        panelPrincipal.add(Box.createVerticalStrut(10));
        scoresButton.setFont(new Font("Arial", Font.BOLD, 20));
        scoresButton.setMaximumSize(new Dimension(250, 40));

        // Botón Salir
        JButton exitButton = new JButton("Salir");
       exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> System.exit(0));
        panelPrincipal.add(exitButton);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setMaximumSize(new Dimension(250, 40));

 add(panelPrincipal, BorderLayout.CENTER);
    }
}