package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.api.form.RoomForm;
import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;

import java.util.List;

public interface RoomService {
    Room create(RoomForm roomForm);
    Room findById(Long id);
    List<Room> findAll();
    void update(Long id, Room room);
    void delete(Long id);
}
