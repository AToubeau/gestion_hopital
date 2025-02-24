package com.example.spring.demo.gestion_hopital.api.form;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;
import jakarta.validation.constraints.NotBlank;

public record RoomForm(
        @NotBlank(message = "Le nom de la chambre est obligatoire!")
        String name
) {
    public Room toEntity(){
        return new Room(name);
    }
}
