package com.zayver.parcial.controller;

import com.zayver.parcial.flyweight.domain.Song;
import com.zayver.parcial.flyweight.factory.SongFactory;
import com.zayver.parcial.flyweight.request.SongRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/flyweight")
public class SongController {

    @Autowired
    private SongFactory songFactory;

    @PostMapping
    public ResponseEntity<Object> createSong(@RequestBody SongRequest song){
        songFactory.createSong(song);
        return ResponseEntity.created(URI.create("/flyweight")).build();
    }

    @GetMapping
    public Song getSong(@RequestBody Map<String, String> req){
        return songFactory.getSong(req.get("name"));
    }
}
