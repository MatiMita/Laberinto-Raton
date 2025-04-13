import javax.swing.*;
import java.awt.*;

public class LaberintoPanel extends JPanel {

    public LaberintoPanel() {
        // Aquí irán las configuraciones iniciales del laberinto
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aquí se dibujará el laberinto
        g.setColor(Color.WHITE);
        g.drawString("Aquí va el laberinto D", 50, 50);
    }
}
