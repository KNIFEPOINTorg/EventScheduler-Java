

package com.eventmanagement.dao;

import com.eventmanagement.model.Event;
import java.util.Date;
import java.util.List;

public interface EventDAO {
    void saveEvent(Event event);

    void deleteEvent(int eventId);

    List<Event> getEventsByDate(Date date);

    List<Event> getAllEvents();
} 