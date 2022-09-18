package com.epam.dto;

import lombok.Data;

@Data
public class EventDto {
    private long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
}
