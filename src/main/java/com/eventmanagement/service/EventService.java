
package com.eventmanagement.service;

import com.eventmanagement.dao.EventDAO;
import com.eventmanagement.exception.ValidationException;
import com.eventmanagement.model.Event;
import java.util.Date;
import java.util.List;

public class EventService {
    private final EventDAO eventDao;

    public EventService(EventDAO eventDao) {
        this.eventDao = eventDao;
    }

    public void createEvent(Event event) throws ValidationException {
        validateEvent(event);
        eventDao.saveEvent(event);
    }

    public void deleteEvent(int eventId) {
        eventDao.deleteEvent(eventId);
    }

    public List<Event> getTodaysEvents() {
        Date today = new Date();
        return eventDao.getEventsByDate(today);
    }

    private void validateEvent(Event event) throws ValidationException {
        if (event.getTitle() == null || event.getTitle().trim().isEmpty()) {
            throw new ValidationException("Event title cannot be empty");
        }
        if (event.getEventDate() == null) {
            throw new ValidationException("Event date cannot be null");
        }
    }
} 