package app;

import pages.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel currentPanel;

    // Constantes para identificar pantallas
    public static final String MENU_SCREEN = "MENU";
    public static final String OPCIONES_SCREEN = "OPCIONES";
    public static final String MAIN_MENU_SCREEN = "MainMenu";

 //public static final String CHARACTER_SELECT_SCREEN = "CHARACTER_SELECT";
    //public static final String GAME_SCREEN = "GAME";
    //public static final String INSTRUCTIONS_SCREEN = "INSTRUCTIONS";
    //public static final String SCORES_SCREEN = "SCORES";
    //public static final String GAME_OVER_SCREEN = "GAME_OVER";
    //public static final String VICTORY_SCREEN = "VICTORY";
    //public static final String SETTINGS_SCREEN = "SETTINGS";

    public MainFrame() {
        setTitle("Laberinto Escape");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        initializeScreens();

        add(mainPanel);
    }

    private void initializeScreens() {
        // Crear la pantalla inicial (menÃº)
        MainMenuPanel menuPanel = new MainMenuPanel(this);
        menuPanel.setName(MENU_SCREEN);
        currentPanel = menuPanel;
        mainPanel.add(currentPanel);
        
       
    }

    public void showScreen(String screenName) {
        mainPanel.removeAll();

        switch(screenName) {
            case MENU_SCREEN:
                currentPanel = new MainMenuPanel(this);
                break;
               
            case OPCIONES_SCREEN:
                currentPanel = new Opciones(this);
                break;
            
            //case INSTRUCTIONS_SCREEN:
              //  currentPanel = new IntructionsPanel(this);
                //((IntructionsPanel)currentPanel).setupUI();
                //break;

            //case CHARACTER_SELECT_SCREEN:
              //  currentPanel = new CharacterSelectPanel(this);
               // ((CharacterSelectPanel)currentPanel).setupUI();
                //break;

            //case VICTORY_SCREEN:
              //  currentPanel = new VictoryPanel(this);
                //((VictoryPanel)currentPanel).setupUI();
                //break;

        }
     
        currentPanel.setName(screenName);
        mainPanel.add(currentPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
        
    }
}