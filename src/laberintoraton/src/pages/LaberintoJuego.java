package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import app.MainFrame;

public class LaberintoJuego extends JPanel implements KeyListener {
    private int x, y; 
    private Timer timer;
    private int tiempoRestante;
    private final String tipoRaton;
    private final String nivel;
    private String[][] laberinto;
    private boolean saltoDisponible = true; 
    private final MainFrame frame;
    private JLabel timerLabel;
    private long tiempoInicio;
    private final String RECORD_FILE = "record.txt";
    private final boolean haGanado = false;
    private final boolean haPerdido = false;


    public LaberintoJuego(MainFrame frame, String tipoRaton, String nivel) {
        this.frame = frame;
        this.tipoRaton = tipoRaton;
        this.nivel = nivel;

        setFocusable(true);
        addKeyListener(this);
        setLayout(null);
        setBackground(new Color(210, 190, 255)); 

        definirLaberinto(nivel);
        encontrarInicio(); 
        iniciarTemporizador(nivel);
       
        requestFocusInWindow(); 
        
        JButton botonRegresar = new JButton("← Volver al Menú Principal");
        botonRegresar.setBounds(260,650,250, 40);
        botonRegresar.setBackground(new Color(100, 70, 160));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 14));
        add(botonRegresar);

        botonRegresar.addActionListener(_ -> {
            if (timer != null) timer.stop();
            frame.setContentPane(new MainMenuPanel(frame));
            frame.revalidate();
            frame.repaint();
        });
        setFocusable(true);
        requestFocusInWindow();  
    }


    private void definirLaberinto(String nivel) {
        if (nivel.equals("FACIL")) {
            tiempoRestante = 20;
            laberinto = new String[][]{
                {"#", "#", "#", "#", "#", "#", "#", "#", "#"},
                {"#", "I", " ", "#", " ", " ", " ", "S", "#"},
                {"#", " ", " ", "#", " ", "#", "#", "#", "#"},
                {"#", "#", " ", "#", " ", " ", "#", "#", "#"},
                {"#", "#", " ", " ", "#", " ", " ", " ", "#"},
                {"#", "#", "#", " ", "#", "#", "#", " ", "#"},
                {"#", " ", " ", " ", " ", " ", "#", " ", "#"},
                {"#", " ", "#", "#", "#", " ", " ", " ", "#"},
                {"#", "#", "#", "#", "#", "#", "#", "#", "#"}
            };
        }
        else if (nivel.equals("MEDIO")) {
            tiempoRestante = 30;
            laberinto = new String[][]{
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                {"#", "I", " ", " ", "#", "#", " ", "#", "S", " ", "#"},
                {"#", "#", "#", " ", "#", "#", "#", "#", "#", " ", "#"},
                {"#", "#", "#", " ", "#", "#", "#", "#", "#", " ", "#"},
                {"#", " ", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
                {"#", " ", "#", "#", "#", " ", "#", "#", "#", " ", "#"},
                {"#", " ", " ", " ", "#", " ", " ", " ", "#", " ", "#"},
                {"#", "#", "#", " ", "#", "#", "#", " ", "#", " ", "#"},
                {"#", "#", "#", " ", " ", " ", "#", " ", "#", " ", "#"},
                {"#", " ", " ", "#", "#", " ", " ", " ", " ", " ", "#"},
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
            };
        }
        else {
            tiempoRestante = 30;
            laberinto = new String[][]{
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
                {"#", "I", " ", " ", "#", " ", "#", " ", " ", " ", "#", " ", "#", "S", "#"},
                {"#", "#", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"},
                {"#", " ", " ", " ", "#", " ", " ", " ", "#", " ", " ", " ", " ", " ", "#"},
                {"#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#", " ", "#"},
                {"#", " ", "#", " ", " ", " ", " ", "#", " ", " ", " ", " ", "#", " ", "#"},
                {"#", " ", "#", " ", "#", "#", " ", " ", "#", "#", "#", " ", "#", " ", "#"},
                {"#", " ", "#", " ", "#", " ", " ", " ", " ", "#", "#", " ", "#", " ", "#"},
                {"#", " ", "#", "#", "#", " ", "#", "#", " ", "#", " ", " ", "#", " ", "#"},
                {"#", " ", " ", " ", " ", " ", "#", " ", " ", "#", "#", "#", "#", " ", "#"},
                {"#", "#", " ", "#", "#", " ", "#", "#", "#", "#", " ", " ", "#", " ", "#"},
                {"#", " ", " ", " ", "#", " ", " ", " ", " ", "#", " ", "#", "#", " ", "#"},
                {"#", " ", "#", "#", "#", "#", "#", "#", " ", "#", " ", "#", " ", " ", "#"},
                {"#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", "#", " ", "#", "#"},
                {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
            };
        }
    }

    private void encontrarInicio() {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if (laberinto[i][j].equals("I")) {
                    x = j;
                    y = i;
                    return;
                }
            }
        }
    }

    private void iniciarTemporizador(String nivel) {
        tiempoInicio = System.currentTimeMillis();

        // Panel visual para el temporizador
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(null);
        timerPanel.setBackground(new Color(230, 210, 255)); 
        timerPanel.setBounds(320, 10, 140, 50); 
        timerPanel.setBorder(BorderFactory.createLineBorder(new Color(160, 100, 220), 2, true)); 

        timerLabel = new JLabel("Tiempo: " + tiempoRestante);
        timerLabel.setBounds(10, 5, 120, 40);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setForeground(new Color(80, 0, 130)); 
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        timerPanel.add(timerLabel);
        add(timerPanel);

        timer = new Timer(1000, _-> {
            tiempoRestante--;
            timerLabel.setText("Tiempo: " + tiempoRestante);

            if (tiempoRestante <= 10) {
                timerLabel.setForeground(Color.RED); 
                timerPanel.setBackground(new Color(255, 200, 200)); 
                timerPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
            }

            if (tiempoRestante <= 0) {
                timer.stop();
                mostrarResultado(false);
            }
        });
        timer.start();
    }



       
    private void mostrarResultado(boolean gano) {
        long tiempoFinal = (System.currentTimeMillis() - tiempoInicio) / 1000;
        String mensaje = gano ? "¡Ganaste!" : "¡Perdiste por tiempo!";
        long record = obtenerRecord();

        if (gano && (record == -1 || tiempoFinal < record)) {
            guardarRecord(tiempoFinal);
            record = tiempoFinal;
        }

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(165,105,189)); 

        JLabel titulo = new JLabel(mensaje);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(gano ? new Color(108,52,131) : new Color(255, 80, 80));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tiempoLabel = new JLabel("Tu tiempo: " + tiempoFinal + " segundos");
        tiempoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        tiempoLabel.setForeground(Color.WHITE);
        tiempoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel recordLabel = new JLabel("Récord: " + (record == -1 ? "Sin récord previo" : record + " segundos"));
        recordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        recordLabel.setForeground(new Color(180, 200, 255));
        recordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(tiempoLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(recordLabel);
        panel.add(Box.createVerticalStrut(10));

        JOptionPane.showMessageDialog(this, panel, "Resultado del Juego", JOptionPane.PLAIN_MESSAGE);

        frame.showScreen(MainFrame.MENU_SCREEN);
    }


    private long obtenerRecord() {
        try {
            if (Files.exists(Path.of(RECORD_FILE))) {
                String content = Files.readString(Path.of(RECORD_FILE));
                String[] parts = content.split(",");
                if (parts.length >= 3 && parts[1].equals(tipoRaton) && parts[2].equals(nivel)) {
                    return Long.parseLong(parts[0].trim());
                }
            }
        } catch (Exception ignored) {}
        return -1;
    }
    
    private void guardarRecord(long tiempo) {
        try {
            String record = tiempo + "," + tipoRaton + "," + nivel;
            Files.writeString(Path.of(RECORD_FILE), record);
        } catch (IOException e) {
            System.err.println("No se pudo guardar el récord.");
        }
    }


    private boolean puedeMover(int nx, int ny) {
        return ny >= 0 && ny < laberinto.length &&
               nx >= 0 && nx < laberinto[0].length &&
               !laberinto[ny][nx].equals("#");
    }

    private void moverRaton(int dx, int dy) {
        int nuevaX = x + dx;
        int nuevaY = y + dy;

      
        if (puedeMover(nuevaX, nuevaY)) {
            x = nuevaX;
            y = nuevaY;
        }
       
        else if (tipoRaton.equals("BLANCO") && saltoDisponible) {
            int saltoX = nuevaX + dx;
            int saltoY = nuevaY + dy;
            
            if (puedeMover(saltoX, saltoY)) {
                x = saltoX;
                y = saltoY;
                saltoDisponible = false;
            }
        }

        repaint();

        if (laberinto[y][x].equals("S")) {
            timer.stop();
            mostrarResultado(true);
        }
    }

   
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int tileSize = 35;
        int offsetX = 225;
        int offsetY = 100;

        Color lilaBajito = new Color(156, 39, 176);
        Color sombra = new Color(50, 50, 50, 80);
        Font fuenteLetrero = new Font("Arial", Font.BOLD, 14);
        Color fondoLetrero = new Color(123, 31, 162); 

        int labWidth = laberinto[0].length * tileSize;
        int labHeight = laberinto.length * tileSize;

        g2d.setColor(new Color(200, 170, 240));
        g2d.fillRoundRect(offsetX - 15, offsetY - 15, labWidth + 30, labHeight + 30, 30, 30);

        int inicioX = -1, inicioY = -1, salidaX = -1, salidaY = -1;

        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                int x = j * tileSize + offsetX;
                int y = i * tileSize + offsetY;

                g2d.setColor(sombra);
                g2d.fillRect(x + 3, y + 3, tileSize, tileSize);

                switch (laberinto[i][j]) {
                    case "#" -> g2d.setColor(lilaBajito);
                    case "I" -> {
                        g2d.setColor(new Color(50, 205, 50));
                        inicioX = j;
                        inicioY = i;
                    }
                    case "S" -> {
                        g2d.setColor(new Color(65, 105, 225));
                        salidaX = j;
                        salidaY = i;
                    }
                    default -> g2d.setColor(Color.WHITE);
                }

                g2d.fillRect(x, y, tileSize, tileSize);
                g2d.setColor(new Color(220, 220, 220));
                g2d.drawRoundRect(x, y, tileSize, tileSize, 8, 8);
            }
        }

        int ratonX = x * tileSize + offsetX;
        int ratonY = y * tileSize + offsetY;
        Color colorCuerpo = switch (tipoRaton) {
            case "BLANCO" -> Color.WHITE;
            case "CAFE" -> new Color(139, 69, 19);  
            case "PLOMO" -> new Color(100, 100, 100);  
            default -> Color.PINK;
        };

        // Cuerpo principal con contorno
        g2d.setColor(Color.BLACK);
        g2d.fillOval(ratonX + 4, ratonY + 4, tileSize - 8, tileSize - 8); 
        g2d.setColor(colorCuerpo);
        g2d.fillOval(ratonX + 6, ratonY + 6, tileSize - 12, tileSize - 12); 

        // Orejas con contorno
        int tamañoOreja = tileSize/4;
        g2d.setColor(Color.BLACK);
        g2d.fillOval(ratonX + 2, ratonY + 2, tamañoOreja + 2, tamañoOreja + 2); 
        g2d.fillOval(ratonX + tileSize - tamañoOreja - 4, ratonY + 2, tamañoOreja + 2, tamañoOreja + 2); 

        // Interior de orejas
        g2d.setColor(colorCuerpo);
        g2d.fillOval(ratonX + 3, ratonY + 3, tamañoOreja, tamañoOreja);
        g2d.fillOval(ratonX + tileSize - tamañoOreja - 3, ratonY + 3, tamañoOreja, tamañoOreja); 

        // Interior de orejas (rosa)
        g2d.setColor(new Color(255, 200, 200));
        g2d.fillOval(ratonX + 5, ratonY + 5, tamañoOreja - 4, tamañoOreja - 4);
        g2d.fillOval(ratonX + tileSize - tamañoOreja - 1, ratonY + 5, tamañoOreja - 4, tamañoOreja - 4);

        // Ojos
        g2d.setColor(Color.BLACK);
        int tamañoOjo = tileSize/6;
        g2d.fillOval(ratonX + tileSize/3 - tamañoOjo/2, ratonY + tileSize/3, tamañoOjo, tamañoOjo);
        g2d.fillOval(ratonX + 2*tileSize/3 - tamañoOjo/2, ratonY + tileSize/3, tamañoOjo, tamañoOjo);

        // Brillo en los ojos
        g2d.setColor(Color.WHITE);
        int brilloTamaño = tamañoOjo/3;
        g2d.fillOval(ratonX + tileSize/3, ratonY + tileSize/3 + 1, brilloTamaño, brilloTamaño);
        g2d.fillOval(ratonX + 2*tileSize/3, ratonY + tileSize/3 + 1, brilloTamaño, brilloTamaño);

        // Nariz
        g2d.setColor(new Color(255, 120, 150));
        g2d.fillOval(ratonX + tileSize/2 - 3, ratonY + tileSize/2, 6, 4);

        // Bigotes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + 3, ratonY + tileSize/2 - 2);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + 3, ratonY + tileSize/2 + 2);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + 3, ratonY + tileSize/2 + 6);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + tileSize - 3, ratonY + tileSize/2 - 2);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + tileSize - 3, ratonY + tileSize/2 + 2);
        g2d.drawLine(ratonX + tileSize/2, ratonY + tileSize/2 + 2, ratonX + tileSize - 3, ratonY + tileSize/2 + 6);

        if (inicioX != -1 && inicioY != -1) {
            int labelX = inicioX * tileSize + offsetX;
            int labelY = inicioY * tileSize + offsetY - 25;
            g2d.setColor(fondoLetrero);
            g2d.fillRoundRect(labelX - 10, labelY - 20, 80, 25, 15, 15);
            g2d.setColor(Color.WHITE);
            g2d.setFont(fuenteLetrero);
            g2d.drawString("Inicio", labelX, labelY);
        }

        if (salidaX != -1 && salidaY != -1) {
            int labelX = salidaX * tileSize + offsetX;
            int labelY = salidaY * tileSize + offsetY + tileSize + 10;
            g2d.setColor(fondoLetrero);
            g2d.fillRoundRect(labelX - 10, labelY - 15, 80, 25, 15, 15);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Meta", labelX, labelY + 5);
        }
        
        // Confetis si ha ganado
        if (haGanado) {
            for (int i = 0; i < 100; i++) {
                int confetiX = (int)(Math.random() * getWidth());
                int confetiY = (int)(Math.random() * getHeight());
                int tamaño = (int)(Math.random() * 8) + 4;
                Color confetiColor = new Color(
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256),
                    (int)(Math.random() * 256)
                );
                g2d.setColor(confetiColor);
                g2d.fillOval(confetiX, confetiY, tamaño, tamaño);
            }
            if (haGanado) {
            int coronaX = ratonX + tileSize / 4;
            int coronaY = ratonY - 10;
            g2d.setColor(new Color(255, 215, 0)); 
            g2d.fillPolygon(
                new int[]{coronaX, coronaX + 5, coronaX + 10},
                new int[]{coronaY + 10, coronaY, coronaY + 10},
                3
            );
        }

        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawString("¡Ganaste!", getWidth() / 2 - 70, 40);
        }
        //  Pantalla de derrota
        if (haPerdido) {
            g2d.setColor(new Color(91,44,111,180));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            g2d.setColor(Color.RED);
            g2d.drawString("¡Perdiste!", getWidth() / 2 - 70, getHeight() / 2);
        }

            g2d.dispose();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if (tipoRaton.equals("PLOMO")) {

                switch (key) {
                    case KeyEvent.VK_W: case KeyEvent.VK_UP:    moverRaton(0, -1); break;
                    case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  moverRaton(0, 1);  break;
                    case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  moverRaton(-1, 0); break;
                    case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: moverRaton(1, 0);  break;
                    case KeyEvent.VK_Q: moverRaton(-1, -1); break;
                    case KeyEvent.VK_E: moverRaton(1, -1);  break;
                    case KeyEvent.VK_Z: moverRaton(-1, 1);  break;
                    case KeyEvent.VK_C: moverRaton(1, 1);   break;
                }
            } else {
                switch (key) {
                    case KeyEvent.VK_UP:    moverRaton(0, -1); break;
                    case KeyEvent.VK_DOWN:  moverRaton(0, 1);  break;
                    case KeyEvent.VK_LEFT:  moverRaton(-1, 0); break;
                    case KeyEvent.VK_RIGHT: moverRaton(1, 0);  break;
                }
            }
        }

        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
}