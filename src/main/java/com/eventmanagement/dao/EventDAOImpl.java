

package com.eventmanagement.dao;

import com.eventmanagement.database.DatabaseConnection;
import com.eventmanagement.exception.DatabaseException;
import com.eventmanagement.model.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public void saveEvent(Event event) {
        String sql = "INSERT INTO events (user_id, title, event_date, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, event.getUserId());
            pstmt.setString(2, event.getTitle());
            pstmt.setDate(3, new java.sql.Date(event.getEventDate().getTime()));
            pstmt.setString(4, event.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(int eventId) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> getEventsByDate(Date date) {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE event_date = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(date.getTime()));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    events.add(mapRowToEvent(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                events.add(mapRowToEvent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    private Event mapRowToEvent(ResultSet rs) throws SQLException {
        Event event = new Event();
        event.setId(rs.getInt("id"));
        event.setUserId(rs.getInt("user_id"));
        event.setTitle(rs.getString("title"));
        event.setEventDate(rs.getDate("event_date"));
        event.setDescription(rs.getString("description"));
        return event;
    }
} 