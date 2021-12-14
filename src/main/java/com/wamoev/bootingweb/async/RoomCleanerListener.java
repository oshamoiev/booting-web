package com.wamoev.bootingweb.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wamoev.bootingweb.models.Room;
import com.wamoev.bootingweb.servises.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final RoomService roomService;
    private final ObjectMapper objectMapper;

    public RoomCleanerListener(RoomService roomService, ObjectMapper objectMapper) {
        this.roomService = roomService;
        this.objectMapper = objectMapper;
    }

    public void receiveMessage(String message) {
        try {
            AsyncPayload asyncPayload = objectMapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(asyncPayload.getModel())) {
                Room room = roomService.getRoomById(asyncPayload.getId());
                LOGGER.info("Room {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else {
                LOGGER.warn("Unknown model type.");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
