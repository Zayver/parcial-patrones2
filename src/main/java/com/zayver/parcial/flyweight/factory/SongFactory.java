package com.zayver.parcial.flyweight.factory;

import com.zayver.parcial.flyweight.domain.Song;
import com.zayver.parcial.flyweight.entity.SongEntity;
import com.zayver.parcial.flyweight.mapper.SongMapper;
import com.zayver.parcial.flyweight.repository.SongRepository;
import com.zayver.parcial.flyweight.request.SongRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SongFactory {
    @Value("${parcial.enable_flyweight}")
    private Boolean ENABLE_FLYWEIGHT;
    private static final Map<String, SongEntity> flyweightPool = new HashMap<>();

    @Value("${parcial.max_pool_size}")
    private Integer MAX_POOL_SIZE;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongMapper songMapper;

    public void createSong(SongRequest songDomain){
        val song = songMapper.fromRestToAdapter(songDomain);
        if(ENABLE_FLYWEIGHT){
            flyweightPool.put(song.getName(), song);
            log.info("Flyweight ENABLED with size: {}", flyweightPool.size());
        }else{
            songRepository.save(song);
        }

        if (flyweightPool.size() > MAX_POOL_SIZE && ENABLE_FLYWEIGHT){
            log.info("Flushing to database...");
            flushToDB();
            flyweightPool.clear();
        }
    }

    public Song getSong(String name){
        if(ENABLE_FLYWEIGHT){
            val search = flyweightPool.get(name);
            if (search != null){
                return songMapper.fromAdapterToDomain(search);
            }
        }
        val search = songRepository.findByName(name);
        if(search == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return songMapper.fromAdapterToDomain(search);
    }

    private void flushToDB(){
        flyweightPool.forEach((ignore, song)->{
            songRepository.save(song);
        });
    }
}
