package app;

import pages.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel currentPanel;

    public static final String MENU_SCREEN = "MENU";
    public static final String OPCIONES_SCREEN = "OPCIONES";
    public static final String MAIN_MENU_SCREEN = "MainMenu";
    public static final String NIVELES_SCREEN = "NIVELES";
    public static final String INSTRUCTIONS_SCREEN = "INSTRUCTIONS";
    public static final String PUNTUACIONES_SCREEN = "PUNTUACIONES";

    public MainFrame() {
        setTitle("Laberinto Escape");
        setSize(800, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        initializeScreens();


        add(mainPanel);
    }

    private void initializeScreens() {
        MainMenuPanel menuPanel = new MainMenuPanel(this);
        menuPanel.setName(MENU_SCREEN);
        currentPanel = menuPanel;
        mainPanel.add(currentPanel);
        
       
    }

    public void showPantallaOpciones() {
        showScreen(OPCIONES_SCREEN);
    }
    private String ultimoRatonSeleccionado = "BLANCO"; 

    public void setUltimoRatonSeleccionado(String raton) {
    this.ultimoRatonSeleccionado = raton;
    }

    public void showGame(String ratonSeleccionado, String nivelSelecconado) {
        LaberintoJuego game = new LaberintoJuego(this, ratonSeleccionado, nivelSelecconado);
        setContentPane(game);
        revalidate();
        repaint();
        game.requestFocusInWindow(); 
    }
    public String getRatonSeleccionado() {
        return this.ultimoRatonSeleccionado;
    }
        
    

    public void showScreen(String screenName) {
    
        switch(screenName) {
            case MENU_SCREEN:
                currentPanel = new MainMenuPanel(this);
                break;
               
            case OPCIONES_SCREEN:
                currentPanel = new Opciones(this);
                break;

            case NIVELES_SCREEN:
                currentPanel = new CasillaNiveles(this, ultimoRatonSeleccionado);
                break;
            
            case INSTRUCTIONS_SCREEN:
                currentPanel = new InstruccionesPanel(this);
                break;
            
            case PUNTUACIONES_SCREEN:
                currentPanel = new PuntuacionesPanel(this);
                break;

        }
     
        currentPanel.setName(screenName);
        setContentPane(currentPanel);
        revalidate();
        repaint();
        
    }
}    
