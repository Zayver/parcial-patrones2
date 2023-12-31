package com.zayver.parcial.flyweight.repository;

import com.zayver.parcial.flyweight.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {
    SongEntity findByName(String name);
}
