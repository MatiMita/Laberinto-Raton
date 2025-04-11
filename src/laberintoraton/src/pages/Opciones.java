package pages;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import app.MainFrame;

public class Opciones extends JPanel {
    //private MainFrame frame;
    public Opciones (MainFrame frame){
       // this.frame = frame;
        setName(MainFrame.OPCIONES_SCREEN);
        setupUI();
    }
        public void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("MENÚ DE OPCIONES - Escoge tu ratón");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(20));

        JButton ratonBlanco = new JButton("Ratón Blanco");
        ratonBlanco.setAlignmentX(CENTER_ALIGNMENT);
        add(ratonBlanco);
        add(Box.createVerticalStrut(10));

        JButton ratonCafe = new JButton("Ratón Café");
        ratonCafe.setAlignmentX(CENTER_ALIGNMENT);
        add(ratonCafe);
        add(Box.createVerticalStrut(10));

        JButton ratonPlomo = new JButton("Ratón Plomo");
        ratonPlomo.setAlignmentX(CENTER_ALIGNMENT);
        add(ratonPlomo);

    }

}
