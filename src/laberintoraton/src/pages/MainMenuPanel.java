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

        JPanel panelPrincipal = new JPanel();
        setBackground(new Color(210, 190, 255));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

       // Título
        JLabel titleLabel = new JLabel("Menú Principal");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(new Color(100, 70, 160));
        panelPrincipal.add(titleLabel);
        panelPrincipal.add(Box.createVerticalStrut(20));
        
        // Botón Iniciar Juego
        JButton startButton = new JButton("Iniciar Juego");
        startButton.addActionListener(_ -> frame.showScreen(MainFrame.OPCIONES_SCREEN));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(startButton);
        panelPrincipal.add(Box.createVerticalStrut(20));
        styleMouseButton(startButton);
        startButton.setMaximumSize(new Dimension(250, 40)); //ancho,alto

        // Botón Instrucciones
        JButton instructionsButton = new JButton("Instrucciones");
        instructionsButton.addActionListener(_ -> frame.showScreen(MainFrame.INSTRUCTIONS_SCREEN));
        instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(instructionsButton);
        panelPrincipal.add(Box.createVerticalStrut(10));   
        styleMouseButton(instructionsButton);
        instructionsButton.setMaximumSize(new Dimension(250, 40));

        // Botón Puntuaciones
        JButton scoresButton = new JButton("Puntuaciones");
        scoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(scoresButton);
        panelPrincipal.add(Box.createVerticalStrut(10));
        styleMouseButton(scoresButton);
        scoresButton.setMaximumSize(new Dimension(250, 40));
        scoresButton.addActionListener(_ -> frame.showScreen(MainFrame.PUNTUACIONES_SCREEN));

        // Botón Salir
        JButton exitButton = new JButton("Salir");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(_ -> System.exit(0));
        panelPrincipal.add(exitButton);
        styleMouseButton(exitButton);
        exitButton.setMaximumSize(new Dimension(250, 40));

        add(panelPrincipal, BorderLayout.CENTER);

        ImageIcon ratonCafeIcon = new ImageIcon(getClass().getResource("resources/code-safers.png"));
        JLabel ratonCafeLabel = new JLabel(ratonCafeIcon);
        ratonCafeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(ratonCafeLabel);
 
    }

    private void styleMouseButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(100, 70, 160));
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
    }
}