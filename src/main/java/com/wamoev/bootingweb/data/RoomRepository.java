package com.wamoev.bootingweb.data;

import com.wamoev.bootingweb.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
