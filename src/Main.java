import characters.*;
import engine.*;
import model.*;
import javax.swing.SwingUtilities;
import ui.*;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Lobby lobby = new Lobby();
                lobby.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                lobby.setLocationRelativeTo(null);
                lobby.setVisible(true);
            }
        });
    }
}