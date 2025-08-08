package com.eventmanagement.controller;

import com.eventmanagement.model.Event;
import com.eventmanagement.model.User;
import com.eventmanagement.service.EventService;
import com.eventmanagement.ui.gui.EventFormDialog;
import com.eventmanagement.ui.gui.MainFrame;
import com.eventmanagement.ui.gui.EventListPanel;
import com.eventmanagement.ui.gui.UserPanel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class AppController {
    private MainFrame mainFrame;
    private EventListPanel eventListPanel;
    private UserPanel userPanel;
    private EventService eventService;

    public AppController(MainFrame mainFrame, EventListPanel eventListPanel, UserPanel userPanel, EventService eventService) {
        this.mainFrame = mainFrame;
        this.eventListPanel = eventListPanel;
        this.userPanel = userPanel;
        this.eventService = eventService;
        initListeners();
    }

    private void initListeners() {
        JTable table = getEventTable();
        if (table != null) {
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow >= 0) {
                        }
                    }
                }
            });
        }
    }

    private JTable getEventTable() {
        return null;
    }

    private void openEventForm() {
        EventFormDialog dialog = new EventFormDialog(mainFrame);
        dialog.setVisible(true);
    }

    private void addUser() {
        JOptionPane.showMessageDialog(mainFrame, "Add User logic here");
    }

    public void refreshEvents(List<Event> events) {
        eventListPanel.setEvents(events);
    }


    public void refreshUsers(List<User> users) {
        userPanel.setUsers(users);
    }
} 