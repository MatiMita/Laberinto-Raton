package pages;

import app.MainFrame;
import javax.swing.*;
import java.awt.*;

public class InstruccionesPanel extends JPanel {

    public InstruccionesPanel(MainFrame frame) {
        setLayout(new BorderLayout());

        // Fondo con gradiente
        setOpaque(false);

        // Título
        JLabel title = new JLabel("INSTRUCCIONES", SwingConstants.CENTER);
        title.setFont(new Font("Monospaced", Font.BOLD, 28));
        title.setForeground(Color.ORANGE);
        add(title, BorderLayout.NORTH);

        // Panel central con los ratones
        JPanel mousePanel = new JPanel(new GridLayout(1, 3, 20, 10));
        mousePanel.setOpaque(false);
        mousePanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));

        mousePanel.add(createMousePanel("Raton café", "El raton cafe se mueve en 4 direcciones", "C:\\Users\\HP 256\\Downloads\\ratoncafe.png"));
        mousePanel.add(createMousePanel("Raton plomo", "El raton plomo puede moverse en las cuatro direcciones y también en las 4 diagonales", "C:\\Users\\HP 256\\Downloads\\ratonblanco.png"));
        mousePanel.add(createMousePanel("Raton blanco", "El raton blanco puede moverse en las 4 direcciones y tiene la habilidad de saltar una pared sin salirse del laberinto", "C:\\Users\\HP 256\\Downloads\\ratonplomo.png"));

        add(mousePanel, BorderLayout.CENTER);

        // Objetivos del juego
        JPanel objetivosPanel = new JPanel();
        objetivosPanel.setOpaque(false);
        objetivosPanel.setLayout(new BoxLayout(objetivosPanel, BoxLayout.Y_AXIS));
        objetivosPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        JLabel objetivosTitle = new JLabel("OBJETIVOS DEL JUEGO:");
        objetivosTitle.setFont(new Font("Monospaced", Font.BOLD, 18));
        objetivosTitle.setForeground(Color.ORANGE);
        objetivosTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        objetivosPanel.add(objetivosTitle);
        objetivosPanel.add(Box.createVerticalStrut(10));

        String[] objetivos = {
            "• Encontrar la salida",
            "• Se pierde por limite de tiempo",
            "• Resuelve en mínimo tiempo",
            "• El ganador será el que resuelva en el menor tiempo posible"
        };

        for (String texto : objetivos) {
            JLabel label = new JLabel(texto);
            label.setFont(new Font("Monospaced", Font.PLAIN, 14));
            label.setForeground(Color.WHITE);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            objetivosPanel.add(label);
        }

        add(objetivosPanel, BorderLayout.SOUTH);

        // Botón volver
        JButton backButton = new JButton("Volver al menú");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> frame.showScreen(MainFrame.MENU_SCREEN));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);
        objetivosPanel.add(Box.createVerticalStrut(10));
        objetivosPanel.add(buttonPanel);
    }

    private JPanel createMousePanel(String title, String desc, String imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Asegúrate de que estas imágenes existen o cámbialas por URLs reales
        JLabel img = new JLabel(new ImageIcon(imagePath));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel("<html><div style='text-align: center;'>" + desc + "</div></html>");
        descLabel.setFont(new Font("Monospaced", Font.PLAIN, 12));
        descLabel.setForeground(Color.WHITE);
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(img);
        panel.add(Box.createVerticalStrut(5));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(descLabel);

        return panel;
    }

    // Degradado de fondo (azul a morado)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        Color color1 = new Color(25, 50, 200);
        Color color2 = new Color(150, 50, 200);
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
    }
}
