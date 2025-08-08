
package com.eventmanagement.ui.gui;

import com.eventmanagement.model.User;
import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private JComboBox<User> userComboBox;
    private JButton addUserButton;
    private DefaultComboBoxModel<User> userModel;

    public UserPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        userModel = new DefaultComboBoxModel<>();
        userComboBox = new JComboBox<>(userModel);
        add(userComboBox);

        addUserButton = new JButton("Add User");
        add(addUserButton);

        addUserButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Add User clicked");
        });
    }

    public void setUsers(java.util.List<User> users) {
        userModel.removeAllElements();
        if (users != null) {
            for (User user : users) {
                userModel.addElement(user);
            }
        }
    }

    public User getSelectedUser() {
        return (User) userComboBox.getSelectedItem();
    }
} 