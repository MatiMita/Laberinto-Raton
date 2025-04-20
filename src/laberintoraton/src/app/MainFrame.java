package app;
    import java.awt.FlowLayout;


import pages.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import java.lang.instrument.ClassDefinition;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel currentPanel;

    // Constantes para identificar pantallas
    public static final String MENU_SCREEN = "MENU";
    public static final String OPCIONES_SCREEN = "OPCIONES";
    public static final String MAIN_MENU_SCREEN = "MainMenu";
    public static final String NIVELES_SCREEN = "NIVELES";

 //public static final String CHARACTER_SELECT_SCREEN = "CHARACTER_SELECT";
    //public static final String GAME_SCREEN = "GAME";
    public static final String INSTRUCTIONS_SCREEN = "INSTRUCTIONS";
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

        // Agregar el botón "Volver al Menú" aquí, fuera del juego
    JButton btnVolverMenu = new JButton("Volver al Menú");
    btnVolverMenu.addActionListener(e -> {
        // Detener cualquier temporizador si es necesario y regresar al menú
        setContentPane(new MainMenuPanel(this));  // Cambiar al panel del menú principal
        revalidate();
        repaint();
    });

    // Esto agrega el botón al final del mainPanel, fuera del juego
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));  // Lo coloca a la derecha
    buttonPanel.add(btnVolverMenu);

    // Agregar el botón al panel principal
    mainPanel.add(buttonPanel);

        add(mainPanel);
    }

    private void initializeScreens() {
        // Crear la pantalla inicial (menÃº)
        MainMenuPanel menuPanel = new MainMenuPanel(this);
        menuPanel.setName(MENU_SCREEN);
        currentPanel = menuPanel;
        mainPanel.add(currentPanel);
        
       
    }
    public void showCasillaNiveles(String ratonSeleccionado) {
        setContentPane(new CasillaNiveles(this, ratonSeleccionado));
        revalidate();
    }

    public void showPantallaOpciones() {
        showScreen(OPCIONES_SCREEN);
    }
    private String ultimoRatonSeleccionado;

    public void setUltimoRatonSeleccionado(String raton) {
    this.ultimoRatonSeleccionado = raton;
    }

    public void showGame(String ratonSeleccionado, String nivelSelecconado) {
        LaberintoJuego game = new LaberintoJuego(this, ratonSeleccionado, nivelSelecconado);
        setContentPane(game);
        revalidate();
        repaint();
        game.requestFocusInWindow(); // para que reciba teclas
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
                // Necesitas guardar el ratón previamente o pedirlo de otra forma
                currentPanel = new CasillaNiveles(this, ultimoRatonSeleccionado);
                break;
            
            //case INSTRUCTIONS_SCREEN:
              //  currentPanel = new IntructionsPanel(this);
                //((IntructionsPanel)currentPanel).setupUI();
                //break;
                case INSTRUCTIONS_SCREEN:
            currentPanel = new InstruccionesPanel(this);
            break;

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
    setContentPane(currentPanel);  // <<--- Este es el cambio importante
    revalidate();
    repaint();
}
}