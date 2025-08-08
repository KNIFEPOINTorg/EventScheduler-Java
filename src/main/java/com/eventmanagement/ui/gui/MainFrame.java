

package com.eventmanagement.ui.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel statusBar;

    public MainFrame() {
        super("Event Scheduler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setJMenuBar(createMenuBar());

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        statusBar = new JLabel("Ready");
        add(statusBar, BorderLayout.SOUTH);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export to PDF");
        exportItem.addActionListener(e -> exportEventsToPDF());
        fileMenu.add(exportItem);
        fileMenu.addSeparator();
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Event Scheduler v1.0"));
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private void exportEventsToPDF() {
        JOptionPane.showMessageDialog(this, "Export to PDF feature coming soon.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
} 