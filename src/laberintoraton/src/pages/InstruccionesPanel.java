package pages;

import app.MainFrame;

import javax.swing.*;
import java.awt.*;

public class InstruccionesPanel extends JPanel {

    public InstruccionesPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(210, 190, 255)); // fondo pastel lila

        // Título
        JLabel titulo = new JLabel("INSTRUCCIONES");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(new Color(255, 114, 111)); // color similar al de la imagen
        titulo.setBounds(270, 10, 400, 40);
        add(titulo);

        // ========== IMÁGENES DE RATONES ==========
        ImageIcon ratonCafe = new ImageIcon(getClass().getResource("C:\\Users\\HP 256\\Desktop\\imagenes de los ratones\\ratoncafe.png"));
        JLabel imgCafe = new JLabel(ratonCafe);
        imgCafe.setBounds(60, 70, 100, 100);
        add(imgCafe);

        ImageIcon ratonPlomo = new ImageIcon(getClass().getResource("C:\\Users\\HP 256\\Desktop\\imagenes de los ratones\\ratonplomo1.png"));
        JLabel imgPlomo = new JLabel(ratonPlomo);
        imgPlomo.setBounds(330, 70, 100, 100);
        add(imgPlomo);

        ImageIcon ratonBlanco = new ImageIcon(getClass().getResource("C:\\Users\\HP 256\\Desktop\\imagenes de los ratones\\ratonblanco1.png"));
        JLabel imgBlanco = new JLabel(ratonBlanco);
        imgBlanco.setBounds(590, 70, 100, 100);
        add(imgBlanco);

        // ========== TEXTO DE CADA RATÓN ==========
        JLabel txtCafe = new JLabel("<html>El ratón café<br>se mueve en 4 direcciones</html>");
        txtCafe.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtCafe.setBounds(30, 170, 150, 50);
        add(txtCafe);

        JLabel txtPlomo = new JLabel("<html>El ratón plomo puede moverse<br>en las 4 direcciones<br>y también en las 4 diagonales</html>");
        txtPlomo.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtPlomo.setBounds(260, 170, 200, 60);
        add(txtPlomo);

        JLabel txtBlanco = new JLabel("<html>El ratón blanco puede moverse<br>en 4 direcciones y<br>puede saltar una pared<br>sin salirse del laberinto</html>");
        txtBlanco.setFont(new Font("Courier New", Font.PLAIN, 14));
        txtBlanco.setBounds(510, 170, 250, 80);
        add(txtBlanco);

        // ========== OBJETIVOS DEL JUEGO ==========
        JLabel objTitulo = new JLabel("OBJETIVOS DEL JUEGO:");
        objTitulo.setFont(new Font("Courier New", Font.BOLD, 16));
        objTitulo.setForeground(new Color(255, 114, 111));
        objTitulo.setBounds(270, 270, 300, 30);
        add(objTitulo);

        String objetivos = "<html>" +
                "• Encontrar la salida<br>" +
                "• Se pierde por límite de tiempo<br>" +
                "• Resuelve en mínimo tiempo<br>" +
                "• El ganador será el que resuelva<br>&nbsp;&nbsp;&nbsp;en el menor tiempo posible" +
                "</html>";

        JLabel objetivosLabel = new JLabel(objetivos);
        objetivosLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        objetivosLabel.setBounds(220, 300, 400, 100);
        add(objetivosLabel);

        // ========== BOTÓN DE VOLVER ==========
        JButton volver = new JButton("Volver al Menú");
        volver.setFont(new Font("Arial", Font.BOLD, 16));
        volver.setBounds(300, 450, 200, 40);
        volver.addActionListener(e -> frame.showScreen(MainFrame.MENU_SCREEN));
        add(volver);
    }
}
