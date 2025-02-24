package com.example.spring.demo.gestion_hopital.bll.service;

import com.example.spring.demo.gestion_hopital.dal.domain.entity.Room;

import java.util.List;

public interface RoomService {
    Long create(Room room);
    Room findById(Long id);
    List<Room> findAll();
    void update(Long id, Room room);
    void delete(Long id);
}
