package com.epam.service.impl;

import com.epam.repository.EventRepository;
import com.epam.dto.Event;
import com.epam.dto.EventDto;
import com.epam.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        var entity = new Event();
        BeanUtils.copyProperties(eventDto, entity);
        entity.setDateTime(Instant.now());
        repository.save(entity);
        BeanUtils.copyProperties(entity, eventDto);
        return eventDto;
    }

    @Override
    public EventDto updateEvent(EventDto eventDto) {
        var optionalEvent = repository.findById(eventDto.getId());
        if (optionalEvent.isPresent()) {
            var entity = optionalEvent.get();
            BeanUtils.copyProperties(eventDto, entity);
            entity.setDateTime(Instant.now());
            repository.save(entity);
            return eventDto;
        }
        return null;
    }

    @Override
    public EventDto getEvent(long id) {
        Optional<Event> optionalEvent = repository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            EventDto dto = new EventDto();
            BeanUtils.copyProperties(event, dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean deletedEvent(long id) {
        Optional<Event> optionalEvent = repository.findById(id);
        if (optionalEvent.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EventDto> getAllEvents() {
        return repository.findAll().stream()
                .map(entity -> {
                    var dto = new EventDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEventsByTitle(String title) {
        return repository.findEventsByTitle(title).stream()
                .map(entity -> {
                    var dto = new EventDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
