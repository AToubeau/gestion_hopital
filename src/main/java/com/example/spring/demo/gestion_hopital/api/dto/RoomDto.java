package com.example.spring.demo.gestion_hopital.api.dto;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Patient;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;

public record RoomDto(
        Long id,
        String name
) {
    public static RoomDto fromEntity(Room room){
        return new RoomDto(room.getId(), room.getName());
    }
}
