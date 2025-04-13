package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import app.MainFrame;

public class Opciones extends JPanel {

    private MainFrame frame;

    public Opciones(MainFrame frame) {
        this.frame = frame;
        setLayout(null);
        setBackground(new Color(210, 190, 255)); // fondo morado más claro

        // Título principal
        JLabel title = new JLabel("MENÚ DE OPCIONES", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(100, 70, 160));
        title.setBounds(150, 50, 500, 40);
        add(title);

        // Subtítulo
        JLabel subTitle = new JLabel("ESCOGE TU RATÓN", SwingConstants.CENTER);
        subTitle.setFont(new Font("Arial", Font.BOLD, 24));
        subTitle.setForeground(new Color(100, 70, 160));
        subTitle.setBounds(200, 100, 400, 30);
        add(subTitle);

        // Botones centrados
        JButton ratonBlanco = new JButton("Ratón Blanco");
        ratonBlanco.setBounds(300, 200, 200, 40);
        styleMouseButton(ratonBlanco);

        JButton ratonCafe = new JButton("Ratón Café");
        ratonCafe.setBounds(300, 260, 200, 40);
        styleMouseButton(ratonCafe);

        JButton ratonPlomo = new JButton("Ratón Plomo");
        ratonPlomo.setBounds(300, 320, 200, 40);
        styleMouseButton(ratonPlomo);

        add(ratonBlanco);
        add(ratonCafe);
        add(ratonPlomo);

        // Botón para volver al menú principal
        JButton botonRegresar = new JButton("← Volver al Menú Principal");
        botonRegresar.setBounds(280, 450, 250, 40);
        botonRegresar.setBackground(new Color(100, 70, 160));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegresar.setFocusPainted(false);
        add(botonRegresar);

        botonRegresar.addActionListener((ActionEvent e) -> {
            frame.showScreen(MainFrame.MENU_SCREEN); // Vuelve a la pantalla principal
        });
    }

    private void styleMouseButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(100, 70, 160));
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
    }
}
