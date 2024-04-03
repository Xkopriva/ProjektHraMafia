package ui;

import javax.swing.*;
import java.awt.*;

public class SoftButton extends JButton {
    private Color enabledColor;
    private Color disabledColor;
    private int arcSize;

    public SoftButton(String text) {
        super(text);
        this.enabledColor = new Color(153, 255, 153); // Default color for enabled state (green)
        this.disabledColor = new Color(153, 204, 255); // Default color for disabled state (blue)
        this.arcSize = 15; // Default arc size
        setOpaque(true); // Set opaque to true for custom background color
        setContentAreaFilled(false); // Set content area filled to false to avoid default button background
        setForeground(Color.BLACK); // Set text color to white for better visibility
        setFont(getFont().deriveFont(Font.BOLD, 14)); // Customize font style and size
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set button color based on enabled state
        g2d.setColor(isEnabled() ? enabledColor : disabledColor);

        // Fill the background with the button color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcSize, arcSize);

        // Draw the text
        super.paintComponent(g2d);

        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border needed
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 30); // Set preferred button size
    }

    // Method to set the background color of the button when enabled
    public void setEnabledColor(Color enabledColor) {
        this.enabledColor = enabledColor;
        repaint();
    }

    // Method to set the background color of the button when disabled
    public void setDisabledColor(Color disabledColor) {
        this.disabledColor = disabledColor;
        repaint();
    }
}