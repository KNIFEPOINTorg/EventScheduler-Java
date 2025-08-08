



import javax.swing.SwingUtilities;

public class GUILauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
} 