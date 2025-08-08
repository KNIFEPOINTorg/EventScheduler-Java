

package com.eventmanagement.ui.gui;

import com.eventmanagement.model.Event;
import com.eventmanagement.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventFormDialog extends JDialog {
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<String> dateComboBox;
    private JButton saveButton;
    private JButton cancelButton;

    public EventFormDialog(Frame owner) {
        super(owner, "Event Form", true);
        setSize(400, 300);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        titleField = new JTextField(20);
        formPanel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        descriptionArea = new JTextArea(4, 20);
        JScrollPane descScroll = new JScrollPane(descriptionArea);
        formPanel.add(descScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Date:"), gbc);
        gbc.gridx = 1;
        dateComboBox = new JComboBox<>(new String[] {"2024-06-01", "2024-06-02", "2024-06-03"});
        formPanel.add(dateComboBox, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EventFormDialog.this, "Save clicked");
                dispose();
            }
        });
        cancelButton.addActionListener(e -> dispose());
    }
} 