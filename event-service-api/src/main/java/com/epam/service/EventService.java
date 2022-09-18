package com.epam.service;

import com.epam.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    EventDto createEvent(EventDto eventDto);

    EventDto updateEvent( EventDto eventDto);

    EventDto getEvent(long id);

    boolean deletedEvent(long id);

    List<EventDto> getAllEvents();

    List<EventDto> getAllEventsByTitle(String title);
}
