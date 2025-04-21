package pages;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;
import app.MainFrame;

public class Opciones extends JPanel {

    public Opciones(MainFrame frame) {

        setLayout(null);
        setBackground(new Color(210, 190, 255)); 

       
        JLabel tituloOpciones = new JLabel("MENÚ DE OPCIONES", SwingConstants.CENTER);
        tituloOpciones.setFont(new Font("Arial", Font.BOLD, 32));
        tituloOpciones.setForeground(new Color(100, 70, 160));
        tituloOpciones.setBounds(150, 50, 500, 40);
        add(tituloOpciones);

       
        JLabel subTitulo = new JLabel("ESCOGE TU RATÓN", SwingConstants.CENTER);
        subTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        subTitulo.setForeground(new Color(100, 70, 160));
        subTitulo.setBounds(200, 100, 400, 30);
        add(subTitulo);

        
        JButton ratonBlanco = new JButton("Ratón Blanco");
        ratonBlanco.setBounds(300, 200, 200, 40);
        styleMouseButton(ratonBlanco);
        ratonBlanco.addActionListener(_ -> {
           frame.setUltimoRatonSeleccionado("BLANCO");
           frame.showScreen(MainFrame.NIVELES_SCREEN);
        });
        
        JButton ratonCafe = new JButton("Ratón Café");
        ratonCafe.setBounds(300, 260, 200, 40);
        styleMouseButton(ratonCafe);
        ratonCafe.addActionListener(_ -> {
            frame.setUltimoRatonSeleccionado("CAFE");
            frame.showScreen(MainFrame.NIVELES_SCREEN);
        });

        JButton ratonPlomo = new JButton("Ratón Plomo");
        ratonPlomo.setBounds(300, 320, 200, 40);
        styleMouseButton(ratonPlomo);
        ratonPlomo.addActionListener(_ -> {
            frame.setUltimoRatonSeleccionado("PLOMO");
            frame.showScreen(MainFrame.NIVELES_SCREEN); 
        });

        add(ratonBlanco);
        add(ratonCafe);
        add(ratonPlomo);

       
        JButton botonRegresar = new JButton("← Volver al Menú Principal");
        botonRegresar.setBounds(280, 450, 250, 40);
        botonRegresar.setBackground(new Color(100, 70, 160));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegresar.setFocusPainted(false);
        add(botonRegresar);

        botonRegresar.addActionListener(_ -> {
            frame.showScreen(MainFrame.MENU_SCREEN);

        });
    }

    private void styleMouseButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(100, 70, 160));
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
    }
    
}