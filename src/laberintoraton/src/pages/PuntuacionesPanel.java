package pages;

import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import app.MainFrame;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;


public class PuntuacionesPanel extends JPanel {

    private static final String RECORD_FILE = "record.txt";

    public PuntuacionesPanel(MainFrame frame) {
        setLayout(null);
        setSize(800, 750);
        setLocation(0, 0);
        setVisible(true);
        setBackground(new Color(210, 190, 255)); 

        JLabel titleLabel = new JLabel("Tú record actual es:");
        titleLabel.setBounds(225, 50, 600, 30); 
        titleLabel.setFont(new Font("Arial", BOLD, 32));
        add(titleLabel);

        JLabel recordLabel = new JLabel();
        recordLabel.setBounds(280, 100, 700, 60);
        recordLabel.setFont(new Font("Arial", BOLD, 32));
        recordLabel.setForeground(new Color(100, 70, 160));

        JLabel ratonJLabel = new JLabel();
        ratonJLabel.setBounds(240, 160, 600, 30);
        ratonJLabel.setFont(new Font("Arial", BOLD, 20));
        ratonJLabel.setForeground(new Color(100, 70, 160));
        add(ratonJLabel);

        JLabel nivelJLabel = new JLabel();
        nivelJLabel.setBounds(240, 190, 600, 30);
        nivelJLabel.setFont(new Font("Arial", BOLD, 20));
        nivelJLabel.setForeground(new Color(100, 70, 160));
        add(nivelJLabel);

        try {
            Path path = Path.of(RECORD_FILE);
            if (Files.exists(path)) {
                String recordData = Files.readString(path).trim();
                String[] parts = recordData.split(",");
                
                if (parts.length >= 3) {
                    String time = parts[0];
                    String raton = parts[1];
                    String nivel = parts[2];
                    
                    if (time.equals("1")) {
                        recordLabel.setText(time + " segundo");
                    } else {
                        recordLabel.setText(time + " segundos");
                    }
                    
                    ratonJLabel.setText("Raton seleccionado: " + raton);
                    nivelJLabel.setText("Nivel seleccionado: " + nivel);
                } else {
                    recordLabel.setText("Sin registro");
                    ratonJLabel.setText("Raton seleccionado: Sin registro");
                    nivelJLabel.setText("Nivel seleccionado: Sin registro");
                }
            } else {
                recordLabel.setText("Sin registro");
                ratonJLabel.setText("Raton seleccionado: Sin registro");
                nivelJLabel.setText("Nivel seleccionado: Sin registro");
            }
        } catch (Exception e) {
            recordLabel.setText("No se encontro el archivo de record");
            ratonJLabel.setText("Raton seleccionado: Sin registro");
            nivelJLabel.setText("Nivel seleccionado: Sin registro");
            e.printStackTrace();
        }

        add(recordLabel);

        JButton backButton = new JButton("Volver al menú principal");
        backButton.setBounds(230, 230, 300, 50); // Moved down a bit to make room for the labels
        backButton.setFont(new Font("Arial", BOLD, 20));
        backButton.setBackground(new Color(100, 70, 160));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(_ -> {
            frame.showScreen(MainFrame.MENU_SCREEN);
        });
        add(backButton);
    }
}
