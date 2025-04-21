package pages;

import app.MainFrame;

import javax.swing.*;
import java.awt.*;

public class InstruccionesPanel extends JPanel {

    public InstruccionesPanel(MainFrame frame) {
        setLayout(null);
        setBackground(new Color(210, 190, 255)); 

        JLabel titulo = new JLabel("INSTRUCCIONES");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setBounds(270, 20, 300, 40);
        titulo.setForeground(new Color(100, 70, 160));
        add(titulo);

        // Ratón café
        ImageIcon ratonCafeIcon = new ImageIcon(getClass().getResource("resources/ratoncafe.png"));
        Image ratonCafeImage = ratonCafeIcon.getImage();
        Image ratonCafeScaled = ratonCafeImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH); 
        JLabel ratonCafeImg = new JLabel(new ImageIcon(ratonCafeScaled));
        ratonCafeImg.setBounds(70, 80, 120, 120); 
        add(ratonCafeImg);

        JLabel textoCafe = new JLabel("<html>El ratón café<br>se mueve en 4<br>direcciones</html>");
        textoCafe.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textoCafe.setBounds(70, 210, 150, 80); 
        add(textoCafe);

        // Ratón plomo
        ImageIcon ratonPlomoIcon = new ImageIcon(getClass().getResource("resources/ratonplomo.png")); 
        Image ratonPlomoImage = ratonPlomoIcon.getImage();
        Image ratonPlomoScaled = ratonPlomoImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH); 
        JLabel ratonPlomoImg = new JLabel(new ImageIcon(ratonPlomoScaled));
        ratonPlomoImg.setBounds(340, 80, 120, 120); 
        add(ratonPlomoImg);

        JLabel textoPlomo = new JLabel("<html>El ratón plomo puede<br>moverse en las cuatro<br>direcciones y también<br>en las 4 diagonales</html>");
        textoPlomo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textoPlomo.setBounds(310, 210, 200, 100); 
        add(textoPlomo);

        ImageIcon ratonBlancoIcon = new ImageIcon(getClass().getResource("resources/ratonblanco.png")); 
        Image ratonBlancoImage = ratonBlancoIcon.getImage();
        Image ratonBlancoScaled = ratonBlancoImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH); 
        JLabel ratonBlancoImg = new JLabel(new ImageIcon(ratonBlancoScaled));
        ratonBlancoImg.setBounds(600, 80, 120, 120); 
        add(ratonBlancoImg);

        JLabel textoBlanco = new JLabel("<html>El ratón blanco puede<br>moverse en las 4<br>direcciones y tiene<br>la habilidad de saltar<br>una pared sin salirse<br>del laberinto</html>");
        textoBlanco.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textoBlanco.setBounds(570, 210, 200, 120);
        add(textoBlanco); 

        JLabel objetivosTitulo = new JLabel("OBJETIVOS DEL JUEGO:");
        objetivosTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        objetivosTitulo.setForeground(new Color(100, 70, 160));
        objetivosTitulo.setBounds(270, 320, 300, 30);
        add(objetivosTitulo);

        JLabel objetivos = new JLabel("<html>"
                + "• Encontrar la salida<br>"
                + "• Se pierde por límite de tiempo<br>"
                + "• Resuelve en mínimo tiempo<br>"
                + "• El ganador será el que resuelva<br>"
                + "&nbsp;&nbsp;en el menor tiempo posible"
                + "</html>");
        objetivos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        objetivos.setBounds(230, 360, 400, 100);
        add(objetivos);

        JButton volverBtn = new JButton("← Volver al Menú Principal");
        volverBtn.setFont(new Font("Arial", Font.BOLD, 14));
        volverBtn.setBackground(new Color(100, 70, 160));
        volverBtn.setForeground(Color.WHITE);
        volverBtn.setFocusPainted(false);
        volverBtn.setBounds(280, 500, 250, 40);
        volverBtn.addActionListener(_ -> {
            frame.showScreen(MainFrame.MENU_SCREEN);
        });
        add(volverBtn);
    }
}
