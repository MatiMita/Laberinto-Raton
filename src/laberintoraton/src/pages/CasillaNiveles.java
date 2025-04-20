package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import app.MainFrame;

public class CasillaNiveles extends JPanel {
    public CasillaNiveles(MainFrame frame, String ratonSeleccionado) {

        setLayout(null);
        setBackground(new Color(210, 190, 255)); 

        JLabel tituloOpciones = new JLabel("SELECCIONA EL NIVEL", SwingConstants.CENTER);
        tituloOpciones.setFont(new Font("Arial", Font.BOLD, 32));
        tituloOpciones.setForeground(new Color(100, 70, 160));
        tituloOpciones.setBounds(150, 50, 500, 40);
        add(tituloOpciones);

        JButton botonFacil = new JButton("FÁCIL");
        botonFacil.setBounds(300, 200, 200, 40);
        styleButton(botonFacil);
        add(botonFacil);
        botonFacil.addActionListener(e -> {
            frame.showGame(frame.getRatonSeleccionado(), "FACIL");
        
            
        });
        //lola 

        JButton botonMedio = new JButton("MEDIO");
        botonMedio.setBounds(300, 260, 200, 40);
        styleButton(botonMedio);
        add(botonMedio);
        botonMedio.addActionListener(e -> {
            frame.showGame(frame.getRatonSeleccionado(), "MEDIO");
        });

        JButton botonDificil = new JButton("DIFÍCIL");
        botonDificil.setBounds(300, 320, 200, 40);
        styleButton(botonDificil);
        add(botonDificil);
        botonDificil.addActionListener(e -> {
            frame.showGame(frame.getRatonSeleccionado(), "DIFICIL");
        });

       

        JButton botonRegresar = new JButton("← Volver al Menú de Opciones");
        botonRegresar.setBounds(280, 450, 250, 40);
        botonRegresar.setBackground(new Color(100, 70, 160));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegresar.setFocusPainted(false);
        botonRegresar.addActionListener((ActionEvent e) -> {
            frame.showPantallaOpciones();
 });
        add(botonRegresar);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(100, 70, 160));
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
    }

   /*  private void cargarJuego(JFrame frame, String dificultad, String raton) {
        LaberintoPanel juego = new LaberintoPanel(dificultad, raton);
        frame.setContentPane(juego);
        frame.revalidate();
    } */

}