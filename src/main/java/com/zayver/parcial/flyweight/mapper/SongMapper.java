package com.zayver.parcial.flyweight.mapper;

import com.zayver.parcial.flyweight.domain.Song;
import com.zayver.parcial.flyweight.entity.SongEntity;
import com.zayver.parcial.flyweight.request.SongRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song fromAdapterToDomain(SongEntity entity);

    SongEntity fromDomainToAdapter(Song song);

    SongEntity fromRestToAdapter(SongRequest request);

}
