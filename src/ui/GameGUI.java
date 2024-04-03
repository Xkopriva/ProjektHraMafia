package ui;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;
import model.Player;

public class GameGUI extends JFrame {
    private JPanel playerPanel;

    public GameGUI(List<Player> players) {
        super("Mafia Game");
        createGamePanel(players);
    }

    private void createGamePanel(List<Player> players) {
        playerPanel = new CirclePanel();
        playerPanel.setLayout(new CircleLayout());
        for (Player player : players) {
            JLabel playerNameLabel = new JLabel(player.getName());
            playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            playerNameLabel.setFont(getBiggerFont(playerNameLabel.getFont())); // Set bigger font
            playerNameLabel.setForeground(Color.WHITE); // Set text color to white
            playerPanel.add(playerNameLabel);
        }

        getContentPane().add(BorderLayout.CENTER, playerPanel);
        setSize(600, 600); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Method to get a larger font
    private Font getBiggerFont(Font originalFont) {
        Map<TextAttribute, Object> attributes = new HashMap<>(originalFont.getAttributes());
        attributes.put(TextAttribute.SIZE, originalFont.getSize() + 2); // Increase size by 2
        attributes.put(TextAttribute.FOREGROUND, Color.BLACK); // Set color to black
        return originalFont.deriveFont(attributes);
    }

    // Custom panel for drawing the circle background
    private static class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int radius = 150; // Decreased radius for a smaller circle
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            g2d.setColor(Color.BLACK); // Set circle color to black
            g2d.setStroke(new BasicStroke(2)); // Set circle stroke width
            g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius); // Draw circle
        }
    }

    // Custom layout manager for arranging components in a circle
    private static class CircleLayout implements LayoutManager {
        private static final double FULL_ANGLE = 2 * Math.PI;
        private static final int RADIUS = 150; // Decreased radius for a smaller circle
        private static final int X_CENTER = 300; // Center of the frame
        private static final int Y_CENTER = 300;

        @Override
        public void addLayoutComponent(String name, Component comp) {}

        @Override
        public void removeLayoutComponent(Component comp) {}

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(600, 600); // Adjusted preferred size
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return new Dimension(600, 600); // Adjusted minimum size
        }

        @Override
        public void layoutContainer(Container parent) {
            int numComponents = parent.getComponentCount();
            double angleStep = FULL_ANGLE / numComponents;
            double angle = 0;

            for (int i = 0; i < numComponents; i++) {
                Component component = parent.getComponent(i);
                int x = (int) (X_CENTER + RADIUS * Math.cos(angle));
                int y = (int) (Y_CENTER + RADIUS * Math.sin(angle));
                int width = component.getPreferredSize().width;
                int height = component.getPreferredSize().height;
                component.setBounds(x - width / 2, y - height / 2, width, height);
                angle += angleStep;
            }
        }
    }
}