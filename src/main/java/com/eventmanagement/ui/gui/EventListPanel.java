



package com.eventmanagement.ui.gui;

import com.eventmanagement.model.Event;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListPanel extends JPanel {
    private EventTableModel tableModel;
    private JTable table;

    public EventListPanel() {
        setLayout(new BorderLayout());
        tableModel = new EventTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setEvents(List<Event> events) {
        tableModel.setEvents(events);
    }

    private static class EventTableModel extends AbstractTableModel {
        private final String[] columns = {"ID", "User ID", "Title", "Date", "Description"};
        private List<Event> events = new ArrayList<>();

        public void setEvents(List<Event> events) {
            this.events = events != null ? events : new ArrayList<>();
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return events.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Event event = events.get(rowIndex);
            switch (columnIndex) {
                case 0: return event.getId();
                case 1: return event.getUserId();
                case 2: return event.getTitle();
                case 3: return event.getEventDate();
                case 4: return event.getDescription();
                default: return null;
            }
        }
    }
} 