package ui;
import ui.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class Lobby extends JFrame {
    private static final int MIN_PLAYERS = 3;
    private static final int MAX_PLAYERS = 12;

    private List<Player> players = new ArrayList<>();
    private JPanel mainMenuPanel;
    private JTextField usernameField;
    private SoftButton addButton;
    private SoftButton startButton;
    public Lobby() {
        super("Mafia Game");
        createMainMenu();
    }

    private void createMainMenu() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null); // Set layout to null for manual positioning
        mainMenuPanel.setPreferredSize(new Dimension(300, 500)); // Set preferred size

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 20); // Set position and size
        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 250, 20); // Set position and size
        addButton = new SoftButton("Add");
        addButton.setBounds(135, 60, 80, 30); // Set position and size
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlayer();
            }
        });

        startButton = new SoftButton("Start");
        startButton.setBounds(235, 60, 80, 30); // Set position and size
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        startButton.setEnabled(false);

        // Create rounded border with soft edges for buttons
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border roundedBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(border, roundedBorder);
        addButton.setBorder(compoundBorder);
        startButton.setBorder(compoundBorder);

        // Add components to main menu panel
        mainMenuPanel.add(usernameLabel);
        mainMenuPanel.add(usernameField);
        mainMenuPanel.add(addButton);
        mainMenuPanel.add(startButton);

        getContentPane().add(BorderLayout.CENTER, mainMenuPanel);

        setSize(400, 500); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    private void addPlayer() {
        if (players.size() >= MAX_PLAYERS) {
            JOptionPane.showMessageDialog(this, "Maximum number of players reached.");
            addButton.setEnabled(false);
            return;
        }

        String username = usernameField.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.");
            return;
        }

        Player newPlayer = new Player(username);
        players.add(newPlayer);
        JOptionPane.showMessageDialog(this, "Player " + username + " added.");
        usernameField.setText("");

        if (players.size() >= MIN_PLAYERS) {
            startButton.setEnabled(true);
            if (players.size() == MAX_PLAYERS) {
                startGame(); // Automatically start the game when maximum players reached
            }
        }
    }

    private void startGame() {
        Game game = new Game();
        for (Player player : players) {
            game.addPlayer(player);
        }
        game.start();
        GameGUI gameGUI = new GameGUI(players);

        setVisible(false);
    }
}