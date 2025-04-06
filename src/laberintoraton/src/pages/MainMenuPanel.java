package pages;

import app.MainFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class MainMenuPanel extends JPanel {
    
    public MainMenuPanel(MainFrame frame) {
        setName(MainFrame.MENU_SCREEN);
        setupUI();
    }

    public void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        // Botón Iniciar Juego
        JButton startButton = new JButton("Iniciar Juego");
        //startButton.addActionListener(e -> mainFrame.showScreen(MainFrame.CHARACTER_SELECT_SCREEN));
        add(startButton);
        add(startButton);
        add(Box.createVerticalStrut(5));
        
        // Botón Instrucciones
        JButton instructionsButton = new JButton("Instrucciones");
        //instructionsButton.addActionListener(e -> mainFrame.showScreen(MainFrame.INSTRUCTIONS_SCREEN));
        add(instructionsButton);
        add(instructionsButton);
        add(Box.createVerticalStrut(5));
        
        // Botón Puntuaciones
        JButton scoresButton = new JButton("Puntuaciones");
        //scoresButton.addActionListener(e -> mainFrame.showScreen(MainFrame.SCORES_SCREEN));
        add(scoresButton);
        add(scoresButton);
        add(Box.createVerticalStrut(5));
        
        // Botón Salir
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(_ -> System.exit(0));
        add(exitButton);
        add(exitButton);
    }
}
